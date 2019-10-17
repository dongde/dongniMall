package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.FormulaTransactionRecordDO;
import com.dongni.dongnimall.vo.PageData;

/**
 * @author cengshuai on 2019-10-17.
 * @version 1.0
 */
public interface FormulaTransactionRecordService {
    /**
     * 添加配方交易记录
     * @param formulaTransactionRecordDO
     */
    void addFormulaTransactionRecord(FormulaTransactionRecordDO formulaTransactionRecordDO);

    /**
     * 删除配方交易记录
     * @param id
     */
    void removeFormulaTransactionRecord(String id);

    /**
     * 查询配方交易记录
     * @param page
     * @param pageSize
     * @return
     */
    PageData queryFormulaTransactionRecord(Integer page,Integer pageSize);

    /**
     * 修改记录信息
     * @param formulaTransactionRecordDO
     */
    void modifyFormulaTransactionRecord(FormulaTransactionRecordDO formulaTransactionRecordDO);
}
