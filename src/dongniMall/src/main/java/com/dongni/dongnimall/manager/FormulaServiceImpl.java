package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.FormulaMapper;
import com.dongni.dongnimall.pojo.FormulaDO;
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
        if(page==null){
            page = 1;
        }
        if(limit==null){
            limit = 10;
        }
        PageHelper.startPage(page, limit);
        List<FormulaDO> formulaDOS = formulaMapper.selectAllFormula(formulaName);
        PageInfo<FormulaDO> pageInfo = new PageInfo<>(formulaDOS);
        PageData pageData = new PageData();

        pageData.setCode(0);
        pageData.setCount(pageInfo.getTotal());
        pageData.setMsg("");
        pageData.setData(formulaDOS);
        return pageData;
    }

    @Override
    public void insertFormula(FormulaDO formulaDO) {
        formulaMapper.insertFormula(formulaDO);
    }

    @Override
    public void updateFormula(FormulaDO formulaDO) {
        formulaMapper.updateFormula(formulaDO);
    }

    @Override
    public void deleteByID(String id) {
        formulaMapper.deleteFormula(id);
    }

    @Override
    public FormulaDO selectByID(String id) {
        return formulaMapper.selectByID(id);
    }
}
