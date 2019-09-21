package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.manager.BaseTradeService;
import com.dongni.dongnimall.manager.FormulaService;
import com.dongni.dongnimall.manager.NewsService;
import com.dongni.dongnimall.manager.PublicityTemplateService;
import com.dongni.dongnimall.vo.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据总览
 */
@RestController
public class ArticleAndTemplateListPageController {


    @Autowired
    private BaseTradeService baseTradeService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private PublicityTemplateService publicityTemplateService;

    @Autowired
    private FormulaService formulaService;

    //文章数据总览
    @RequestMapping("/showList")
    public PageData list(Integer page, Integer limit, String title, String source){
        return newsService.selectAll(page,limit,title,source);

    }


    //模板总览
    @RequestMapping("/showTemplates")
    public PageData templateLists(Integer page, Integer limit, String templateName, String templateType){
        return publicityTemplateService.selectTemplates(page,limit,templateName,templateType);

    }


    //底料商品总览
    @RequestMapping("/showTradeList")
    public PageData tradeList(Integer page, Integer limit, String tradeName, String tradeType){
        return baseTradeService.selectAllTrade(page,limit,tradeName,tradeType);
    }

    //配方总览
    @RequestMapping("/showFormula")
    public PageData showFormulaList(Integer page, Integer limit, String formulaName){
        return formulaService.selectAllFormula(page,limit,formulaName);
    }





}
