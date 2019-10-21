package com.dongni.dongnimall.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author cengshuai on 2019-10-21.
 * @version 1.0
 */
@Component
@Data
public class FormulaUploadDO {
    //id
    private String id;
    //上传配方的名称
    private String formula_upload_name;
    //用户账号
    private String user_phone;
    //炒料过程
    private String flour_process;
    //煮锅方法
    private String cooking_pot_method;
    //配方描述
    private String description;
    //上传时间
    private String create_time;
    //审核状态
    private Integer status;
    //原料
    List<RawMaterialDO> rawMaterialDOList;
}
