package com.dongni.dongnimall.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author cengshuai on 2019-10-17.
 * @version 1.0
 */
@Component
@Data
public class UserFormulaVO {
    //id
    private String id;
    //用户账号
    private String user_phone;
    //配方ID
    private String formula_id;
    //配方图片
    private String formula_img;
    //配方名称
    private String formula_name;
    //配方价格
    private Float formula_price;
    //配方下载地址
    private String formula_file;
    //创建时间
    private String create_time;

}
