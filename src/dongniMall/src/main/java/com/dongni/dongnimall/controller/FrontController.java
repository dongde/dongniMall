package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.base.sms.SMSManager;
import com.dongni.dongnimall.common.MD5Util;
import com.dongni.dongnimall.manager.UserService;
import com.dongni.dongnimall.pojo.UserDO;
import com.dongni.dongnimall.vo.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/sendSmsRegisterCode")
    public JsonResult sendSmsRegisterCode(String phone){
        smsManager.sendSmsRegisterCode(phone);
        return JsonResult.ok();
    }

    @PostMapping("/register")
    public JsonResult register(String phone, String name, Integer gender, String address, String email, String postal_code, String password,String code) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(name) || StringUtils.isBlank(address) || StringUtils.isBlank(email) || StringUtils.isBlank(postal_code) || StringUtils.isBlank(password) || gender == null) {
            return JsonResult.errorMsg("用户信息不能为空");
        }
        if(userService.queryUserByPhone(phone)!=null){
            return JsonResult.errorMsg("该手机号已被注册");
        }
        if(!smsManager.validateRegisterCode(phone,code)){
            return JsonResult.errorMsg("验证码错误");
        }
        UserDO userDO = new UserDO();
        userDO.setPhone(phone);
        userDO.setName(name);
        userDO.setGender(gender);
        userDO.setAddress(address);
        userDO.setEmail(email);
        userDO.setPostal_code(postal_code);
        userDO.setPassword(MD5Util.getMD5(password));
        userService.addUser(userDO);
        return JsonResult.ok();
    }

    @PostMapping("/login")
    public JsonResult login(String phone,String password){
        if(StringUtils.isBlank(phone)){
            return JsonResult.errorMsg("手机号不能为空");
        }
        if(StringUtils.isBlank(password)){
            return JsonResult.errorMsg("密码不能为空");
        }
        UserDO userDO = userService.queryUserByPhoneAndPassword(phone,MD5Util.getMD5(password));
        if(userDO!=null){
            return JsonResult.ok(userDO);
        }else{
            return JsonResult.errorMsg("用户不存在");
        }
    }
}
