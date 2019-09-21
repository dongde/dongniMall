package com.dongni.dongnimall.pojo;


import java.io.Serializable;

/**
 * 新闻资讯对应实体类
 */
public class ActicleDO implements Serializable {

    private String id;
    private String title;
    private String source;
    private String imageURL;
    private String summary;
    private String content;
    private String updateTime;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUpdateTime() {
        return updateTime;
    }
    @Override
    public String toString() {
        return "ActicleDO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
