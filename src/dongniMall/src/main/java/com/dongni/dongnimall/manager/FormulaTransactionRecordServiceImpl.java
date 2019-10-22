package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.FormulaMapper;
import com.dongni.dongnimall.dao.FormulaTransactionRecordMapper;
import com.dongni.dongnimall.dao.UserMapper;
import com.dongni.dongnimall.pojo.FormulaDO;
import com.dongni.dongnimall.pojo.FormulaTransactionRecordDO;
import com.dongni.dongnimall.pojo.UserDO;
import com.dongni.dongnimall.vo.FormulaTransactionRecordVO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
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
public class FormulaTransactionRecordServiceImpl implements FormulaTransactionRecordService {
    @Autowired
    private FormulaTransactionRecordMapper formulaTransactionRecordMapper;

    @Autowired
    private FormulaMapper formulaMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addFormulaTransactionRecord(FormulaTransactionRecordDO formulaTransactionRecordDO) {
        formulaTransactionRecordMapper.insertFormulaTransactionRecord(formulaTransactionRecordDO);
    }

    @Override
    public void removeFormulaTransactionRecord(String id) {
        formulaTransactionRecordMapper.deleteFormulaTransactionRecord(id);
    }

    @Override
    public PageData queryFormulaTransactionRecord(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<FormulaTransactionRecordDO> formulaTransactionRecordDOS = formulaTransactionRecordMapper.selectFormulaTransactionRecord();
        PageInfo<FormulaTransactionRecordDO> pageInfo = new PageInfo<>(formulaTransactionRecordDOS);
        PageData pageData = new PageData();

        pageData.setCode(0);
        pageData.setCount(pageInfo.getTotal());
        pageData.setMsg("");
        List<FormulaTransactionRecordVO> list = new ArrayList<>();
        for (FormulaTransactionRecordDO formulaTransactionRecordDO : formulaTransactionRecordDOS) {
            FormulaTransactionRecordVO formulaTransactionRecordVO = new FormulaTransactionRecordVO();
            BeanUtils.copyProperties(formulaTransactionRecordDO, formulaTransactionRecordVO);
            String name = formulaTransactionRecordDO.getUserDO().getName();
            formulaTransactionRecordVO.setUser_name(StringUtils.isBlank(name) ? "<无>" : name);
            formulaTransactionRecordVO.setFormula_name(formulaTransactionRecordDO.getFormulaDO().getFormulaName());
            list.add(formulaTransactionRecordVO);
        }
        pageData.setData(list);
        return pageData;
    }

    @Override
    public void modifyFormulaTransactionRecord(FormulaTransactionRecordDO formulaTransactionRecordDO) {
        formulaTransactionRecordMapper.updateFormulaTransactionRecord(formulaTransactionRecordDO);
    }
}
