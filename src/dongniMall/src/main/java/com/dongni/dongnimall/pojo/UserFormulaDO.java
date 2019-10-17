package com.dongni.dongnimall.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author cengshuai on 2019-10-17.
 * @version 1.0
 */
@Component
@Data
public class UserFormulaDO {
    //id
    private String id;
    //用户账号
    private String user_phone;
    //配方ID
    private String formula_id;
    //创建时间
    private String create_time;
}
