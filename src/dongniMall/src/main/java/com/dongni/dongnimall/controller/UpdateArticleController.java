package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.manager.NewsService;
import com.dongni.dongnimall.manager.PublicityTemplateService;
import com.dongni.dongnimall.pojo.NewsInformation;
import com.dongni.dongnimall.pojo.PublicityTemplate;
import com.dongni.dongnimall.vo.EditUploadDTO;
import com.dongni.dongnimall.vo.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.dongni.dongnimall.controller.BaseController.IMAGE_SAVE_PATH;

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

        Map<String,String> map = new HashMap<>();
        if (file != null) {

            FileOutputStream fileOutputStream = null;
            InputStream fileInputStream = null;
            //获取文件名
            String fileName = file.getOriginalFilename();
            if (StringUtils.isNotBlank(fileName)) {
                //生成数据库存储的路径
                String randomStr = UUID.randomUUID().toString();
                String pathDB = "/" + randomStr + fileName.substring(0, fileName.indexOf(".")) + ".jpg";
                //生成文件本地存储路径
                String filePath = IMAGE_SAVE_PATH + fileName;
                String imageURL = "http://localhost:8080/"+fileName;
                map.put("src",imageURL);
                //创建本地文件
                File newFile = new File(filePath);

                if (newFile.getParentFile() != null || newFile.getParentFile().isDirectory()) {
                    //创建父文件夹
                    newFile.getParentFile().mkdirs();
                }
                try {
                    fileInputStream = file.getInputStream();
                    fileOutputStream = new FileOutputStream(newFile);
                    IOUtils.copy(fileInputStream, fileOutputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }


        } else {
            return EditUploadDTO.errorMessage("上传出错");
        }

        return EditUploadDTO.ok(map);

    }

    //删除文章对应数据
    @RequestMapping("delete")
    public JsonResult deleteList(Integer id){
        newsService.deleteNews(id);
        return JsonResult.ok();
    }




    @RequestMapping("updateTemplate")
    public JsonResult updateTemplate(Integer id,String templateName,String templateType,Float price,String image,String description){
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

    //删除模板
    @RequestMapping("deleteTemplate")
    public JsonResult deleteTemplate(Integer id){
        publicityTemplateService.deleteByID(id);
        return JsonResult.ok();
    }


}
