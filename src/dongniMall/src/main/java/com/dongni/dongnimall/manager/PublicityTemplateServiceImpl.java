package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.PublicityTemplateDAO;
import com.dongni.dongnimall.pojo.PublicityTemplate;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicityTemplateServiceImpl implements PublicityTemplateService {

    @Autowired
    private PublicityTemplateDAO publicityTemplateDAO;


    @Override
    public PageData selectTemplates(Integer page, Integer limit, String templateName, String templateType) {
        PageData pageData = new PageData();
        if("".equals(templateName) && "".equals(templateType)) {
            PageHelper.startPage(page, limit);
            List<PublicityTemplate> publicityTemplates = publicityTemplateDAO.selectAll();
            PageInfo<PublicityTemplate> pageInfo = new PageInfo<>(publicityTemplates);
            pageData.setCode(0);
            pageData.setCount(pageInfo.getTotal());
            pageData.setMsg("");
            pageData.setData(publicityTemplates);
            return pageData;
        }else if("".equals(templateName) && templateType!=null){
            PageHelper.startPage(page, limit);
            List<PublicityTemplate> lists = publicityTemplateDAO.queryByType(templateType);
            PageInfo<PublicityTemplate> pageInfo = new PageInfo<>(lists);

                pageData.setCode(0);
                pageData.setCount(pageInfo.getTotal());
                pageData.setMsg("");
                pageData.setData(lists);
                return pageData;

        }else if(!"".equals(templateName) && templateType==null){
            PageHelper.startPage(page, limit);
            List<PublicityTemplate> publicityTemplateList = publicityTemplateDAO.queryByName(templateName);
            PageInfo<PublicityTemplate> pageInfo = new PageInfo<>(publicityTemplateList);

            pageData.setCode(0);
            pageData.setCount(pageInfo.getTotal());
            pageData.setMsg("");
            pageData.setData(publicityTemplateList);
            return pageData;

        }else if(!"".equals(templateName) && !"".equals(templateType)){
            List<PublicityTemplate> lists = new ArrayList<>();
            PublicityTemplate publicityTemplate = publicityTemplateDAO.findByNameAndType(templateName, templateType);
            lists.add(publicityTemplate);
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
    public void insertTemplate(PublicityTemplate publicityTemplate) {
        publicityTemplateDAO.insertTemplate(publicityTemplate);
    }

    @Override
    public void deleteByID(Integer id) {
        publicityTemplateDAO.deleteByID(id);
    }

    @Override
    public PublicityTemplate selectByID(Integer id) {
        PublicityTemplate publicityTemplate = publicityTemplateDAO.findByID(id);
        return publicityTemplate;
    }

    @Override
    public void updateObject(PublicityTemplate publicityTemplate) {
        publicityTemplateDAO.updateObject(publicityTemplate);
    }
}
