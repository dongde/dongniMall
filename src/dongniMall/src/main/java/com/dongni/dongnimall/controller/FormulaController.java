package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.common.ImageFileUploadUtil;
import com.dongni.dongnimall.manager.FormulaService;
import com.dongni.dongnimall.pojo.FormulaDO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.dongni.dongnimall.controller.BaseController.FORMULA_SAVE_PATH;

/**
 * 配方交易管理
 */
@RestController
@RequestMapping("formula")
public class FormulaController {

    @Autowired
    private FormulaService formulaService;

    @Autowired
    private Sid sid;


    //配方总览
    @RequestMapping("list")
    public PageData showFormulaList(Integer page, Integer limit, String formulaName){
        return formulaService.selectAllFormula(page,limit,formulaName);
    }


    //添加和修改配方
    @RequestMapping("add")
    public JsonResult insertformula(String id, String formulaName, Float formulaPrice, String formulaDescription, Float samplePrice, Float flyPrice, String factoryAdress, MultipartFile file) {
        if ("".equals(formulaName) || "".equals(formulaDescription) || formulaPrice == null || "".equals(factoryAdress)||samplePrice==null||flyPrice==null) {
            return JsonResult.errorMsg("数据不能为空");

        }
        FormulaDO formulaDO = new FormulaDO();
        formulaDO.setFormulaName(formulaName);
        formulaDO.setFormulaPrice(formulaPrice);
        formulaDO.setFormulaDescription(formulaDescription);
        formulaDO.setSamplePrice(samplePrice);
        formulaDO.setFlyPrice(flyPrice);
        formulaDO.setFactoryAdress(factoryAdress);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        formulaDO.setUpdateTime(dateString);
        if(id==null||"".equals(id)){
            String ids = sid.nextShort();
            String DBpath = ImageFileUploadUtil.uploadFile(file, FORMULA_SAVE_PATH);
            formulaDO.setFormulaURL(DBpath);
            formulaDO.setId(ids);
            formulaService.insertFormula(formulaDO);
            return JsonResult.ok();
        }else {
            if(file!=null) {
                String DBpath = ImageFileUploadUtil.uploadFile(file, FORMULA_SAVE_PATH);
                formulaDO.setFormulaURL(DBpath);
            }
            formulaDO.setId(id);
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
