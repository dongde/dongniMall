package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.FormulaUploadMapper;
import com.dongni.dongnimall.pojo.FormulaUploadDO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cengshuai on 2019-10-21.
 * @version 1.0
 */
@Service
public class FormulaUploadServiceImpl implements FormulaUploadService {
    @Autowired
    private FormulaUploadMapper formulaUploadMapper;

    @Override
    public void addFormulaUpload(FormulaUploadDO formulaUploadDO) {
        formulaUploadMapper.insertFormulaUpload(formulaUploadDO);
    }

    @Override
    public PageData queryFormulaUploadList(Integer page, Integer pageSize, String user_phone, String formula_upload_name) {
        if (page != null && pageSize != null) {
            PageHelper.startPage(page, pageSize);
        }
        List<FormulaUploadDO> formulaUploadDOList = formulaUploadMapper.selectFormulaUploadList(user_phone, formula_upload_name);
        PageInfo<FormulaUploadDO> pageInfo = new PageInfo<>(formulaUploadDOList);
        PageData pageData = new PageData();
        pageData.setCode(0);
        pageData.setCount(pageInfo.getTotal());
        pageData.setData(formulaUploadDOList);
        pageData.setMsg("");
        return pageData;
    }

    @Override
    public void modifyFormulaUpload(FormulaUploadDO formulaUploadDO) {
        formulaUploadMapper.updateFormlaUpload(formulaUploadDO);
    }

    @Override
    public void removeFormulaUpload(String formula_upload_id) {
        formulaUploadMapper.deleteFormulaUpload(formula_upload_id);
    }
}
