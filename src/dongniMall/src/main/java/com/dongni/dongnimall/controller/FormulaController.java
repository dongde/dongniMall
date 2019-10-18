package com.dongni.dongnimall.controller;

import com.alibaba.fastjson.JSONObject;
import com.dongni.dongnimall.manager.BaseImageService;
import com.dongni.dongnimall.manager.FormulaService;
import com.dongni.dongnimall.manager.FormulaTransactionRecordService;
import com.dongni.dongnimall.manager.UserFormulaService;
import com.dongni.dongnimall.pojo.BaseImageDO;
import com.dongni.dongnimall.pojo.FormulaDO;
import com.dongni.dongnimall.pojo.FormulaTransactionRecordDO;
import com.dongni.dongnimall.pojo.UserFormulaDO;
import com.dongni.dongnimall.vo.FormulaVO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private FormulaTransactionRecordService formulaTransactionRecordService;

    @Autowired
    private UserFormulaService userFormulaService;

    @Autowired
    private Sid sid;

    //配方总览
    @RequestMapping("list")
    public PageData showFormulaList(Integer page, Integer limit, String formulaName) {
        return formulaService.selectAllFormula(page, limit, formulaName);
    }

    //单条配方详情信息
    @RequestMapping("details")
    public FormulaVO selectDetails(String id) {
        return formulaService.selectDetails(id);
    }

    //添加和修改配方
    @RequestMapping("add")
    public JsonResult insertFormula(String id, String formulaName, Float formulaPrice, String formulaDescription, Float samplePrice, Float flyPrice, String factoryAddress, String bigPicture,
                                    @RequestParam(value = "allURL[]", required = false) String[] allURL, String baseStoreId) {
        if (StringUtils.isBlank(formulaName)) {
            return JsonResult.errorMsg("配方名称不能为空");
        }
        if (StringUtils.isBlank(formulaDescription)) {
            return JsonResult.errorMsg("配方描述不能为空");
        }
        if (formulaPrice == null) {
            return JsonResult.errorMsg("配方价格不能为空");
        }
        if (StringUtils.isBlank(factoryAddress)) {
            return JsonResult.errorMsg("料场地址不能为空");
        }
        if (samplePrice == null) {
            return JsonResult.errorMsg("样品价格不能为空");
        }
        if (flyPrice == null) {
            return JsonResult.errorMsg("炒制价格不能为空");
        }
        if (StringUtils.isBlank(formulaName)) {
            return JsonResult.errorMsg("封面大图不能为空");
        }
        if (StringUtils.isBlank(baseStoreId)) {
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
        if (StringUtils.isBlank(id)) {
            if (allURL == null) {
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
        } else {
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
    public JsonResult deleteFormula(String id) {
        formulaService.deleteByID(id);
        return JsonResult.ok();
    }

    //添加配方交易记录
    @PostMapping("/addFormulaTransactionRecord")
    public JsonResult addFormulaTransactionRecord(@RequestBody FormulaTransactionRecordDO formulaTransactionRecordDO) {
        if (StringUtils.isBlank(formulaTransactionRecordDO.getUser_phone()) || StringUtils.isBlank(formulaTransactionRecordDO.getFormula_id()) || formulaTransactionRecordDO.getPayment_amount() == null || formulaTransactionRecordDO.getPayment_method() == null) {
            return JsonResult.errorMsg("错误添加");
        }
        formulaTransactionRecordDO.setId(sid.nextShort());
        formulaTransactionRecordDO.setPayment_status(0);
        formulaTransactionRecordDO.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        formulaTransactionRecordService.addFormulaTransactionRecord(formulaTransactionRecordDO);
        return JsonResult.ok();
    }

    //删除交易记录
    @PostMapping("/removeFormulaTransactionRecord")
    public JsonResult removeFormulaTransactionRecord(String id) {
        if (StringUtils.isBlank(id)) {
            return JsonResult.errorMsg("删除错误");
        }
        formulaTransactionRecordService.removeFormulaTransactionRecord(id);
        return JsonResult.ok();
    }

    //获取所有交易记录
    @GetMapping("/queryFormulaTransactionRecord")
    public PageData queryFormulaTransactionRecord(Integer page, Integer limit) {
        return formulaTransactionRecordService.queryFormulaTransactionRecord(page, limit);
    }

    //查询用户是否有配方的购买记录
    @GetMapping("/queryFormulaTransactionRecordByUserAndFormula")
    public JsonResult queryFormulaTransactionRecordByUserAndFormula(String user_phone,String formula_id){
        if(StringUtils.isBlank(user_phone)||StringUtils.isBlank(formula_id)){
            return JsonResult.errorMsg("查询出错");
        }
        return JsonResult.ok(formulaTransactionRecordService.queryFormulaTransactionRecordByUserAndFormula(user_phone,formula_id));
    }

    //修改交易信息
    @PostMapping("/modifyFormulaTransactionRecord")
    public JsonResult modifyFormulaTransactionRecord(FormulaTransactionRecordDO formulaTransactionRecordDO) {
        if (StringUtils.isBlank(formulaTransactionRecordDO.getId())) {
            return JsonResult.errorMsg("修改出错");
        }
        formulaTransactionRecordService.modifyFormulaTransactionRecord(formulaTransactionRecordDO);
        return JsonResult.ok();
    }

    //添加用户购买的配方记录
    @PostMapping("/addUserFormula")
    public JsonResult addUserFormula(String user_phone, String formula_id,String formula_transaction_record_id) {
        if (StringUtils.isBlank(user_phone) || StringUtils.isBlank(formula_id)) {
            return JsonResult.errorMsg("添加错误");
        }
        UserFormulaDO userFormulaDO = new UserFormulaDO();
        userFormulaDO.setUser_phone(user_phone);
        userFormulaDO.setFormula_id(formula_id);
        userFormulaDO.setId(sid.nextShort());
        userFormulaDO.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        userFormulaService.addUserFormula(userFormulaDO);
        FormulaTransactionRecordDO formulaTransactionRecordDO = new FormulaTransactionRecordDO();
        formulaTransactionRecordDO.setId(formula_transaction_record_id);
        formulaTransactionRecordDO.setPayment_status(1);
        formulaTransactionRecordService.modifyFormulaTransactionRecord(formulaTransactionRecordDO);
        return JsonResult.ok();
    }

    //查询用户购买的配方的记录
    @GetMapping("/queryUserFormula")
    public JsonResult queryUserFormula(String user_phone) {
        return JsonResult.ok(userFormulaService.queryUserFormla(user_phone));
    }
}
