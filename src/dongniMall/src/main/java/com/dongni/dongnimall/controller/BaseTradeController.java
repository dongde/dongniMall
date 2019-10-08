package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.base.storage.FileUploadManager;
import com.dongni.dongnimall.base.storage.Response;
import com.dongni.dongnimall.manager.BaseImageService;
import com.dongni.dongnimall.manager.BaseTradeService;
import com.dongni.dongnimall.pojo.BaseImageDO;
import com.dongni.dongnimall.pojo.BaseStoreDO;
import com.dongni.dongnimall.vo.BaseStoreVO;
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
import java.util.Arrays;
import java.util.Date;

import static com.dongni.dongnimall.controller.BaseController.REGEX;

/**
 * 底料商城管理
 */

@RestController
@RequestMapping("baseTrade")
public class BaseTradeController {

    @Autowired
    private FileUploadManager fileUploadManager;
    @Autowired
    private BaseTradeService baseTradeService;

    @Autowired
    private BaseImageService baseImageService;

    @Autowired
    private Sid sid;

    //底料商品总览
    @RequestMapping("list")
    public PageData tradeList(Integer page, Integer limit, String tradeName, String tradeType){
        return baseTradeService.selectAllTrade(page,limit,tradeName,tradeType);
    }

    //底料商品总览
    @RequestMapping("smallimage")
    public JsonResult smallimage(String id){
        return baseImageService.findAllbyID(id);
    }


    //底料商品总览
    @RequestMapping("listAll")
    public BaseStoreVO trademessage(String id){
        return baseTradeService.selectDetails(id);
    }

    //添加和修改底料
    @RequestMapping("add")
    public JsonResult insertTrade(String id, String tradeName, @RequestParam(value = "tradeType", required = false)String tradeType, Float price, String tradeURL, String content,
                                  @RequestParam(value = "allURL[]", required = false) String[] allURL, String bigImage, String alipay, String weChat) throws IOException {

        System.out.println(Arrays.toString(allURL));
        if(StringUtils.isBlank(tradeName)){
            return JsonResult.errorMsg("底料名称不能为空");
        }
        if(StringUtils.isBlank(alipay)){
            return JsonResult.errorMsg("支付宝图片不能为空");
        }
        if(StringUtils.isBlank(bigImage)){
            return JsonResult.errorMsg("封面大图不能为空");
        }
        if(StringUtils.isBlank(weChat)){
            return JsonResult.errorMsg("微信图片不能为空");
        }
        if(StringUtils.isBlank(tradeType)){
            return JsonResult.errorMsg("类型不能为空");
        }
        if(StringUtils.isBlank(tradeURL)){
            return JsonResult.errorMsg("链接不能为空");
        }
        if(StringUtils.isBlank(content)){
            return JsonResult.errorMsg("内容不能为空");
        }
        if(allURL == null){
            return JsonResult.errorMsg("小图不能为空");
        }
        if(price == null){
            return JsonResult.errorMsg("价格不能为空");
        }
        else {
            if (!tradeURL.matches(REGEX)) {
                return JsonResult.errorMsg("请输入正确的链接地址");
            }
        }
        BaseStoreDO baseStoreDO = new BaseStoreDO();
        baseStoreDO.setPrice(price);
        baseStoreDO.setAlipay(alipay);
        baseStoreDO.setWechat(weChat);
        baseStoreDO.setContent(content);
        baseStoreDO.setTradeName(tradeName);
        baseStoreDO.setTradeType(tradeType);
        baseStoreDO.setTradeURL(tradeURL);
        baseStoreDO.setViewCount(1);
        baseStoreDO.setBigImage(bigImage);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        baseStoreDO.setUpdateTime(dateString);

        if(StringUtils.isBlank(id)){

            String ids = sid.nextShort();
            for (String imageURL : allURL) {
                String id1 = sid.nextShort();
                BaseImageDO baseImageDO = new BaseImageDO();
                baseImageDO.setId(id1);
                baseImageDO.setImageURL(imageURL);
                baseImageDO.setBaseStoreId(ids);
                baseImageService.insertImageURL(baseImageDO);
            }
            baseStoreDO.setId(ids);
            baseTradeService.insertTrade(baseStoreDO);
            return JsonResult.ok(baseStoreDO);
        }else {
            for (String imageURL : allURL) {
                String id1 = sid.nextShort();
                BaseImageDO baseImageDO = new BaseImageDO();
                baseImageDO.setId(id1);
                baseImageDO.setImageURL(imageURL);
                baseImageDO.setBaseStoreId(id);
                baseImageService.insertImageURL(baseImageDO);
            }
            baseStoreDO.setId(id);
            baseTradeService.updateTrade(baseStoreDO);
            return JsonResult.ok(baseStoreDO);
        }

    }

    //添加小图
    @RequestMapping("uploadImage")
    public JsonResult uploadImage(MultipartFile file) throws IOException {
        if(file==null){
            return JsonResult.errorMsg("数据不能为空");
        }
        Response response = fileUploadManager.upload(file.getInputStream());
        String url = response.getUrl();

        return JsonResult.ok(url);
    }
    //删除小图
    @RequestMapping("deleteImage")
    public JsonResult deleteImage(@RequestParam(value = "imageID[]", required = false)String[] imageID){
        if(imageID == null){
            return JsonResult.ok();
        }
        return baseImageService.deleteByID(imageID);
    }

    //图片上传返回的url
    @RequestMapping("uploadImages")
    public JsonResult uploadImages(MultipartFile file) throws IOException {
        if(file==null){
            return JsonResult.errorMsg("数据不能为空");
        }
        Response response = fileUploadManager.upload(file.getInputStream());
        String url = response.getUrl();
        return JsonResult.ok(url);
    }

    //删除底料信息
    @RequestMapping("delete")
    public JsonResult deleteBase(String id){
        baseTradeService.deleteByID(id);
        return JsonResult.ok();
    }

}
