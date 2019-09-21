package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.Formula;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormulaMapper {

    /**
     * 查询所有配方
     * @param formulaName
     * @return
     */
    List<Formula> selectAllFormula(@Param("formulaName") String formulaName);

    /**
     * 添加配方
     * @param formula
     */
    void insertFormula(@Param("formula") Formula formula);

    /**
     * 更新配方
     * @param formula
     */
    void updateFormula(@Param("formula") Formula formula);

    /**
     * 删除配方
     * @param id
     */
    void deleteFormula(@Param("id") Integer id);

    /**
     * 通过id查询
     * @param id
     */
    void selectByID(@Param("id") Integer id);
}
