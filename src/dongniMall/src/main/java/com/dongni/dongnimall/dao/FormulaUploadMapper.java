package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.FormulaUploadDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-10-21.
 * @version 1.0
 */
@Repository
public interface FormulaUploadMapper {
    void insertFormulaUpload(@Param("formulaUploadDO") FormulaUploadDO formulaUploadDO);

    List<FormulaUploadDO> selectFormulaUploadList(@Param("user_phone") String user_phone,@Param("formula_upload_name") String formula_upload_name);

    void updateFormlaUpload(@Param("formulaUploadDO") FormulaUploadDO formulaUploadDO);
}
