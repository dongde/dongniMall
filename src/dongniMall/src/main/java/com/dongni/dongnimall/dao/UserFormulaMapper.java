package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.UserFormulaDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-10-17.
 * @version 1.0
 */
@Repository
public interface UserFormulaMapper {
    void insertUserFormula(@Param("userFormulaDO")UserFormulaDO userFormulaDO);

    List<UserFormulaDO> selectUserFormula(String user_phone);

    UserFormulaDO selectUserFormulaByUserAndFormula(@Param("user_phone") String user_phone,@Param("formula_id") String formula_id);

    void updateUserForm(@Param("appointment_type") Integer appointment_type,@Param("date") String date,@Param("formula_id")String formula_id);

    void deleteUserForm(@Param("user_phone")String user_phone,@Param("formula_id") String formula_id);
}
