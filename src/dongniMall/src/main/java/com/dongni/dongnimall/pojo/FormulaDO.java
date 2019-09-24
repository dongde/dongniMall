package com.dongni.dongnimall.pojo;

import java.io.Serializable;

public class FormulaDO implements Serializable {

    private String id;
    private String formulaName;
    private String formulaURL;
    private Float formulaPrice;
    private String formulaDescription;
    private Float samplePrice;
    private Float flyPrice;
    private String factoryAdress;
    private String updateTime;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getFormulaName() {
        return formulaName;
    }

    public void setFormulaName(String formulaName) {
        this.formulaName = formulaName;
    }

    @Override
    public String toString() {
        return "FormulaDO{" +
                "id=" + id +
                ", formulaName='" + formulaName + '\'' +
                ", formulaURL='" + formulaURL + '\'' +
                ", formulaPrice=" + formulaPrice +
                ", formulaDescrition='" + formulaDescription + '\'' +
                ", samplePrice=" + samplePrice +
                ", flyPrice=" + flyPrice +
                ", factoryAdress='" + factoryAdress + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFormulaURL() {
        return formulaURL;
    }

    public void setFormulaURL(String formulaURL) {
        this.formulaURL = formulaURL;
    }

    public Float getFormulaPrice() {
        return formulaPrice;
    }

    public void setFormulaPrice(Float formulaPrice) {
        this.formulaPrice = formulaPrice;
    }

    public String getFormulaDescription() {
        return formulaDescription;
    }

    public void setFormulaDescription(String formulaDescription) {
        this.formulaDescription = formulaDescription;
    }

    public Float getSamplePrice() {
        return samplePrice;
    }

    public void setSamplePrice(Float samplePrice) {
        this.samplePrice = samplePrice;
    }

    public Float getFlyPrice() {
        return flyPrice;
    }

    public void setFlyPrice(Float flyPrice) {
        this.flyPrice = flyPrice;
    }

    public String getFactoryAdress() {
        return factoryAdress;
    }

    public void setFactoryAdress(String factoryAdress) {
        this.factoryAdress = factoryAdress;
    }
}
