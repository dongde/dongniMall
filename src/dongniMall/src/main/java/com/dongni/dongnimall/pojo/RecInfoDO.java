package com.dongni.dongnimall.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author cengshuai on 2019-11-02.
 * @version 1.0
 */
@Component
@Data
public class RecInfoDO {
    //id
    private String id;
    //收货人昵称
    private String name;
    //用户账号
    private String user_phone;
    //收货人账号
    private String rec_phone;
    //收货人地址
    private String address;
    //默认收获人信息
    private Integer status;
}
