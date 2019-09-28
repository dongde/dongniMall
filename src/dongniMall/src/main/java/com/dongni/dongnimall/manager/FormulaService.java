package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.FormulaDO;
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
     * @param formulaDO
     */
    void insertFormula(FormulaDO formulaDO);

    /**
     * 更新配方信息
     * @param formulaDO
     */
    void updateFormula(FormulaDO formulaDO);

    /**
     * 通过id查询配方信息
     * @param id
     */
    void deleteByID(String id);

    /**
     * 获取配方
     *
     * @param id
     * @return
     */
    FormulaDO selectByID(String id);
}
