package com.dongni.dongnimall.base.storage;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;

@Service
public class FileUploadManagerImpl implements FileUploadManager {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadManagerImpl.class);
    @Autowired
    private QiniuProperties qiniuProperties;
    @Autowired
    private UploadManager uploadManager;
    @Autowired
    private BucketManager bucketManager;
    @Autowired
    private StringMap putPolicy;
    @Autowired
    private Gson gson;
    @Autowired
    private Auth auth;

    @Override
    public Response upload(File file) {
        try {
            com.qiniu.http.Response response = uploadManager.put(file, null, getUploadToken());
            int retry = 0;
            while (response.needRetry() && retry < 3) {
                response = uploadManager.put(file, null, getUploadToken());
                retry++;
            }
            return getFileUploadResponse(response);
        } catch (QiniuException e) {
            logger.error("文件上传到七牛服务器出错:", e);
            throw new RuntimeException("文件上传到七牛服务器出错:", e);
        }
    }

    @Override
    public Response upload(InputStream inputStream) {
        try {
            com.qiniu.http.Response response = uploadManager.put(inputStream, null, getUploadToken(), null, null);
            int retry = 0;
            while (response.needRetry() && retry < 3) {
                response = uploadManager.put(inputStream, null, getUploadToken(), null, null);
                retry++;
            }
            return getFileUploadResponse(response);
        } catch (QiniuException e) {
            logger.error("文件上传到七牛服务器出错:", e);
            throw new RuntimeException("文件上传到七牛服务器出错:", e);
        }
    }

    @Override
    public void delete(String key) {
        try {
            com.qiniu.http.Response response = bucketManager.delete(qiniuProperties.getBucket(), key);
            int retry = 0;
            while (response.needRetry() && retry++ < 3) {
                response = bucketManager.delete(qiniuProperties.getBucket(), key);
            }
        } catch (QiniuException e) {
            logger.error("删除文件出错:", e);
            throw new RuntimeException("删除文件:", e);
        }
    }

    /**
     * 获取上传凭证
     *
     * @return
     */
    private String getUploadToken() {
        return auth.uploadToken(qiniuProperties.getBucket(), null, 3600, putPolicy);
    }

    /**
     * 获取链接地址
     *
     * @param response
     * @return
     * @throws QiniuException
     */
    private Response getFileUploadResponse(com.qiniu.http.Response response) throws QiniuException {
        DefaultPutRet putRet = gson.fromJson(response.bodyString(), DefaultPutRet.class);
        Response fresp = new Response();
        fresp.setKey(putRet.key);
        fresp.setUrl(qiniuProperties.getPath() + putRet.key);
        return fresp;
    }
}
