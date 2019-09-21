package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.TemplateMapper;
import com.dongni.dongnimall.pojo.TemplateDO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;


    @Override
    public PageData selectTemplates(Integer page, Integer limit, String templateName, String templateType) {
        PageData pageData = new PageData();
        if("".equals(templateName) && "".equals(templateType)) {
            PageHelper.startPage(page, limit);
            List<TemplateDO> templateDOS = templateMapper.selectAll();
            PageInfo<TemplateDO> pageInfo = new PageInfo<>(templateDOS);
            pageData.setCode(0);
            pageData.setCount(pageInfo.getTotal());
            pageData.setMsg("");
            pageData.setData(templateDOS);
            return pageData;
        }else if("".equals(templateName) && templateType!=null){
            PageHelper.startPage(page, limit);
            List<TemplateDO> lists = templateMapper.queryByType(templateType);
            PageInfo<TemplateDO> pageInfo = new PageInfo<>(lists);

                pageData.setCode(0);
                pageData.setCount(pageInfo.getTotal());
                pageData.setMsg("");
                pageData.setData(lists);
                return pageData;

        }else if(!"".equals(templateName) && templateType==null){
            PageHelper.startPage(page, limit);
            List<TemplateDO> templateDOList = templateMapper.queryByName(templateName);
            PageInfo<TemplateDO> pageInfo = new PageInfo<>(templateDOList);

            pageData.setCode(0);
            pageData.setCount(pageInfo.getTotal());
            pageData.setMsg("");
            pageData.setData(templateDOList);
            return pageData;

        }else if(!"".equals(templateName) && !"".equals(templateType)){
            List<TemplateDO> lists = new ArrayList<>();
            TemplateDO templateDO = templateMapper.findByNameAndType(templateName, templateType);
            lists.add(templateDO);
            pageData.setCode(0);
            pageData.setCount(1);
            pageData.setMsg("");
            pageData.setData(lists);
            return pageData;
        }else{
            return pageData;
        }
    }

    @Override
    public void insertTemplate(TemplateDO templateDO) {
        templateMapper.insertTemplate(templateDO);
    }

    @Override
    public void deleteByID(String id) {
        templateMapper.deleteByID(id);
    }

    @Override
    public TemplateDO selectByID(String id) {
        TemplateDO templateDO = templateMapper.findByID(id);
        return templateDO;
    }

    @Override
    public void updateObject(TemplateDO templateDO) {
        templateMapper.updateObject(templateDO);
    }
}
