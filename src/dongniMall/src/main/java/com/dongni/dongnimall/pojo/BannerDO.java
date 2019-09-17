package com.dongni.dongnimall.pojo;

import org.springframework.stereotype.Component;

/**
 * @author cengshuai on 2019-09-05.
 * @version 1.0
 */
@Component
public class BannerDO {

    //ID
    private String id;
    //图片路径
    private String banner_img;
    //是否被应用为轮播图
    private Integer is_used;
    //轮播图对应地址
    private String url;
    //图片上传时间
    private String create_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBanner_img() {
        return banner_img;
    }

    public void setBanner_img(String banner_img) {
        this.banner_img = banner_img;
    }

    public Integer getIs_used() {
        return is_used;
    }

    public void setIs_used(Integer is_used) {
        this.is_used = is_used;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
