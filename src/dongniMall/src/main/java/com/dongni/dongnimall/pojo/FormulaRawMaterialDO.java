package com.dongni.dongnimall.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author cengshuai on 2019-10-28.
 * @version 1.0
 */
@Component
@Data
public class FormulaRawMaterialDO {
    private String formula_id;
    private String raw_material_name;
    private String variety;
    private BigDecimal unit_price;
}
