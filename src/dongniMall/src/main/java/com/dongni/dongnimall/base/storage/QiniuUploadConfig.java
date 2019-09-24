package com.dongni.dongnimall.base.storage;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 七牛文件上传配置器
 */
@Configuration
public class QiniuUploadConfig {
    /**
     * 华东机房,配置自己空间所在的区域
     */
    @Bean
    public com.qiniu.storage.Configuration qiniuConfig() {
        return new com.qiniu.storage.Configuration(Zone.zone0());
    }

    /**
     * 构建一个七牛上传工具实例
     *
     * @param qiniuConfig
     * @return
     */
    @Bean
    public UploadManager uploadManager(com.qiniu.storage.Configuration qiniuConfig) {
        return new UploadManager(qiniuConfig);
    }

    @Bean
    public Auth auth(QiniuProperties qiniuProperties) {
        return Auth.create(qiniuProperties.getAccessKey(), qiniuProperties.getSecretKey());
    }

    /**
     * 构建七牛空间管理实例
     *
     * @param auth
     * @param qiniuConfig
     * @return
     */
    @Bean
    public BucketManager bucketManager(Auth auth, com.qiniu.storage.Configuration qiniuConfig) {
        return new BucketManager(auth, qiniuConfig);
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }

    /**
     * 定义七牛云上传的相关策略
     *
     * @return
     */
    @Bean
    public StringMap putPolicy() {
        StringMap stringMap = new StringMap();
        stringMap.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"width\":$(imageInfo.width), \"height\":${imageInfo.height}}");
        return stringMap;
    }
}
