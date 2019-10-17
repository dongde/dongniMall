package com.dongni.dongnimall.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class FormulaVO implements Serializable {

    private String id;
    private String formulaName;
    private Float formulaPrice;
    private String formulaDescription;
    private Float samplePrice;
    private Float flyPrice;
    private String factoryAddress;
    private String updateTime;
    private String bigPicture;
    private String baseStoreId;
    private List<String> images;
}
