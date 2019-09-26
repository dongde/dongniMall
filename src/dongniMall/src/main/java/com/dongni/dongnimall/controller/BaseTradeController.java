package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.base.storage.FileUploadManager;
import com.dongni.dongnimall.base.storage.Response;
import com.dongni.dongnimall.manager.BaseTradeService;
import com.dongni.dongnimall.pojo.BaseStoreDO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private Sid sid;

    //底料商品总览
    @RequestMapping("list")
    public PageData tradeList(Integer page, Integer limit, String tradeName, String tradeType){
        return baseTradeService.selectAllTrade(page,limit,tradeName,tradeType);
    }

    //添加和修改底料
    @RequestMapping("add")
    public JsonResult insertTrade(String id,String tradeName, String tradeType, Float price, String tradeURL, MultipartFile file) throws IOException {
        if (StringUtils.isBlank(tradeName) || StringUtils.isBlank(tradeType) || price == null || StringUtils.isBlank(tradeURL)) {
            return JsonResult.errorMsg("数据不能为空");
        }
        System.out.println(file);
        BaseStoreDO baseStoreDO = new BaseStoreDO();
        baseStoreDO.setPrice(price);
        baseStoreDO.setTradeName(tradeName);
        baseStoreDO.setTradeType(tradeType);
        baseStoreDO.setTradeURL(tradeURL);
        baseStoreDO.setViewCount(1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        baseStoreDO.setUpdateTime(dateString);
        if(StringUtils.isBlank(id)){
            String ids = sid.nextShort();
            Response response = fileUploadManager.upload(file.getInputStream());
            baseStoreDO.setImageURL(response.getUrl());
            baseStoreDO.setId(ids);
            baseTradeService.insertTrade(baseStoreDO);
            return JsonResult.ok(baseStoreDO);
        }else {
            if(file!=null) {
                Response response = fileUploadManager.upload(file.getInputStream());
                baseStoreDO.setImageURL(response.getUrl());
            }
            baseStoreDO.setId(id);
            baseTradeService.updateTrade(baseStoreDO);
            return JsonResult.ok(baseStoreDO);
        }
    }

    //删除底料信息
    @RequestMapping("delete")
    public JsonResult deleteBase(String id){
        baseTradeService.deleteByID(id);
        return JsonResult.ok();
    }

}
