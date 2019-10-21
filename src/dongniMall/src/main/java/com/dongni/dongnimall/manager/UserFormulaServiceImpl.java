package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.FormulaMapper;
import com.dongni.dongnimall.dao.UserFormulaMapper;
import com.dongni.dongnimall.pojo.FormulaDO;
import com.dongni.dongnimall.pojo.UserFormulaDO;
import com.dongni.dongnimall.vo.UserFormulaVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cengshuai on 2019-10-17.
 * @version 1.0
 */
@Service
public class UserFormulaServiceImpl implements UserFormulaService {
    @Autowired
    private UserFormulaMapper userFormulaMapper;
    @Autowired
    private FormulaMapper formulaMapper;

    @Override
    public void addUserFormula(UserFormulaDO userFormulaDO) {
        userFormulaMapper.insertUserFormula(userFormulaDO);
    }

    @Override
    public List<UserFormulaVO> queryUserFormla(String user_phone) {
        List<UserFormulaDO> userFormulaDOS = userFormulaMapper.selectUserFormula(user_phone);
        List<UserFormulaVO> list = new ArrayList<>();
        for (UserFormulaDO userFormulaDO : userFormulaDOS) {
            FormulaDO formulaDO = formulaMapper.selectByID(userFormulaDO.getFormula_id());
            if (formulaDO != null) {
                UserFormulaVO userFormulaVO = new UserFormulaVO();
                BeanUtils.copyProperties(userFormulaDO,userFormulaVO);
                userFormulaVO.setFormula_file(formulaDO.getFormulaFile());
                userFormulaVO.setFormula_img(formulaDO.getBigPicture());
                userFormulaVO.setFormula_name(formulaDO.getFormulaName());
                userFormulaVO.setFormula_price(formulaDO.getFormulaPrice());
                list.add(userFormulaVO);
            }
        }
        return list;
    }

    @Override
    public boolean queryUserFormulaByUserAndFormula(String user_phone, String formula_id) {
        return userFormulaMapper.selectUserFormulaByUserAndFormula(user_phone, formula_id).size() != 0 ? true : false;
    }
}