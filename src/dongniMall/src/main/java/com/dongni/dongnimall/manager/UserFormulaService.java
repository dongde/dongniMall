package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.UserFormulaDO;
import com.dongni.dongnimall.vo.UserFormulaVO;

import java.util.List;

/**
 * @author cengshuai on 2019-10-17.
 * @version 1.0
 */
public interface UserFormulaService {
    /**
     * 用户添加购买配方记录
     *
     * @param userFormulaDO
     */
    void addUserFormula(UserFormulaDO userFormulaDO);

    /**
     * 查询用户购买记录
     *
     * @param user_phone
     * @return
     */
    List<UserFormulaVO> queryUserFormla(String user_phone);

    /**
     * 添加预约时间
     *
     * @param appointment_type
     * @param date
     * @param formula_id
     */
    void addAppointment(Integer appointment_type, String date, String formula_id);

    /**
     * 查询用户是否够购买配方
     *
     * @param user_phone
     * @param formula_id
     * @return
     */
    boolean queryUserFormulaByUserAndFormula(String user_phone, String formula_id);

    /**
     * 根据用户账号和配方ID删除用户配方购买记录
     *
     * @param user_phone
     * @param formula_id
     */
    void deleteUserFormula(String user_phone, String formula_id);
}
