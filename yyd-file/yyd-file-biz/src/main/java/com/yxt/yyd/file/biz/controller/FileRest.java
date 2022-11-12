package com.yxt.yyd.file.biz.controller;

import com.yxt.yyd.common.core.result.ResultBean;
import com.yxt.yyd.demo.api.domain.FileUploadResult;
import com.yxt.yyd.demo.api.feigns.FileFeign;
import com.yxt.yyd.file.biz.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author dimengzhe
 * @Date 2022/11/6 22:31
 * @Description
 */
@Controller
@RequestMapping(value = "v1/file")
public class FileRest implements FileFeign {
    @Autowired
    private FileService fileService;

    @Override
    public ResultBean<FileUploadResult> uploadImage(MultipartFile file, String path) {
        return fileService.uploadImage(file, path);
    }
}
