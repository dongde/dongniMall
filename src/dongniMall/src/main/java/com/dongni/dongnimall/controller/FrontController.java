package com.dongni.dongnimall.controller;

import com.alibaba.fastjson.JSONObject;
import com.dongni.dongnimall.base.sms.SMSManager;
import com.dongni.dongnimall.common.MD5Util;
import com.dongni.dongnimall.manager.UserService;
import com.dongni.dongnimall.pojo.UserDO;
import com.dongni.dongnimall.vo.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cengshuai on 2019-09-24.
 * @version 1.0
 */
@RestController
@RequestMapping("/front")
public class FrontController {
    @Autowired
    private UserService userService;
    @Autowired
    private SMSManager smsManager;

    @PostMapping(value = "/sendSmsRegisterCode", produces = "application/json;charset=UTF-8")
    public JsonResult sendSmsRegisterCode(@RequestBody JSONObject jsonObject) {
        String phone = jsonObject.get("phone").toString();
        smsManager.sendSmsRegisterCode(phone);
        return JsonResult.ok();
    }

    @PostMapping(value = "/register", produces = "application/json;charset=UTF-8")
    public JsonResult register(@RequestBody JSONObject jsonObject) {
        String phone = jsonObject.get("phone").toString();
        String password = jsonObject.get("password").toString();
        String code = jsonObject.get("code").toString();
        if (StringUtils.isBlank(phone)) {
            return JsonResult.errorMsg("手机号不能为空");
        }
        if (userService.queryUserByPhone(phone) != null) {
            return JsonResult.errorMsg("该手机号已被注册");
        }
        if (!smsManager.validateRegisterCode(phone, code)) {
            return JsonResult.errorMsg("验证码错误");
        }
        UserDO userDO = new UserDO();
        userDO.setPhone(phone);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userDO.setCreate_time(simpleDateFormat.format(date));
        userDO.setPassword(MD5Util.getMD5(password));
        userService.addUser(userDO);
        return JsonResult.ok();
    }

    @PostMapping("/login")
    public JsonResult login(String phone, String password) {
        if (StringUtils.isBlank(phone)) {
            return JsonResult.errorMsg("手机号不能为空");
        }
        if (StringUtils.isBlank(password)) {
            return JsonResult.errorMsg("密码不能为空");
        }
        UserDO userDO = userService.queryUserByPhoneAndPassword(phone, MD5Util.getMD5(password));
        if (userDO != null) {
            return JsonResult.ok(userDO);
        } else {
            return JsonResult.errorMsg("用户不存在");
        }
    }
}
