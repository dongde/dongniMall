package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.manager.BaseImageService;
import com.dongni.dongnimall.manager.FormulaService;
import com.dongni.dongnimall.pojo.BaseImageDO;
import com.dongni.dongnimall.pojo.FormulaDO;
import com.dongni.dongnimall.vo.FormulaVO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 配方交易管理
 */
@RestController
@RequestMapping("formula")
public class FormulaController {


    @Autowired
    private BaseImageService baseImageService;

    @Autowired
    private FormulaService formulaService;

    @Autowired
    private Sid sid;

    //配方总览
    @RequestMapping("list")
    public PageData showFormulaList(Integer page, Integer limit, String formulaName){
        return formulaService.selectAllFormula(page,limit,formulaName);
    }

    //单条配方详情信息
    @RequestMapping("details")
    public FormulaVO selectDetails(String id){
        return formulaService.selectDetails(id);
    }

    //添加和修改配方
    @RequestMapping("add")
    public JsonResult insertFormula(String id, String formulaName, Float formulaPrice, String formulaDescription, Float samplePrice, Float flyPrice, String factoryAddress,String bigPicture,
                                    @RequestParam(value = "allURL[]", required = false) String[] allURL,String baseStoreId) {
        if(StringUtils.isBlank(formulaName)){
            return JsonResult.errorMsg("配方名称不能为空");
        }
        if(StringUtils.isBlank(formulaDescription)){
            return JsonResult.errorMsg("配方描述不能为空");
        }
        if(formulaPrice==null){
            return JsonResult.errorMsg("配方价格不能为空");
        }
        if(StringUtils.isBlank(factoryAddress)){
            return JsonResult.errorMsg("料场地址不能为空");
        }
        if(samplePrice==null){
            return JsonResult.errorMsg("样品价格不能为空");
        }
        if(flyPrice==null){
            return JsonResult.errorMsg("炒制价格不能为空");
        }
        if(StringUtils.isBlank(formulaName)){
            return JsonResult.errorMsg("封面大图不能为空");
        }
        if(StringUtils.isBlank(baseStoreId)){
            return JsonResult.errorMsg("请选择试经营底料");
        }
        FormulaDO formulaDO = new FormulaDO();
        formulaDO.setFormulaName(formulaName);
        formulaDO.setFormulaPrice(formulaPrice);
        formulaDO.setFormulaDescription(formulaDescription);
        formulaDO.setSamplePrice(samplePrice);
        formulaDO.setFlyPrice(flyPrice);
        formulaDO.setFactoryAddress(factoryAddress);
        formulaDO.setBigPicture(bigPicture);
        formulaDO.setBaseStoreId(baseStoreId);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        formulaDO.setUpdateTime(dateString);
        if(StringUtils.isBlank(id)){
            if(allURL==null){
                return JsonResult.errorMsg("配方图片不能为空");
            }
            String ids = sid.nextShort();
            formulaDO.setId(ids);
            for (String imageURL : allURL) {
                String id1 = sid.nextShort();   //将小图url数组存入数据库中，联合表id
                BaseImageDO baseImageDO = new BaseImageDO();
                baseImageDO.setId(id1);
                baseImageDO.setImageURL(imageURL);
                baseImageDO.setBaseStoreId(ids);
                baseImageService.insertImageURL(baseImageDO);
            }
            formulaService.insertFormula(formulaDO);
            return JsonResult.ok();
        }else {
            formulaDO.setId(id);
            if (allURL != null) {
                for (String imageURL : allURL) {
                    String id1 = sid.nextShort();   //将小图url数组存入数据库中，联合表id
                    BaseImageDO baseImageDO = new BaseImageDO();
                    baseImageDO.setId(id1);
                    baseImageDO.setImageURL(imageURL);
                    baseImageDO.setBaseStoreId(id);
                    baseImageService.insertImageURL(baseImageDO);
                }
            }
            formulaService.updateFormula(formulaDO);
            return JsonResult.ok();
        }

    }

    //删除配方信息
    @RequestMapping("delete")
    public JsonResult deleteFormula(String id){
        formulaService.deleteByID(id);
        return JsonResult.ok();
    }

}
