package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.FormulaDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormulaMapper {

    /**
     * 查询所有配方
     * @param formulaName
     * @return
     */
    List<FormulaDO> selectAllFormula(@Param("formulaName") String formulaName);

    /**
     * 添加配方
     * @param formulaDO
     */
    void insertFormula(@Param("formulaDO") FormulaDO formulaDO);

    /**
     * 更新配方
     * @param formulaDO
     */
    void updateFormula(@Param("formulaDO") FormulaDO formulaDO);

    /**
     * 删除配方
     * @param id
     */
    void deleteFormula(@Param("id") String id);

    /**
     * 通过id查询
     * @param id
     */
    FormulaDO selectByID(@Param("id") String id);
}
