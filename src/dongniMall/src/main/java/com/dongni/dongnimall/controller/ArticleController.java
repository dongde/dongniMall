package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.base.storage.FileUploadManager;
import com.dongni.dongnimall.base.storage.Response;
import com.dongni.dongnimall.manager.ArticleService;
import com.dongni.dongnimall.pojo.ActicleDO;
import com.dongni.dongnimall.vo.EditUploadDTO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 新闻资讯管理
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private FileUploadManager fileUploadManager;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private Sid sid;


    //文章数据总览
    @RequestMapping("/list")
    public PageData list(Integer page, Integer limit,
                         @RequestParam(value = "title",required = false) String title,
                         @RequestParam(value = "source",required = false) String source){
        return articleService.selectAll(page,limit,title,source);

    }

    //添加和修改文章
    @RequestMapping("/add")
    public JsonResult insertList(String id,String title, String source, String summary, String content,MultipartFile file) throws IOException {
        if (StringUtils.isBlank(title) || StringUtils.isBlank(source) || StringUtils.isBlank(summary) || StringUtils.isBlank(content)) {
            return JsonResult.errorMsg("数据不能为空");
        }
        ActicleDO acticleDO = new ActicleDO();
        acticleDO.setContent(content);
        acticleDO.setSource(source);
        acticleDO.setSummary(summary);
        //时间字符串转化
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        acticleDO.setUpdateTime(dateString);
        acticleDO.setTitle(title);
        if(StringUtils.isBlank(id)){
            String ids = sid.nextShort();
            Response response = fileUploadManager.upload(file.getInputStream());
            acticleDO.setId(ids);
            acticleDO.setImageURL(response.getUrl());
            articleService.insertObject(acticleDO);
            return JsonResult.ok(acticleDO);
        }else {
            if(file!=null) {
                Response response2 = fileUploadManager.upload(file.getInputStream());
                acticleDO.setImageURL(response2.getUrl());
            }
            articleService.updateNews(acticleDO,id);
            return JsonResult.ok(acticleDO);
        }


    }





    //上传图片接口
    @RequestMapping("/uploadBanner")
    public EditUploadDTO uploadBanner(MultipartFile file) throws IOException {

        Response response = fileUploadManager.upload(file.getInputStream());

        Map<String,String> map = new HashMap<>();
        String imageURL = response.getUrl();
        map.put("src",imageURL);
        return EditUploadDTO.ok(map);


    }

    //删除文章对应数据
    @RequestMapping("delete")
    public JsonResult deleteList(String id){
        articleService.deleteNews(id);
        return JsonResult.ok();
    }









}