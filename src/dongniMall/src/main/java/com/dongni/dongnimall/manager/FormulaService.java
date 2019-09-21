package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.Formula;
import com.dongni.dongnimall.vo.PageData;

public interface FormulaService {

    /**
     * 查询所有配方
     * @param page
     * @param limit
     * @param formulaName
     * @return
     */
    PageData selectAllFormula(Integer page, Integer limit, String formulaName);

    /**
     * 插入配方信息
     * @param formula
     */
    void insertFormula(Formula formula);

    /**
     * 更新配方信息
     * @param formula
     */
    void updateFormula(Formula formula);

    /**
     * 通过id查询配方信息
     * @param id
     */
    void deleteByID(Integer id);
}
