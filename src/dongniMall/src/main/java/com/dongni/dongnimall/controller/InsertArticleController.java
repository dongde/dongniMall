package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.common.ImageFileUploadUtil;
import com.dongni.dongnimall.manager.BaseTradeService;
import com.dongni.dongnimall.manager.FormulaService;
import com.dongni.dongnimall.manager.NewsService;
import com.dongni.dongnimall.manager.PublicityTemplateService;
import com.dongni.dongnimall.pojo.BaseStore;
import com.dongni.dongnimall.pojo.Formula;
import com.dongni.dongnimall.pojo.NewsInformation;
import com.dongni.dongnimall.pojo.PublicityTemplate;
import com.dongni.dongnimall.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.dongni.dongnimall.controller.BaseController.*;

/**
 * 添加
 */
@RestController
@RequestMapping("/add")
public class InsertArticleController {
    @Autowired
    private NewsService newsService;

    @Autowired
    private PublicityTemplateService publicityTemplateService;

    @Autowired
    private BaseTradeService baseTradeService;

    @Autowired
    private FormulaService formulaService;
    //添加文章
    @RequestMapping("addAndUpdateNews")
    public JsonResult insertList(Integer id,String title, String source, String summary, String content,MultipartFile file) {
        if ("".equals(title) || "".equals(source) || "".equals(summary) || "".equals(content)) {
            return JsonResult.errorMsg("数据不能为空");
        }
        NewsInformation newsInformation = new NewsInformation();
        newsInformation.setContent(content);
        newsInformation.setSource(source);
        newsInformation.setSummary(summary);
        //时间字符串转化
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        newsInformation.setUpdateTime(dateString);
        newsInformation.setTitle(title);
        if(id==null){
            String DBpath = ImageFileUploadUtil.uploadFile(file, IMAGE_SAVE_PATH);
            newsInformation.setImageURL(DBpath);
            newsService.insertObject(newsInformation);
            return JsonResult.ok();
        }else {
            if(file!=null) {
                String DBpath = ImageFileUploadUtil.uploadFile(file, IMAGE_SAVE_PATH);
                newsInformation.setImageURL(DBpath);
            }
            newsService.updateNews(newsInformation,id);
            return JsonResult.ok();
        }


    }

    //添加模板文件
    @RequestMapping("addAndUpdateTemplate")
    public JsonResult insertTemplate(Integer id,String templateName, String templateType, Float price, String description,MultipartFile file) {

        if ("".equals(templateName) || "".equals(templateType) || "".equals(description) || price == null) {
            return JsonResult.errorMsg("数据不能为空");
        }

        PublicityTemplate publicityTemplate = new PublicityTemplate();
        publicityTemplate.setPrice(price);
        publicityTemplate.setTemplateName(templateName);
        publicityTemplate.setTemplateType(templateType);
        publicityTemplate.setTextDescription(description);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        publicityTemplate.setUpdateTime(dateString);
        if(id==null){

            String DBpath = ImageFileUploadUtil.uploadFile(file, TRADE_SAVE_PATH);
            publicityTemplate.setImage(DBpath);
            publicityTemplateService.insertTemplate(publicityTemplate);
            return JsonResult.ok();
        }else {
            if(file!=null) {
                String DBpath = ImageFileUploadUtil.uploadFile(file, TRADE_SAVE_PATH);
                publicityTemplate.setImage(DBpath);
            }
            publicityTemplate.setId(id);
            publicityTemplateService.updateObject(publicityTemplate);
            return JsonResult.ok();
        }

    }

    //添加底料
    @RequestMapping("addAndUpdateTrade")
    public JsonResult insertTrade(Integer id,String tradeName, String tradeType, Float price, String tradeURL, MultipartFile file) {
        if ("".equals(tradeName) || "".equals(tradeType) || price == null || "".equals(tradeURL)) {
            return JsonResult.errorMsg("数据不能为空");
        }

        BaseStore baseStore = new BaseStore();
        baseStore.setPrice(price);
        baseStore.setTradeName(tradeName);
        baseStore.setTradeType(tradeType);
        baseStore.setTradeURL(tradeURL);
        baseStore.setViewCount(1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        baseStore.setUpdateTime(dateString);
        if(id==null){
            String DBpath = ImageFileUploadUtil.uploadFile(file, TRADE_SAVE_PATH);
            baseStore.setImageURL(DBpath);
            baseTradeService.insertTrade(baseStore);
            return JsonResult.ok();
        }else {
            if(file!=null) {
                String DBpath = ImageFileUploadUtil.uploadFile(file, TRADE_SAVE_PATH);
                baseStore.setImageURL(DBpath);
            }
            baseStore.setId(id);
            baseTradeService.updateTrade(baseStore);
            return JsonResult.ok();
        }
    }
    //添加配方
    @RequestMapping("addAndUpdateFormula")
    public JsonResult insertformula(Integer id,String formulaName, Float formulaPrice, String formulaDescription,Float samplePrice, Float flyPrice, String factoryAdress,MultipartFile file) {
        if ("".equals(formulaName) || "".equals(formulaDescription) || formulaPrice == null || "".equals(factoryAdress)||samplePrice==null||flyPrice==null) {
            return JsonResult.errorMsg("数据不能为空");

        }
        Formula formula = new Formula();
        formula.setFormulaName(formulaName);
        formula.setFormulaPrice(formulaPrice);
        formula.setFormulaDescription(formulaDescription);
        formula.setSamplePrice(samplePrice);
        formula.setFlyPrice(flyPrice);
        formula.setFactoryAdress(factoryAdress);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        formula.setUpdateTime(dateString);
        if(id==null){
            String DBpath = ImageFileUploadUtil.uploadFile(file, FORMULA_SAVE_PATH);
            formula.setFormulaURL(DBpath);
            formulaService.insertFormula(formula);
            return JsonResult.ok();
        }else {
            if(file!=null) {
                String DBpath = ImageFileUploadUtil.uploadFile(file, FORMULA_SAVE_PATH);
                formula.setFormulaURL(DBpath);
            }
            formula.setId(id);
            formulaService.updateFormula(formula);
            return JsonResult.ok();
        }
    }

}
