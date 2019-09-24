package com.dongni.dongnimall.base.storage;

import java.io.File;
import java.io.InputStream;

/**
 * 文件上传
 */
public interface FileUploadManager {
    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    Response upload(File file);

    /**
     * 上传文件流
     *
     * @param inputStream
     * @return
     */
    Response upload(InputStream inputStream);

    /**
     * 删除文件
     *
     * @param key
     */
    void delete(String key);
}
