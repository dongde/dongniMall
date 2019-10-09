package com.dongni.dongnimall.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class FormulaDO implements Serializable {

    private String id;
    private String formulaName;
    private Float formulaPrice;
    private String formulaDescription;
    private Float samplePrice;
    private Float flyPrice;
    private String factoryAdress;
    private String updateTime;
    private String alipay;
    private String wechat;
    private String bigPicture;

}
