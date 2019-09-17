package com.dongni.dongnimall.pojo;

/**
 * @author cengshuai on 2019-09-16.
 * @version 1.0
 */
public class LeaveMessageDO {
    //ID
    private String id;
    //留言内容
    private String content;
    //留言用户ID
    private String user_id;
    //留言接收对象ID
    private String recipient_id;
    //创建时间
    private String create_time;
    //审核状态
    private Integer verify;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(String recipient_id) {
        this.recipient_id = recipient_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Integer getVerify() {
        return verify;
    }

    public void setVerify(Integer verify) {
        this.verify = verify;
    }
}
