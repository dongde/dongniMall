package com.dongni.dongnimall.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author cengshuai on 2019-10-21.
 * @version 1.0
 */
@Component
@Data
public class RawMaterialDO {
    //id
    private String id;
    //配方上传ID
    private String formula_upload_id;
    //原料名称
    private String raw_material_name;
    //品种
    private String variety;
    //重量
    private String weight;
    //处理方式
    private String processing_method;
}
