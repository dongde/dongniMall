package com.dongni.dongnimall.common;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author cengshuai on 2019-09-12.
 * @version 1.0
 */
public class ImageFileUploadUtil {

    public static String uploadFile(MultipartFile file,String imagePath) {
        FileOutputStream fileOutputStream = null;
        InputStream fileInputStream = null;
        String pathDB = "";
        //获取文件名
        String fileName = file.getOriginalFilename();
        if (StringUtils.isNotBlank(fileName)) {
            //生成数据库存储的路径
            String randomStr = UUID.randomUUID().toString();
            System.out.println(fileName);
            pathDB = "/" + randomStr + fileName.substring(0, fileName.indexOf(".")) + ".jpg";
            //生成文件本地存储路径
            String filePath = imagePath + pathDB;
            //创建本地文件
            File newFile = new File(filePath);

            if (newFile.getParentFile() != null || newFile.getParentFile().isDirectory()) {
                //创建父文件夹
                newFile.getParentFile().mkdirs();
            }
            try {
                fileInputStream = file.getInputStream();
                fileOutputStream = new FileOutputStream(newFile);
                IOUtils.copy(fileInputStream, fileOutputStream);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return pathDB;
    }
}
