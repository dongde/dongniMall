package com.dongni.dongnimall.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dongni.dongnimall.base.storage.FileUploadManager;
import com.dongni.dongnimall.base.storage.Response;
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
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

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
    public JsonResult insertFormula(String id, String formulaName, Float formulaPrice, String formulaDescription, String factoryAddress, String baseStoreId, String formulaFile
            , @RequestParam(value = "bigPicture", required = false) MultipartFile bigPicture, @RequestParam(value = "allURL") String allURL, @RequestParam(value = "delImgID") String delImgID
            , @RequestParam(value = "choosePracticalOperationDate", required = false) String choosePracticalOperationDate, @RequestParam(value = "chooseLearnAgainDate", required = false) String chooseLearnAgainDate, @RequestParam(value = "chooseAssistDate", required = false) String chooseAssistDate
            , @RequestParam(value = "raw_materials") String raw_materials) throws IOException {
        if (StringUtils.isBlank(formulaName)) {
            return JsonResult.errorMsg("配方名称不能为空");
        }
        if (StringUtils.isBlank(formulaDescription)) {
            return JsonResult.errorMsg("配方描述不能为空");
        }
        if (formulaPrice == null) {
            return JsonResult.errorMsg("配方价格不能为空");
        }
        if (bigPicture == null && StringUtils.isBlank(id)) {
            return JsonResult.errorMsg("请选择封面大图");
        }
        if (StringUtils.isBlank(allURL)) {
            return JsonResult.errorMsg("请选择配方小图");
        } else if (allURL.split(",").length < 3) {
            return JsonResult.errorMsg("配方小图必须为3张");
        } else if (allURL.split(",").length > 3) {
            return JsonResult.errorMsg("配方小图不能超过3张");
        }
        if (StringUtils.isBlank(formulaFile) && StringUtils.isBlank(id)) {
            return JsonResult.errorMsg("请上传配方文件");
        }
        if (StringUtils.isBlank(baseStoreId)) {
            return JsonResult.errorMsg("请选择试经营底料");
        }
        if (StringUtils.isBlank(factoryAddress)) {
            return JsonResult.errorMsg("料场地址不能为空");
        }
        JSONArray jsonArray = JSONArray.parseArray(raw_materials);
        if (jsonArray.size() == 0) {
            return JsonResult.errorMsg("请填写原料信息");
        }
        String formula_id = id;
        if (StringUtils.isBlank(formula_id)) {
            formula_id = sid.nextShort();
        }
        FormulaDO formulaDO = new FormulaDO();
        formulaDO.setId(formula_id);
        formulaDO.setFormulaName(formulaName);
        formulaDO.setFormulaPrice(formulaPrice);
        formulaDO.setFormulaDescription(formulaDescription);
        formulaDO.setFactoryAddress(factoryAddress);
        formulaDO.setBaseStoreId(baseStoreId);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        formulaDO.setUpdateTime(dateString);
        baseImageService.deleteByID(delImgID.split(","));
        for (String imageURL : allURL.split(",")) {
            if (StringUtils.isNotBlank(imageURL)) {
                String id1 = sid.nextShort();   //将小图url数组存入数据库中，联合表id
                BaseImageDO baseImageDO = new BaseImageDO();
                baseImageDO.setId(id1);
                baseImageDO.setImageURL(imageURL);
                baseImageDO.setBaseStoreId(formula_id);
                baseImageService.insertImageURL(baseImageDO);
            }
        }
        List<FormulaRawMaterialDO> list = new ArrayList<>();

        for (Object raw_material : jsonArray) {
            JSONObject jsonObject = JSONObject.parseObject((String) raw_material);
            FormulaRawMaterialDO formulaRawMaterialDO = new FormulaRawMaterialDO();
            formulaRawMaterialDO.setFormula_id(formulaDO.getId());
            formulaRawMaterialDO.setRaw_material_name(jsonObject.getString("raw_material_name"));
            formulaRawMaterialDO.setVariety(jsonObject.getString("variety"));
            formulaRawMaterialDO.setUnit_price(jsonObject.getBigDecimal("unit_price"));
            list.add(formulaRawMaterialDO);
        }
        StringBuilder noAppointment = new StringBuilder();
        for (String date : choosePracticalOperationDate.split(",")) {
            if (StringUtils.isNotBlank(date)) {
                if (noAppointment.length() > 0) {
                    noAppointment.append(",");
                }
                noAppointment.append(date);
            }
        }
        formulaDO.setPractical_operation_noAppointment(noAppointment.toString());
        StringBuilder learn_again_noAppointment = new StringBuilder();
        for (String date : chooseLearnAgainDate.split(",")) {
            if (StringUtils.isNotBlank(date)) {
                if (learn_again_noAppointment.length() > 0) {
                    learn_again_noAppointment.append(",");
                }
                learn_again_noAppointment.append(date);
            }
        }
        formulaDO.setLearn_again_noAppointment(learn_again_noAppointment.toString());
        StringBuilder assist_noAppointment = new StringBuilder();
        for (String date : chooseAssistDate.split(",")) {
            if (StringUtils.isNotBlank(date)) {
                if (assist_noAppointment.length() > 0) {
                    assist_noAppointment.append(",");
                }
                assist_noAppointment.append(date);
            }
        }
        formulaDO.setAssist_noAppointment(assist_noAppointment.toString());

        //新增操作
        if (StringUtils.isBlank(id)) {
            formulaDO.setFormulaFile(formulaFile);
            formulaDO.setBigPicture(fileUploadManager.upload(bigPicture.getInputStream()).getUrl());
            formulaService.insertFormula(formulaDO, list);
            return JsonResult.ok();
        } else {    //更新操作
            if (StringUtils.isNotBlank(formulaFile)) {
                formulaDO.setFormulaFile(formulaFile);
            }
            if (bigPicture != null) {
                formulaDO.setBigPicture(fileUploadManager.upload(bigPicture.getInputStream()).getUrl());
            }
            formulaService.updateFormula(formulaDO, list);
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
        if (userService.queryUserByPhone(formulaTransactionRecordDO.getUser_phone()) == null) {
            return JsonResult.errorMsg("用户不存在");
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
    public JsonResult modifyFormulaTransactionRecord(@RequestBody FormulaTransactionRecordDO formulaTransactionRecordDO) {
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

    //添加预约时间
    @PostMapping("/addAppointment")
    public JsonResult addAppointment(@RequestBody JSONObject jsonObject) {
        Integer appointment_type = jsonObject.getInteger("appointment_type");
        String date = jsonObject.getString("date");
        String id = jsonObject.getString("id");
        if (appointment_type == null || StringUtils.isBlank(date) || StringUtils.isBlank(id)) {
            return JsonResult.errorMsg("添加出错");
        }
        userFormulaService.addAppointment(appointment_type, date, id);
        return JsonResult.ok();
    }

    //查询用户购买的配方记录
    @GetMapping("/queryUserFormula")
    public JsonResult queryUserFormula(String user_phone) {
        return JsonResult.ok(userFormulaService.queryUserFormla(user_phone));
    }

    //删除用户购买的配方记录
    @PostMapping("/removeUserFormula")
    public JsonResult removeUserFormula(@RequestBody JSONObject jsonObject) {
        String user_phone = jsonObject.getString("user_phone");
        String formula_id = jsonObject.getString("formula_id");
        if (StringUtils.isBlank(user_phone) || StringUtils.isBlank(formula_id)) {
            return JsonResult.errorMsg("删除出错");
        }
        userFormulaService.deleteUserFormula(user_phone, formula_id);
        return JsonResult.ok();
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
            rawMaterialDO.setWeight(raw_materials.getJSONObject(i).getFloat("weight"));
            list.add(rawMaterialDO);
        }
        formulaUploadService.addFormulaUpload(formulaUploadDO);
        rawMaterialService.addRawMaterials(list);

        return JsonResult.ok();
    }

    @PostMapping("/removeFormulaUpload")
    public JsonResult removeFormulaUpload(@RequestBody JSONObject jsonObject) {
        String formula_upload_id = jsonObject.getString("formula_upload_id");
        if (StringUtils.isBlank(formula_upload_id)) {
            return JsonResult.errorMsg("删除出错");
        }
        formulaUploadService.removeFormulaUpload(formula_upload_id);
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

    //代炒购买
    @PostMapping("/addStirFry")
    public JsonResult addStirFry(@RequestBody JSONObject jsonObject) {
        System.out.println(jsonObject);
        JSONArray rawMaterials = jsonObject.getJSONArray("rawMaterials");
        String user_phone = jsonObject.getString("user_phone");
        BigDecimal payment_amount = jsonObject.getBigDecimal("payment_amount");
        Integer payment_method = jsonObject.getInteger("payment_method");
        String order_number = UUID.randomUUID().toString();
        for (int i = 0; i < rawMaterials.size(); i++) {
            JSONObject jsonObject1 = rawMaterials.getJSONObject(i);
            GoodsDO goodsDO = new GoodsDO();
            goodsDO.setGoods_name(jsonObject1.getString("name") + "(" + jsonObject1.getString("variety") + ")");
            goodsDO.setGoods_count(jsonObject1.getInteger("count"));
            goodsDO.setSubtotal(jsonObject1.getBigDecimal("subtotal"));
            goodsDO.setGoods_price(jsonObject1.getBigDecimal("price"));
            goodsDO.setGoods_img(jsonObject1.getString("img"));
            goodsDO.setOrder_number(order_number);
            goodsDO.setId(sid.nextShort());
            goodsDO.setUser_phone(user_phone);
            goodsService.addGoods(goodsDO);
        }
        OrderDO orderDO = new OrderDO();
        orderDO.setOrder_number(order_number);
        orderDO.setOrder_status(1);
        orderDO.setPayment_method(payment_method);
        orderDO.setPayment_amount(payment_amount);
        orderDO.setUser_phone(user_phone);
        orderDO.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        orderService.addOrder(orderDO);
        return JsonResult.ok();
    }
}