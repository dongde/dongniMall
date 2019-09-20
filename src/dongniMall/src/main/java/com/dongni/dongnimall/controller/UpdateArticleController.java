package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.common.ImageFileUploadUtil;
import com.dongni.dongnimall.manager.BaseTradeService;
import com.dongni.dongnimall.manager.FormulaService;
import com.dongni.dongnimall.manager.NewsService;
import com.dongni.dongnimall.manager.PublicityTemplateService;
import com.dongni.dongnimall.vo.EditUploadDTO;
import com.dongni.dongnimall.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private FormulaService formulaService;


    //上传图片接口
    @RequestMapping("/uploadBanner")
    public EditUploadDTO uploadBanner(MultipartFile file) {

        String DBpath = ImageFileUploadUtil.uploadFile(file, TRADE_SAVE_PATH);

        Map<String,String> map = new HashMap<>();
        String imageURL = DBpath;
        map.put("src",imageURL);
        return EditUploadDTO.ok(map);


    }

    //删除文章对应数据
    @RequestMapping("delete")
    public JsonResult deleteList(Integer id){
        newsService.deleteNews(id);
        return JsonResult.ok();
    }


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

    //删除配方信息
    @RequestMapping("deleteFormula")
    public JsonResult deleteFormula(Integer id){
        formulaService.deleteByID(id);
        return JsonResult.ok();
    }


}
