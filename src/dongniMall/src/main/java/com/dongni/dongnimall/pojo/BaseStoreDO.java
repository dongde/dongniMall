package com.dongni.dongnimall.pojo;

import lombok.Data;

/**
 * 底料商城对应实体类
 */
@Data
public class BaseStoreDO {


    private String id;
    private String tradeName;
    private String tradeType;
    private Float price;
    private String tradeURL;
    private String bigImage;
    private Integer viewCount;
    private String updateTime;
    private String content;
    private String Alipay;
    private String wechat;

}
