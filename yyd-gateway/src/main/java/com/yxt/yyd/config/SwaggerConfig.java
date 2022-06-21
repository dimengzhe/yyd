/*
package com.yxt.yyd.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * @Author dimengzhe
 * @Date 2022/4/3 0:13
 * @Description
 *//*

@Component
@Primary
public class SwaggerConfig implements SwaggerResourcesProvider {

    @Override
    public List<SwaggerResource> get() {

        List resources = new ArrayList<>();

        */
/**
         * shopping-member ---> 这个就是个模块的名字，可以随便起
         * /member/v2/api-docs ---> member就是application.yml配置的路由路径，后面的/v2/api-docs固定写法
         *//*

        resources.add(swaggerResource("yyd-system", "/member/v2/api-docs", "2.0"));

        return resources;
    }

    private Object swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
*/
