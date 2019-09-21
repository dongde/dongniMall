package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.common.ImageFileUploadUtil;
import com.dongni.dongnimall.manager.TemplateService;
import com.dongni.dongnimall.pojo.TemplateDO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.dongni.dongnimall.controller.BaseController.TRADE_SAVE_PATH;

/**
 * 宣传模板管理
 */
@RestController
@RequestMapping("template")
public class TemplateController {

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
    public JsonResult insertTemplate(String id,String templateName, String templateType, Float price, String description,MultipartFile file) {

        if ("".equals(templateName) || "".equals(templateType) || "".equals(description) || price == null) {
            return JsonResult.errorMsg("数据不能为空");
        }

        TemplateDO templateDO = new TemplateDO();
        templateDO.setPrice(price);
        templateDO.setTemplateName(templateName);
        templateDO.setTemplateType(templateType);
        templateDO.setTextDescription(description);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        templateDO.setUpdateTime(dateString);
        if(id==null||"".equals(id)){
            String ids = sid.nextShort();

            String DBpath = ImageFileUploadUtil.uploadFile(file, TRADE_SAVE_PATH);

            templateDO.setImage(DBpath);
            templateDO.setId(ids);

            templateService.insertTemplate(templateDO);

            return JsonResult.ok();
        }else {
            if(file!=null) {
                String DBpath = ImageFileUploadUtil.uploadFile(file, TRADE_SAVE_PATH);
                templateDO.setImage(DBpath);
            }
            templateDO.setId(id);
            templateService.updateObject(templateDO);
            return JsonResult.ok();
        }

    }




}
