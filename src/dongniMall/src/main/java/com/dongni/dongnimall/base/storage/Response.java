package com.dongni.dongnimall.base.storage;

import lombok.Data;

import java.io.Serializable;

/**
 * 文件上传放回对象
 */
@Data
public class Response implements Serializable {
    /**
     * 键值
     */
    private String key;
    /**
     * 访问URL
     */
    private String url;
}
