package com.dongni.dongnimall.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author cengshuai on 2019-11-07.
 * @version 1.0
 */
@Component
@Data
public class RecInfoVO {
    //id
    private String id;
    //收货人昵称
    private String name;
    //用户账号
    private String user_phone;
    //收货人账号
    private String rec_phone;
    //省
    private String province;
    //市
    private String city;
    //区
    private String area;
    //街道
    private String street;
    //默认收获人信息
    private Integer status;
}
