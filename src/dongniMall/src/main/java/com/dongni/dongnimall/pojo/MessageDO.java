package com.dongni.dongnimall.pojo;

import org.springframework.stereotype.Component;

/**
 * @author cengshuai on 2019-09-25.
 * @version 1.0
 */
@Component
public class MessageDO {
    //id
    private String id;
    //用户账号
    private String user_phone;
    //消息内容
    private String content;
    //创建时间
    private String create_time;
    //消息类型
    private Integer type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
