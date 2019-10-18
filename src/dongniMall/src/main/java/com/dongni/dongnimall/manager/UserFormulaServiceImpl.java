package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.UserFormulaMapper;
import com.dongni.dongnimall.pojo.UserFormulaDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cengshuai on 2019-10-17.
 * @version 1.0
 */
@Service
public class UserFormulaServiceImpl implements UserFormulaService {
    @Autowired
    private UserFormulaMapper userFormulaMapper;

    @Override
    public void addUserFormula(UserFormulaDO userFormulaDO) {
        userFormulaMapper.insertUserFormula(userFormulaDO);
    }

    @Override
    public List<UserFormulaDO> queryUserFormla(String user_phone) {
        return userFormulaMapper.selectUserFormula(user_phone);
    }

    @Override
    public boolean queryUserFormulaByUserAndFormula(String user_phone, String formula_id) {
        return userFormulaMapper.selectUserFormulaByUserAndFormula(user_phone, formula_id).size() != 0 ? true : false;
    }
}
