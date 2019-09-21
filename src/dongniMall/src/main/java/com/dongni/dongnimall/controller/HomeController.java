package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.common.BannerUsedEnum;
import com.dongni.dongnimall.common.ImageFileUploadUtil;
import com.dongni.dongnimall.manager.BannerService;
import com.dongni.dongnimall.manager.SmallImageService;
import com.dongni.dongnimall.pojo.BannerDO;
import com.dongni.dongnimall.pojo.SmallImageDO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.n3r.idworker.Sid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


/**
 * @author cengshuai on 2019-09-02.
 * @version 1.0
 */
@RestController
@RequestMapping("/home")
public class HomeController extends BaseController {

    @Autowired
    private BannerService bannerService;
    @Autowired
    private SmallImageService smallImageService;
    @Autowired
    private Sid sid;

    @RequestMapping("/getBannerImageList")
    public PageData getBannerImageList(Integer page, Integer limit) {
        return bannerService.queryBannerList(page, limit);
    }

    @RequestMapping("/uploadBanner")
    public JsonResult uploadBanner(@RequestParam("file") MultipartFile file, @RequestParam("url") String url) {
        if (StringUtils.isBlank(url)) {
            return JsonResult.errorMsg("url不能为空！");
        }
        if (file != null) {
            String pathDB = ImageFileUploadUtil.uploadFile(file, BANNER_IMAGES_PATH);
            BannerDO bannerDO = new BannerDO();
            bannerDO.setId(sid.nextShort());
            bannerDO.setBanner_img(pathDB);
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String new_date = simpleDateFormat.format(date);
            bannerDO.setCreate_time(new_date);
            bannerDO.setUrl(url);
            bannerDO.setIs_used(BannerUsedEnum.UNUSED.getValue());
            bannerService.addBanner(bannerDO);

        } else {
            return JsonResult.errorMsg("上传文件不能为空");
        }

        return JsonResult.ok();
    }

    @RequestMapping("/removeBanners")
    public JsonResult removeBanners(@RequestParam("ids[]") String[] ids) {
        bannerService.removeBanner(Arrays.asList(ids));
        return JsonResult.ok();
    }

    @RequestMapping("/changeBannerUsed")
    public JsonResult changeBannerUsed(String id, Integer status) {
        if (StringUtils.isBlank(id) || status == null) {
            return JsonResult.errorMsg("修改出错");
        } else {
            Integer maxCount = bannerService.queryBannerUsedCount();
            BannerDO bannerDO = new BannerDO();
            bannerDO.setId(id);
            if (status == 1) {
                bannerDO.setIs_used(0);
            } else if (status == 0) {
                if (maxCount >= MAX_BANNER_COUNT) {
                    return JsonResult.errorMsg("轮播图使用已达上限");
                }
                bannerDO.setIs_used(1);
            }
            bannerService.changeUsedStatus(bannerDO);
            return JsonResult.ok();
        }
    }

    @RequestMapping("/getSmallImageList")
    public PageData getSmallImageList(Integer page, Integer limit) {
        return smallImageService.querySmallImageList(page, limit);
    }

    @RequestMapping("/uploadSmallImage")
    public JsonResult uploadSmallImage(@RequestParam("file") MultipartFile file, @RequestParam("url") String url, @RequestParam("description") String description) {

        if (file != null) {
            String pathDB = ImageFileUploadUtil.uploadFile(file, SMALL_IMAGES_PATH);
            SmallImageDO smallImage = new SmallImageDO();
            smallImage.setId(sid.nextShort());
            smallImage.setSmallImage_img(pathDB);
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String new_date = simpleDateFormat.format(date);
            smallImage.setCreate_time(new_date);
            smallImage.setUrl(url);
            smallImage.setDescription(description);
            smallImage.setPosition(1);
            smallImage.setIs_used(BannerUsedEnum.UNUSED.getValue());
            smallImageService.addSmallImage(smallImage);

        } else {
            return JsonResult.errorMsg("上传图片不能为空");
        }
        if (StringUtils.isBlank(url)) {
            return JsonResult.errorMsg("url不能为空！");
        }
        if (StringUtils.isBlank(description)) {
            return JsonResult.errorMsg("图片描述不能为空！");
        }

        return JsonResult.ok();
    }

    @RequestMapping("/removeSmallImages")
    public JsonResult removeSmallImages(@RequestParam("ids[]") String[] ids) {
        smallImageService.removeSmallImage(Arrays.asList(ids));
        return JsonResult.ok();
    }

    @RequestMapping("/changeSmallImageUsed")
    public JsonResult changeSmallImageUsed(String id, Integer status) {
        if (StringUtils.isBlank(id) || status == null) {
            return JsonResult.errorMsg("修改出错");
        } else {
            Integer maxCount = smallImageService.querySmallImageUsedCount();
            SmallImageDO smallImageDO = new SmallImageDO();
            smallImageDO.setId(id);
            if (status == 1) {
                smallImageDO.setIs_used(0);
            } else if (status == 0) {
                if (maxCount >= MAX_SMALL_IMAGES_COUNT) {
                    return JsonResult.errorMsg("小图使用已达上限");
                }
                smallImageDO.setIs_used(1);
            }
            smallImageService.modifySmallImage(smallImageDO);
            return JsonResult.ok();
        }
    }

    @RequestMapping("/modifySmallImagePosition")
    public JsonResult modifySmallImagePosition(String id, Integer position) {
        if (StringUtils.isBlank(id) || position == null) {
            return JsonResult.errorMsg("修改出错");
        } else {
            SmallImageDO smallImageDO = new SmallImageDO();
            smallImageDO.setId(id);
            smallImageDO.setPosition(position);
            smallImageService.modifySmallImage(smallImageDO);
            return JsonResult.ok();
        }
    }
}
