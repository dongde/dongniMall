package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.FormulaTransactionRecordDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-10-17.
 * @version 1.0
 */
@Repository
public interface FormulaTransactionRecordMapper {
    void insertFormulaTransactionRecord(@Param("formulaTransactionRecordDO") FormulaTransactionRecordDO formulaTransactionRecordDO);

    void deleteFormulaTransactionRecord(String id);

    List<FormulaTransactionRecordDO> selectFormulaTransactionRecord();

    void updateFormulaTransactionRecord(@Param("formulaTransactionRecordDO") FormulaTransactionRecordDO formulaTransactionRecordDO);
}
