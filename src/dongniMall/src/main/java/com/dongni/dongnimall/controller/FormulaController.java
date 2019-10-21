package com.dongni.dongnimall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dongni.dongnimall.base.storage.FileUploadManager;
import com.dongni.dongnimall.base.storage.Response;
import com.dongni.dongnimall.dao.FormulaUploadMapper;
import com.dongni.dongnimall.dao.RawMaterialMapper;
import com.dongni.dongnimall.manager.*;
import com.dongni.dongnimall.pojo.*;
import com.dongni.dongnimall.vo.FormulaVO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private FileUploadManager fileUploadManager;

    @Autowired
    private FormulaUploadService formulaUploadService;

    @Autowired
    private RawMaterialService rawMaterialService;

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
                                    @RequestParam(value = "allURL[]", required = false) String[] allURL, String baseStoreId, String formulaFile) {
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
        if (StringUtils.isBlank(formulaFile)) {
            return JsonResult.errorMsg("请上传配方文件");
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
        formulaDO.setFormulaFile(formulaFile);
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

    @PostMapping("/uploadFormulaFile")
    public JsonResult uploadFormulaFile(MultipartFile file) throws IOException {
        if (file == null) {
            return JsonResult.errorMsg("配方上传出错");
        }
        Response response = fileUploadManager.upload(file.getInputStream());
        return JsonResult.ok(response.getUrl());
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
    public JsonResult addUserFormula(String user_phone, String formula_id, String formula_transaction_record_id) {
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

    //查询用户是否有配方的购买记录
    @GetMapping("/queryUserFormulaByUserAndFormula")
    public JsonResult queryUserFormulaByUserAndFormula(String user_phone, String formula_id) {
        if (StringUtils.isBlank(user_phone) || StringUtils.isBlank(formula_id)) {
            return JsonResult.errorMsg("查询出错");
        }
        return JsonResult.ok(userFormulaService.queryUserFormulaByUserAndFormula(user_phone, formula_id));
    }

    //添加配方上传信息
    @PostMapping("/addFormulaUpload")
    public JsonResult addFormulaUpload(@RequestBody JSONObject jsonObject) {
        System.out.println(jsonObject);
        String formula_upload_name = jsonObject.getString("formula_upload_name");
        String user_phone = jsonObject.getString("user_phone");
        String flour_process = jsonObject.getString("flour_process");
        String cooking_pot_method = jsonObject.getString("cooking_pot_method");
        String description = jsonObject.getString("description");
        JSONArray raw_materials = jsonObject.getJSONArray("raw_materials");

        if (StringUtils.isBlank(formula_upload_name) || StringUtils.isBlank(user_phone) || StringUtils.isBlank(flour_process) || StringUtils.isBlank(cooking_pot_method) || raw_materials.size() == 0) {
            return JsonResult.errorMsg("上传出错");
        }
        FormulaUploadDO formulaUploadDO = new FormulaUploadDO();
        String id = sid.nextShort();
        formulaUploadDO.setId(id);
        formulaUploadDO.setFormula_upload_name(formula_upload_name);
        formulaUploadDO.setUser_phone(user_phone);
        formulaUploadDO.setFlour_process(flour_process);
        formulaUploadDO.setCooking_pot_method(cooking_pot_method);
        formulaUploadDO.setDescription(description);
        formulaUploadDO.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm;ss").format(new Date()));
        formulaUploadDO.setStatus(0);
        List<RawMaterialDO> list = new ArrayList<>();
        for (int i = 0; i < raw_materials.size(); i++) {
            RawMaterialDO rawMaterialDO = new RawMaterialDO();
            rawMaterialDO.setId(sid.nextShort());
            rawMaterialDO.setFormula_upload_id(id);
            rawMaterialDO.setProcessing_method(raw_materials.getJSONObject(i).getString("processing_method"));
            rawMaterialDO.setRaw_material_name(raw_materials.getJSONObject(i).getString("raw_material_name"));
            rawMaterialDO.setVariety(raw_materials.getJSONObject(i).getString("variety"));
            rawMaterialDO.setWeight(raw_materials.getJSONObject(i).getString("weight"));
            list.add(rawMaterialDO);
        }
        formulaUploadService.addFormulaUpload(formulaUploadDO);
        rawMaterialService.addRawMaterials(list);

        return JsonResult.ok();
    }

    //查询配方上传记录
    @GetMapping("/queryFormulaUpload")
    public PageData queryFormulaUpload(Integer page, Integer limit, String user_phone, String formula_upload_name) {
        return formulaUploadService.queryFormulaUploadList(page, limit, user_phone, formula_upload_name);
    }

    @PostMapping("/modifyFormulaUpload")
    public JsonResult modifyFormulaUpload(String id, Integer status) {
        if (StringUtils.isBlank(id) || status == null) {
            return JsonResult.errorMsg("出错");
        }
        FormulaUploadDO formulaUploadDO = new FormulaUploadDO();
        formulaUploadDO.setId(id);
        formulaUploadDO.setStatus(status);
        formulaUploadService.modifyFormulaUpload(formulaUploadDO);
        return JsonResult.ok();
    }
}
