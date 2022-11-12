package com.yxt.yyd.file.biz.service;

import com.yxt.yyd.common.core.result.ResultBean;
import com.yxt.yyd.demo.api.domain.FileUploadResult;
import com.yxt.yyd.file.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author dimengzhe
 * @Date 2022/11/6 22:33
 * @Description
 */
@Service
public class FileService {

    @Autowired
    private FileUtils fileUtils;

    public ResultBean<FileUploadResult> uploadImage(MultipartFile file, String path) {
        ResultBean<FileUploadResult> rb = ResultBean.fireFail();
        if (file == null || file.isEmpty()) {
            return rb.setMsg("文件为空");
        }

        rb = fileUtils.uploadFile(file, true, path);
        return rb;
    }
}
