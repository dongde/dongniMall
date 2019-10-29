package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.FormulaRawMaterialDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-10-28.
 * @version 1.0
 */
@Repository
public interface FormulaRawMaterialMapper {
    void insertFormulaRawMaterial(@Param("list")List<FormulaRawMaterialDO> list);

    List<FormulaRawMaterialDO> selectFormulaRawMaterial(@Param("formula_id") String formula_id);

    void updateFormulaRawMaterial(@Param("list")List<FormulaRawMaterialDO> list);

    void deleteFormulaRawMaterial(String formula_id);
}
