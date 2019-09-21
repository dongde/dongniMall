package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.TemplateDO;
import com.dongni.dongnimall.vo.PageData;

public interface TemplateService {
    /**
     * 查询数据库信息
     * @param page
     * @param limit
     * @param templateName
     * @param templateType
     * @return
     */
    PageData selectTemplates(Integer page, Integer limit, String templateName, String templateType);

    /**
     * 添加数据到数据库中
     */
    void insertTemplate(TemplateDO templateDO);

    /**
     * 通过id删除模板信息
     * @param id
     */
    void deleteByID(String id);


    /**
     * 通过id查询模板数据
     * @param id
     * @return
     */
    TemplateDO selectByID(String id);

    /**
     * 修改模板文件
     * @param templateDO
     */
    void updateObject(TemplateDO templateDO);
}
