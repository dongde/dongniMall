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
public class FormulaTransactionRecordVO {
    //id
    private String id;
    //配方ID
    private String formula_id;
    //用户账号
    private String user_phone;
    //支付金额
    private BigDecimal payment_amount;
    //支付方式
    private Integer payment_method;
    //支付状态
    private Integer payment_status;
    //记录创建时间
    private String create_time;
    //用户昵称
    private String user_name;
    //配方名称
    private String formula_name;
}
