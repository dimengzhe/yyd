package com.yxt.yyd.log;

import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSON;
import com.yxt.yyd.common.utils.convert.StringUtil;
import com.yxt.yyd.config.IgnoreWhiteProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * @Author dimengzhe
 * @Date 2022/11/6 23:57
 * @Description
 */
@Slf4j
@Component
public class GlobalLogFilter implements GlobalFilter, Ordered {

    @Autowired
    private CustomGatewayProperties customGatewayProperties;

    private static final String START_TIME = "startTime";
    // 排除过滤的 uri 地址，nacos自行添加
    @Autowired
    private IgnoreWhiteProperties ignoreWhite;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String urlPath = exchange.getRequest().getURI().getPath();
        //1.uri白名单。  跳过不需要验证的路径
       if (StringUtil.matchesTwo(urlPath, ignoreWhite.getWhitesTwo())) {
            return chain.filter(exchange);
        }
        ServerHttpRequest request = exchange.getRequest();
        String path = getOriginalRequestUrl(exchange);
        String url = Objects.requireNonNull(request.getMethod()).name() + " " + path;
        // 读取 nacos 是否开启日志
       /* if (!customGatewayProperties.getRequestLog()) {
            return chain.filter(exchange);
        }*/
        // 打印请求参数
        if (isJsonRequest(request)) {
            String jsonParam = resolveBodyFromRequest(request);
            log.debug("[PLUS]开始请求 => URL[{}],参数类型[json],参数:[{}]", url, jsonParam);
        } else {
            MultiValueMap<String, String> parameterMap = request.getQueryParams();
            if (MapUtil.isNotEmpty(parameterMap)) {
                String parameters = JSON.toJSONString(parameterMap);
                log.debug("[PLUS]开始请求 => URL[{}],参数类型[param],参数:[{}]", url, parameters);
            } else {
                log.debug("[PLUS]开始请求 => URL[{}],无参数", url);
            }
        }

        exchange.getAttributes().put(START_TIME, System.currentTimeMillis());
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long startTime = exchange.getAttribute(START_TIME);
            if (startTime != null) {
                long executeTime = (System.currentTimeMillis() - startTime);
                log.debug("[PLUS]结束请求 => URL[{}],耗时:[{}]毫秒", url, executeTime);
            }
        }));
    }

    @Override
    public int getOrder() {
        // 一定要放在最后
        return Ordered.LOWEST_PRECEDENCE;
    }

    /**
     * 判断本次请求的数据类型是否为json
     */
    private boolean isJsonRequest(ServerHttpRequest request) {
        MediaType contentType = request.getHeaders().getContentType();
        if (contentType != null) {
            return StringUtils.startsWithIgnoreCase(contentType.toString(), MediaType.APPLICATION_JSON_VALUE);
        }
        return false;
    }

    /**
     * 读取body
     */
    private String resolveBodyFromRequest(ServerHttpRequest serverHttpRequest) {
        //获取请求体
        Flux<DataBuffer> body = serverHttpRequest.getBody();
        StringBuilder sb = new StringBuilder();
        body.subscribe(buffer -> {
            byte[] bytes = new byte[buffer.readableByteCount()];
            buffer.read(bytes);
            String bodyString = new String(bytes, StandardCharsets.UTF_8);
            sb.append(bodyString);
        });
        return sb.toString();
    }

    /**
     * 获取原始请求路径
     */
    public static String getOriginalRequestUrl(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        LinkedHashSet<URI> uris = exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
        URI requestUri = uris.stream().findFirst().orElse(request.getURI());
        return UriComponentsBuilder.fromPath(requestUri.getRawPath()).build().toUriString();
    }
}
