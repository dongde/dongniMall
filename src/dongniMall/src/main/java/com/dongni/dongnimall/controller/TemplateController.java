package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.base.storage.FileUploadManager;
import com.dongni.dongnimall.base.storage.Response;
import com.dongni.dongnimall.manager.TemplateService;
import com.dongni.dongnimall.pojo.TemplateDO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 宣传模板管理
 */
@RestController
@RequestMapping("template")
public class TemplateController {
    @Autowired
    private FileUploadManager fileUploadManager;
    @Autowired
    private TemplateService templateService;
    @Autowired
    private Sid sid;

    //模板总览
    @RequestMapping("/list")
    public PageData templateLists(Integer page, Integer limit, String templateName, String templateType){
        return templateService.selectTemplates(page,limit,templateName,templateType);
    }

    //删除模板
    @RequestMapping("delete")
    public JsonResult deleteTemplate(String id){
        templateService.deleteByID(id);
        return JsonResult.ok();
    }

    //添加模板文件
    @RequestMapping("add")
    public JsonResult insertTemplate(String id,String templateName, String templateType, Float price, String description,MultipartFile file) throws IOException {

        if(StringUtils.isBlank(templateName)){
            return JsonResult.errorMsg("模板名称不能为空");
        }
        if(StringUtils.isBlank(templateType)){
            return JsonResult.errorMsg("类型不能为空");
        }
        if(StringUtils.isBlank(description)){
            return JsonResult.errorMsg("模板描述不能为空");
        }
        if(price == null){
            return JsonResult.errorMsg("价格不能为空");
        }



        TemplateDO templateDO = templateService.selectByID(id);
        boolean exist = templateDO != null;
        if (!exist) {
            templateDO = new TemplateDO();
            templateDO.setId(sid.nextShort());
        }

        templateDO.setPrice(price);
        templateDO.setTemplateName(templateName);
        templateDO.setTemplateType(templateType);
        templateDO.setTextDescription(description);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        templateDO.setUpdateTime(dateString);

        if(file!=null) {
            Response response = fileUploadManager.upload(file.getInputStream());
            templateDO.setImage(response.getUrl());
        }

        if (exist) {
            templateService.updateTemplate(templateDO);
        } else {
            templateService.insertTemplate(templateDO);
        }
        return JsonResult.ok(templateDO);
    }
}
