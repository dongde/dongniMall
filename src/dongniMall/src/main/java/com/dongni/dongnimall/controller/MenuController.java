package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.base.storage.FileUploadManager;
import com.dongni.dongnimall.base.storage.Response;
import com.dongni.dongnimall.manager.TeachVideoService;
import com.dongni.dongnimall.pojo.TeachVideoDO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.n3r.idworker.Sid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cengshuai on 2019-09-11.
 * @version 1.0
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {
    @Autowired
    private TeachVideoService teachVideoService;
    @Autowired
    private Sid sid;
    @Autowired
    private FileUploadManager fileUploadManager;

    @RequestMapping("/queryTeachVideoList")
    public PageData queryTeachVideoList(Integer page, Integer limit, @RequestParam(value = "title", required = false) String title) {
        return teachVideoService.queryTeachVideoList(page, limit, title);
    }

    @RequestMapping("/removeTeachVideo")
    public JsonResult removeTeachVideo(String id) {
        if (StringUtils.isBlank(id)) {
            return JsonResult.errorMsg("删除失败");
        }
        teachVideoService.removeTeachVideo(id);
        return JsonResult.ok();
    }

    @RequestMapping("/addOrUpdateTeachVideo")
    public JsonResult addOrUpdateTeachVideo(@RequestParam(value = "file", required = false) MultipartFile file, String title, String videoUrl, String introduction, String content, String id) throws IOException {

        if (StringUtils.isBlank(title)) {
            return JsonResult.errorMsg("标题不能为空");
        }
        if (StringUtils.isBlank(videoUrl)) {
            return JsonResult.errorMsg("视频链接不能为空");
        } else {
            if (!videoUrl.matches(REGEX)) {
                return JsonResult.errorMsg("请输入正确的链接地址");
            }
        }
        if (StringUtils.isBlank(introduction)) {
            return JsonResult.errorMsg("简介不能为空");
        }
        if (StringUtils.isBlank(content)) {
            return JsonResult.errorMsg("内容不能为空");
        }
        TeachVideoDO teachVideoDO = new TeachVideoDO();
        teachVideoDO.setVideoUrl(videoUrl);
        teachVideoDO.setTitle(title);
        teachVideoDO.setContent(content);
        teachVideoDO.setIntroduction(introduction);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newDate = simpleDateFormat.format(date);
        teachVideoDO.setCreate_time(newDate);
        //ID为空是添加操作，不为空是修改操作
        if (StringUtils.isBlank(id)) {
            if (file == null) {
                return JsonResult.errorMsg("请上传图片");
            }
            Response response = fileUploadManager.upload(file.getInputStream());
            teachVideoDO.setCover(response.getUrl());
            teachVideoDO.setId(sid.nextShort());
            teachVideoDO.setCounts(0);
            teachVideoService.addTeachVideo(teachVideoDO);
        } else {
            teachVideoDO.setId(id);
            //file不为空则是更新了图片
            if (file != null) {
                Response response = fileUploadManager.upload(file.getInputStream());
                teachVideoDO.setCover(response.getUrl());
            }
            teachVideoService.modifyTeachVideo(teachVideoDO);
        }
        return JsonResult.ok();
    }
}
