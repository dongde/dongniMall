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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
