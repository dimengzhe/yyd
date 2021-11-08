package com.yxt.yyd.common.base.utils.file;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author dimengzhe
 * @Date 2021/11/7 11:51
 * @Description
 */
@ApiModel(description = "文件上传结果")
public class FileUploadResult {

    @ApiModelProperty("上传的原文件名")
    private String sourceFileName;
    @ApiModelProperty("文件的相对路径")
    private String filePath;
    @ApiModelProperty("文件完整的访问URL")
    private String fullUrl;
    @ApiModelProperty("文件大小")
    private String size;

    public String getSourceFileName() {
        return sourceFileName;
    }

    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public FileUploadResult() {
    }

    public FileUploadResult(String sourceFileName, String filePath, String fullUrl, String size) {
        this.sourceFileName = sourceFileName;
        this.filePath = filePath;
        this.fullUrl = fullUrl;
        this.size = size;
    }
}
