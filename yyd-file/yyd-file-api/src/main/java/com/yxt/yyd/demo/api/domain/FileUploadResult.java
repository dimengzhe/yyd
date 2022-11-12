package com.yxt.yyd.demo.api.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author dimengzhe
 * @Date 2022/11/6 16:37
 * @Description 文件上传结果
 */
public class FileUploadResult {

    @ApiModelProperty("上传的原文件名")
    private String sourceFileName;
    @ApiModelProperty("文件的相对路径")
    private String filePath;
    @ApiModelProperty("文件完整的访问URL")
    private String fullUrl;
    @ApiModelProperty("文件大小")
    private String size;
    @ApiModelProperty(value = "宽度")
    private int width;
    @ApiModelProperty(value = "高度")
    private int height;

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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public FileUploadResult(String sourceFileName, String filePath, String fullUrl, String size, int width, int height) {
        this.sourceFileName = sourceFileName;
        this.filePath = filePath;
        this.fullUrl = fullUrl;
        this.size = size;
        this.height = height;
        this.width = width;
    }
}
