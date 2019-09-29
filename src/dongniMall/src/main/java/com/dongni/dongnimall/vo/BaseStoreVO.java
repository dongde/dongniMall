package com.dongni.dongnimall.vo;

import lombok.Data;

import java.util.List;

@Data
public class BaseStoreVO {


    private String id;
    private String tradeName;
    private String tradeType;
    private Float price;
    private String tradeURL;
    private List<String> imageURLs;
    private Integer viewCount;
    private String updateTime;
    private String content;

}
