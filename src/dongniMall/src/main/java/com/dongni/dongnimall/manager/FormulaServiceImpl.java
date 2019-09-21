package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.FormulaMapper;
import com.dongni.dongnimall.pojo.Formula;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormulaServiceImpl implements FormulaService {

    @Autowired
    private FormulaMapper formulaMapper;
    @Override
    public PageData selectAllFormula(Integer page, Integer limit, String formulaName) {
        PageHelper.startPage(page, limit);
        List<Formula> Formulas = formulaMapper.selectAllFormula(formulaName);
        PageInfo<Formula> pageInfo = new PageInfo<>(Formulas);
        PageData pageData = new PageData();
        if(Formulas!=null) {
            pageData.setCode(0);
            pageData.setCount(pageInfo.getTotal());
            pageData.setMsg("");
            pageData.setData(Formulas);
            return pageData;
        }else {
            pageData.setCode(1);
            pageData.setCount(0);
            pageData.setMsg("获取数据失败");
            pageData.setData(null);
            return pageData;
        }
    }

    @Override
    public void insertFormula(Formula formula) {
        formulaMapper.insertFormula(formula);
    }

    @Override
    public void updateFormula(Formula formula) {
        formulaMapper.updateFormula(formula);
    }

    @Override
    public void deleteByID(Integer id) {
        formulaMapper.deleteFormula(id);
    }
}
