package com.yxt.yyd.demo.api.feigns;

import com.yxt.yyd.common.core.result.ResultBean;
import com.yxt.yyd.demo.api.domain.FileUploadResult;
import com.yxt.yyd.demo.api.fallback.FileFeignFallback;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author dimengzhe
 * @Date 2022/11/6 22:20
 * @Description
 */
@Api(tags = "文件上传管理")
@FeignClient(
        contextId = "file-File",
        name = "yyd-file",
        path = "v1/file",
        fallback = FileFeignFallback.class)
public interface FileFeign {

    @ApiOperation(value = "上传文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "path", value = "路径", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "MultipartFile", dataTypeClass = MultipartFile.class)
    })
    @PostMapping("/upload")
    @ResponseBody
    public ResultBean<FileUploadResult> uploadImage(@RequestPart(value = "file") MultipartFile file,
                                                    @RequestParam(value = "path", required = false) String path);
}
