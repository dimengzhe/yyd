package com.yxt.yyd.common.base.config.web;

import com.yxt.yyd.common.base.config.utils.file.FileUploadResult;
import com.yxt.yyd.common.base.config.utils.file.FileUtils;
import com.yxt.yyd.common.core.result.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author dimengzhe
 * @Date 2021/11/19 14:15
 * @Description
 */
@Api(tags = "文件上传和下载的通用控制方法")
@RequestMapping("/file")
@RestController
public class FileController {

    @Autowired
    private FileUtils fileUtils;

    @ApiOperation(value = "上传文件")
    @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "MultipartFile", dataTypeClass = MultipartFile.class)
    @PostMapping("/upload")
    public ResultBean<FileUploadResult> uploadImage(@RequestParam(value = "file") MultipartFile file) {
        ResultBean rb = ResultBean.fireFail();
        if (file == null || file.isEmpty()) {
            return rb.setMsg("文件为空");
        }

        rb = fileUtils.uploadFile(file, true,"null");
        return rb;
    }
}
