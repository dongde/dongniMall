package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.UserFormulaDO;

import java.util.List;

/**
 * @author cengshuai on 2019-10-17.
 * @version 1.0
 */
public interface UserFormulaService {
    /**
     * 用户添加购买配方记录
     * @param userFormulaDO
     */
    void addUserFormula(UserFormulaDO userFormulaDO);

    /**
     * 查询用户购买记录
     * @param user_phone
     * @return
     */
    List<UserFormulaDO> queryUserFormla(String user_phone);
}
