package com.dongni.dongnimall.pojo;

import org.springframework.stereotype.Component;

/**
 * @author cengshuai on 2019-09-11.
 * @version 1.0
 */
@Component
public class TeachVideoDO {
    //ID
    private String id;
    //封面图片
    private String cover;
    //视频地址
    private String videoUrl;
    //标题
    private String title;
    //视频介绍
    private String introduction;
    //创建时间
    private String create_time;
    //访问次数
    private Integer counts;
    //视频内容
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
