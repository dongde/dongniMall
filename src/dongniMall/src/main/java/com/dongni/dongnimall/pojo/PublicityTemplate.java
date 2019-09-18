package com.dongni.dongnimall.pojo;

/**
 * 宣传模板实体类
 */
public class PublicityTemplate {

    private Integer id;
    private String templateName;
    private String templateType;
    private String textDescription;
    private String image;
    private Float price;
    private String updateTime;

    @Override
    public String toString() {
        return "PublicityTemplate{" +
                "id=" + id +
                ", templateName='" + templateName + '\'' +
                ", templateType='" + templateType + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
