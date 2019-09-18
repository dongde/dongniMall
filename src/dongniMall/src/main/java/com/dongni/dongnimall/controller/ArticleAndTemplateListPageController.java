package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.manager.BaseTrade;
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
    private BaseTrade baseTrade;
    @Autowired
    private NewsService newsService;
    @Autowired
    private PublicityTemplateService publicityTemplateService;

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
        return baseTrade.selectAllTrade(page,limit,tradeName,tradeType);
    }





}
