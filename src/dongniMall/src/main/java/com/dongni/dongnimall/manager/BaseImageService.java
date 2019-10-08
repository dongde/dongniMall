package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.BaseImageDO;
import com.dongni.dongnimall.vo.JsonResult;

/**
 * 底料图片存储
 */
public interface BaseImageService {

    JsonResult findAllbyID(String id);

    void insertImageURL(BaseImageDO baseImageDO);

    BaseImageDO findByURL(String url);

    BaseImageDO findID(String imageId);

    void updateMessage(BaseImageDO baseImageDO);

    JsonResult deleteByID(String[] ids);
}
