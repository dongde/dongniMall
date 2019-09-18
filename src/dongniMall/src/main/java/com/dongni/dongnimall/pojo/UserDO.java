package com.dongni.dongnimall.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
@Component
public class UserDO implements Serializable {
    //用户手机号
    private String phone;
    //用户名
    private String name;
    //用户性别
    private Integer gender;
    //收货地址
    private String address;
    //邮箱
    private String email;
    //邮政编码
    private String postal_code;
    //密码
    private String password;
    //创建时间
    private String create_time;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
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
}
