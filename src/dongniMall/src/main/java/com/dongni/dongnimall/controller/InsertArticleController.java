package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.common.ImageFileUploadUtil;
import com.dongni.dongnimall.manager.BaseTradeService;
import com.dongni.dongnimall.manager.NewsService;
import com.dongni.dongnimall.manager.PublicityTemplateService;
import com.dongni.dongnimall.pojo.BaseStore;
import com.dongni.dongnimall.pojo.NewsInformation;
import com.dongni.dongnimall.pojo.PublicityTemplate;
import com.dongni.dongnimall.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.dongni.dongnimall.controller.BaseController.TRADE_SAVE_PATH;

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

    //添加文章
    @RequestMapping("article")
    public JsonResult insertList(String title, String source, String summary, String url, String content) {
        if ("".equals(title) || "".equals(source) || "".equals(summary) || "".equals(content) || "".equals(url)) {
            return JsonResult.errorMsg("数据不能为空");
        }
        NewsInformation newsInformation = new NewsInformation();
        newsInformation.setContent(content);
        newsInformation.setImageURL(url);
        newsInformation.setSource(source);
        newsInformation.setSummary(summary);
        //时间字符串转化
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        newsInformation.setUpdateTime(dateString);
        newsInformation.setTitle(title);
        newsService.insertObject(newsInformation);

        return JsonResult.ok();

    }

    //添加模板文件
    @RequestMapping("template")
    public JsonResult insertTemplate(String templateName, String templateType, Float price, String image, String description) {
        if ("".equals(templateName) || "".equals(templateType) || "".equals(image) || "".equals(description) || price == null) {
            return JsonResult.errorMsg("数据不能为空");
        }

        PublicityTemplate publicityTemplate = new PublicityTemplate();
        publicityTemplate.setImage(image);
        publicityTemplate.setPrice(price);
        publicityTemplate.setTemplateName(templateName);
        publicityTemplate.setTemplateType(templateType);
        publicityTemplate.setTextDescription(description);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        publicityTemplate.setUpdateTime(dateString);

        publicityTemplateService.insertTemplate(publicityTemplate);

        return JsonResult.ok();

    }

    //添加底料
    @RequestMapping("addAndUpdateTrade")
    public JsonResult insertTrade(Integer id,String tradeName, String tradeType, Float price, String tradeURL, MultipartFile file) {
        if ("".equals(tradeName) || "".equals(tradeType) || price == null || "".equals(tradeURL) || file == null) {
            JsonResult.errorMsg("数据不能为空");
        }

        String DBpath = ImageFileUploadUtil.uploadFile(file, TRADE_SAVE_PATH);
        BaseStore baseStore = new BaseStore();
        baseStore.setImageURL("http://localhost:8081" + DBpath);
        baseStore.setPrice(price);
        baseStore.setTradeName(tradeName);
        baseStore.setTradeType(tradeType);
        baseStore.setTradeURL(tradeURL);
        baseStore.setViewCount(1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        baseStore.setUpdateTime(dateString);
        if(id==null){
            baseTradeService.insertTrade(baseStore);
            return JsonResult.ok();
        }else {
            baseStore.setId(id);
            baseTradeService.updateTrade(baseStore);
            return JsonResult.ok();
        }
    }

}
