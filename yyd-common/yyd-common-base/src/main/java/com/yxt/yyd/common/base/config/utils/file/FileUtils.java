package com.yxt.yyd.common.base.config.utils.file;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.yxt.yyd.common.core.result.ResultBean;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author dimengzhe
 * @Date 2021/11/7 11:48
 * @Description 文件上传工具类
 */
@Component
public class FileUtils {

    private static final Logger L = LoggerFactory.getLogger(FileUtils.class);

    @Value("${image.upload.path:static/upload/}")
    private String uploadPath;

    @Value("${image.url.prefix:http://127.0.0.1:8111/upload/}")
    private String urlPrefix;

    public String getUploadPath() {
        return uploadPath;
    }

    public String getUrlPrefix() {
        return urlPrefix;
    }

    /**
     * 上传文件
     *
     * @param file         上传的文件
     * @param hasDateDir   是否创建日期目录
     * @param relativePath 指定的目录
     * @return
     */
    public ResultBean<FileUploadResult> uploadFile(MultipartFile file, boolean hasDateDir, String relativePath) {
        ResultBean<FileUploadResult> resultBean = ResultBean.fireFail();
        //文件大小
        int width = 0;
        int heigh = 0;
        long size = file.getSize();
        String fileSize = getPrintSize(size);
        // 文件名
        String fileName = file.getOriginalFilename();
        // 后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String prefixName = fileName.substring(0, fileName.indexOf("."));
        // 新文件名:文件原名称 + ‘-’ + 生成的时间戳 2021.10.16
        String filePath = prefixName + "_" + dateFileName() + suffixName;
        if (hasDateDir) {
            String dateStr = DateUtil.format(new Date(), "yyyy-MM-dd");
            List<String> stringList = Arrays.asList(dateStr.split("-"));
            //年
            String year = stringList.get(0);
            //月
            String month = stringList.get(1);
            //日
            String day = stringList.get(2);
            dateStr = year + "/" + month + "/" + day;
            // 增加日期目录
            filePath = dateStr + "/" + filePath;
        }
        if (StringUtils.isNotBlank(relativePath)) {
            // 增加指定目录
            filePath = relativePath + "/" + filePath;
        }
        // 上传后的文件含完整路径
        String path = uploadPath + filePath;
        // 上传后的文件
        File destFile = new File(path);

        if (!destFile.getParentFile().exists()) {
            destFile.getParentFile().mkdirs();
        }

        try {
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage != null) {
                width = bufferedImage.getWidth();
                heigh = bufferedImage.getHeight();
            }
            file.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fullUrl = urlPrefix + filePath;
        FileUploadResult fileUploadResult =
                new FileUploadResult(fileName, filePath, fullUrl, fileSize, width, heigh);
        return resultBean.success().setData(fileUploadResult);
    }

    public static String getPrintSize(long size) {
        // 如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义
        if (size < 1024) {
            return String.valueOf(size) + "B";
        } else {
            size = size / 1024;
        }
        // 如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位
        // 因为还没有到达要使用另一个单位的时候
        // 接下去以此类推
        if (size < 1024) {
            return String.valueOf(size) + "KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            // 因为如果以MB为单位的话，要保留最后1位小数，
            // 因此，把此数乘以100之后再取余
            size = size * 100;
            return String.valueOf((size / 100)) + "." + String.valueOf((size % 100)) + "MB";
        } else {
            // 否则如果要以GB为单位的，先除于1024再作同样的处理
            size = size * 100 / 1024;
            return String.valueOf((size / 100)) + "." + String.valueOf((size % 100)) + "GB";
        }
    }

    private String dateFileName() {
        return DateUtil.format(new Date(), "yyyyMMddHHmmssSSS") + RandomUtil.randomNumbers(3);
    }


}
