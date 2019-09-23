package com.dongni.dongnimall.vo;

import org.springframework.stereotype.Component;

/**
 * @author cengshuai on 2019-09-21.
 * @version 1.0
 */
@Component
public class ManagerVO {
    //管理员ID
    private String id;
    //管理员名
    private String name;
    //管理员密码
    private String password;
    //创建时间
    private String create_time;
    //权限等级
    private int permission;
    //token值
    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
