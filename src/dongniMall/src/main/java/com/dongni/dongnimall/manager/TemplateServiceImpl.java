package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.TemplateMapper;
import com.dongni.dongnimall.pojo.TemplateDO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;


    @Override
    public PageData selectTemplates(Integer page, Integer limit, String templateName, String templateType) {
        if(page==null){
            page = 1;
        }
        if(limit==null){
            limit = 10;
        }
        PageData pageData = new PageData();
        if(StringUtils.isBlank(templateName) && StringUtils.isBlank(templateType)) {
            PageHelper.startPage(page, limit);
            List<TemplateDO> templateDOS = templateMapper.selectAll();
            PageInfo<TemplateDO> pageInfo = new PageInfo<>(templateDOS);
            pageData.setCode(0);
            pageData.setCount(pageInfo.getTotal());
            pageData.setMsg("");
            pageData.setData(templateDOS);
            return pageData;
        }else if(StringUtils.isBlank(templateName) && !StringUtils.isBlank(templateType)){
            PageHelper.startPage(page, limit);
            List<TemplateDO> lists = templateMapper.queryByType(templateType);
            PageInfo<TemplateDO> pageInfo = new PageInfo<>(lists);
                pageData.setCode(0);
                pageData.setCount(pageInfo.getTotal());
                pageData.setMsg("");
                pageData.setData(lists);
                return pageData;

        }else if(!StringUtils.isBlank(templateName)&& StringUtils.isBlank(templateType)){
            PageHelper.startPage(page, limit);
            List<TemplateDO> templateDOList = templateMapper.queryByName(templateName);
            PageInfo<TemplateDO> pageInfo = new PageInfo<>(templateDOList);

            pageData.setCode(0);
            pageData.setCount(pageInfo.getTotal());
            pageData.setMsg("");
            pageData.setData(templateDOList);
            return pageData;

        }else if(!StringUtils.isBlank(templateName) && !StringUtils.isBlank(templateType)){
            List<TemplateDO> templateDOs = templateMapper.findByNameAndType(templateName, templateType);
            PageInfo<TemplateDO> pageInfo = new PageInfo<>(templateDOs);
            if(templateDOs == null){
                pageData.setCode(0);
                pageData.setCount(1);
                pageData.setMsg("");
                pageData.setData(null);
                return pageData;
            }
            pageData.setCode(0);
            pageData.setCount(pageInfo.getTotal());
            pageData.setMsg("");
            pageData.setData(templateDOs);
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
    public void updateTemplate(TemplateDO templateDO) {
        templateMapper.updateObject(templateDO);
    }
}
