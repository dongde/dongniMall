package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.manager.BaseTradeTypeService;
import com.dongni.dongnimall.pojo.BaseTradeTypeDO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 底料类型管理
 */
@RestController
@RequestMapping("baseTradeType")
public class BaseTradeTypeController {

    @Autowired
    private Sid sid;
    @Autowired
    private BaseTradeTypeService baseTradeTypeService;

    //底料类型总览
    @RequestMapping("list")
    public PageData showFormulaList(Integer page, Integer limit){
        System.out.println(page+limit);
        return baseTradeTypeService.selectAllType(page,limit);
    }

    //添加和修改底料
    @RequestMapping("add")
    public JsonResult insertTrade(String tradeType) {
        if(StringUtils.isBlank(tradeType)){
            return JsonResult.errorMsg("添加底料失败");
        }

        BaseTradeTypeDO baseTradeTypeDO = new BaseTradeTypeDO();
        baseTradeTypeDO.setType(tradeType);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        baseTradeTypeDO.setUpdateTime(dateString);

        String ids = sid.nextShort();
        baseTradeTypeDO.setId(ids);
        baseTradeTypeService.insertType(baseTradeTypeDO);
        return JsonResult.ok();
    }

    //删除底料信息
    @RequestMapping("delete")
    public JsonResult deleteBase(String id){
        baseTradeTypeService.deleteType(id);
        return JsonResult.ok();
    }

}
