package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.BaseImageMapper;
import com.dongni.dongnimall.dao.FormulaMapper;
import com.dongni.dongnimall.pojo.BaseImageDO;
import com.dongni.dongnimall.pojo.FormulaDO;
import com.dongni.dongnimall.vo.FormulaVO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormulaServiceImpl implements FormulaService {

    @Autowired
    private BaseImageMapper baseImageMapper;
    @Autowired
    private FormulaMapper formulaMapper;

    @Override
    public PageData selectAllFormula(Integer page, Integer limit, String formulaName) {
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
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

    @Override
    public FormulaVO selectDetails(String id) {
        FormulaVO formulaVO = new FormulaVO();
        FormulaDO formulaDO = formulaMapper.selectByID(id);
        List<BaseImageDO> baseImages = baseImageMapper.findByID(id);
        List<String> lists = new ArrayList<>();
        if (formulaDO != null) {
            BeanUtils.copyProperties(formulaDO, formulaVO, "images");
            for (BaseImageDO baseImageDO : baseImages) {
                lists.add(baseImageDO.getImageURL());
            }
            formulaVO.setImages(lists);
            String practical_operation_noAppointment = formulaDO.getPractical_operation_noAppointment();
            if (StringUtils.isNotBlank(practical_operation_noAppointment)) {
                formulaVO.setPractical_operation_noAppointment(practical_operation_noAppointment.split(","));
            }
            String learn_again_noAppointment = formulaDO.getLearn_again_noAppointment();
            if (StringUtils.isNotBlank(learn_again_noAppointment)) {
                formulaVO.setLearn_again_noAppointment(learn_again_noAppointment.split(","));
            }
            String assist_noAppointment = formulaDO.getAssist_noAppointment();
            if (StringUtils.isNotBlank(assist_noAppointment)) {
                formulaVO.setAssist_noAppointment(assist_noAppointment.split(","));
            }
        }
        return formulaVO;
    }
}
