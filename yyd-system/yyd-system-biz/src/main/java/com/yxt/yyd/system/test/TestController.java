package com.yxt.yyd.system.test;

import com.yxt.yyd.common.base.utils.pdf.PdfUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author dimengzhe
 * @Date 2022/5/16 16:39
 * @Description
 */
public class TestController {

    public static void main(String[] args) throws IOException {
        List<File> files = new ArrayList();
        File file = new File("D:\\anrui\\temp");
        File[] tempList = file.listFiles();
        //获取该文件夹下的文件（文件都是PDF）
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                files.add(tempList[i]);
            }
        }
        try {
            File f = PdfUtils.mulFile2One(files, "D:\\anrui\\temp\\pdf\\合成PDF.pdf");//需创建一个空白的pdf
            System.out.println(f.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
