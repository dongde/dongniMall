package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.common.ImageFileUploadUtil;
import com.dongni.dongnimall.manager.BaseTradeService;
import com.dongni.dongnimall.manager.NewsService;
import com.dongni.dongnimall.manager.PublicityTemplateService;
import com.dongni.dongnimall.pojo.NewsInformation;
import com.dongni.dongnimall.pojo.PublicityTemplate;
import com.dongni.dongnimall.vo.EditUploadDTO;
import com.dongni.dongnimall.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.dongni.dongnimall.controller.BaseController.TRADE_SAVE_PATH;

/**
 * 更新
 */
@RestController
@RequestMapping("list")
public class UpdateArticleController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private PublicityTemplateService publicityTemplateService;
    @Autowired
    private BaseTradeService baseTradeService;
    //修改文章
    @RequestMapping("update")
    public JsonResult update(Integer id, String title, String source, String summary, String content){
        if(id==null){
            return JsonResult.errorMsg("更新出错");
        }else if("".equals(title)||"".equals(source)||"".equals(summary)||"".equals(content)){
            return JsonResult.errorMsg("更新出错");
        }

        NewsInformation newsInformation = newsService.findByID(id);
        newsInformation.setTitle(title);
        newsInformation.setContent(content);
        newsInformation.setSource(source);
        newsInformation.setSummary(summary);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        newsInformation.setUpdateTime(dateString);
        newsService.updateNews(newsInformation,id);
        return JsonResult.ok();

    }


    //上传图片接口
    @RequestMapping("/uploadBanner")
    public EditUploadDTO uploadBanner(MultipartFile file) {

        String DBpath = ImageFileUploadUtil.uploadFile(file, TRADE_SAVE_PATH);

        Map<String,String> map = new HashMap<>();
        String imageURL = "http://localhost:8081/"+DBpath;
        System.out.println(imageURL);
        map.put("src",imageURL);
        return EditUploadDTO.ok(map);


    }

    //删除文章对应数据
    @RequestMapping("delete")
    public JsonResult deleteList(Integer id){
        newsService.deleteNews(id);
        return JsonResult.ok();
    }




    //修改模板
    @RequestMapping("updateTemplate")
    public JsonResult updateTemplate(Integer id, String templateName, String templateType, Float price, String image, String description){
        System.out.println(templateName+templateType);
        System.out.println(price+"***"+image);
        if(id==null){
            return JsonResult.errorMsg("更新出错");
        }else if("".equals(templateName)||"".equals(templateType)||price==null||"".equals(description)){
            return JsonResult.errorMsg("更新出错");
        }
        PublicityTemplate publicityTemplate = publicityTemplateService.selectByID(id);
        if(publicityTemplate == null){
            return JsonResult.errorMsg("更新错误");
        }else {
            publicityTemplate.setTextDescription(description);
            publicityTemplate.setTemplateType(templateType);
            publicityTemplate.setTemplateName(templateName);
            publicityTemplate.setPrice(price);
            publicityTemplate.setImage(image);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(new Date());
            publicityTemplate.setUpdateTime(dateString);
            publicityTemplateService.updateObject(publicityTemplate);
        }



        return JsonResult.ok();
    }

    /*//修改底料
    @RequestMapping("updateBase")
    public JsonResult updateBase(Integer id,String tradeName,String tradeType,Float price,String tradeURL,MultipartFile file){
        System.out.println(id+tradeName);
        System.out.println(file);
        if ("".equals(tradeName) || "".equals(tradeType) || price == null || "".equals(tradeURL) || file == null) {
            JsonResult.errorMsg("数据不能为空");
        }
        String DBpath = ImageFileUploadUtil.uploadFile(file, TRADE_SAVE_PATH);
        BaseStore baseStore = baseTradeService.selectByID(id);
        baseStore.setImageURL("http://localhost:8081"+DBpath);
        baseStore.setTradeName(tradeName);
        baseStore.setTradeType(tradeType);
        baseStore.setPrice(price);
        baseStore.setTradeURL(tradeURL);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        baseStore.setUpdateTime(dateString);
        baseTradeService.updateTrade(baseStore);
        return JsonResult.ok();

    }*/





    //删除模板
    @RequestMapping("deleteTemplate")
    public JsonResult deleteTemplate(Integer id){
        publicityTemplateService.deleteByID(id);
        return JsonResult.ok();
    }

    //删除底料信息
    @RequestMapping("deleteBase")
    public JsonResult deleteBase(Integer id){
        baseTradeService.deleteByID(id);
        return JsonResult.ok();
    }


}
