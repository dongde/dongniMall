package com.dongni.dongnimall.vo;

import lombok.Data;

import java.util.List;

@Data
public class FormulaVO {

    private String id;
    private String formulaName;
    private String formulaURL;
    private Float formulaPrice;
    private String formulaDescription;
    private Float samplePrice;
    private Float flyPrice;
    private String factoryAdress;
    private String updateTime;
    private String alipay;
    private String wechat;
    private String bigPicture;
    private List<String> images;

}
