package com.dongni.dongnimall.controller;

import com.alibaba.fastjson.JSONObject;
import com.dongni.dongnimall.common.MD5Util;
import com.dongni.dongnimall.common.ManagerPermissionEnum;
import com.dongni.dongnimall.manager.ManagerService;
import com.dongni.dongnimall.manager.RecInfoService;
import com.dongni.dongnimall.manager.UserService;
import com.dongni.dongnimall.pojo.ManagerDO;
import com.dongni.dongnimall.pojo.RecInfoDO;
import com.dongni.dongnimall.pojo.UserDO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.n3r.idworker.Sid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author cengshuai on 2019-09-09.
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private RecInfoService recInfoService;

    @RequestMapping("/getManagerList")
    public PageData getManagerList(Integer page, Integer limit) {
        return managerService.queryManagerList(page, limit);
    }

    @RequestMapping("/addManager")
    public JsonResult addManager(String name, String password, Integer permission) {
        if (StringUtils.isBlank(name)) {
            return JsonResult.errorMsg("用户名不能为空");
        }
        if (StringUtils.isBlank(password)) {
            return JsonResult.errorMsg("密码不能为空");
        }
        if (permission == null) {
            return JsonResult.errorMsg("权限等级不能为空");
        }
        if (!managerService.queryManagerByName(name, null)) {
            ManagerDO managerDO = new ManagerDO();
            managerDO.setId(sid.nextShort());
            managerDO.setName(name);
            managerDO.setPassword(MD5Util.getMD5(password));
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String newDate = simpleDateFormat.format(date);
            managerDO.setCreate_time(newDate);
            if (permission.equals(2)) {
                managerDO.setPermission(ManagerPermissionEnum.LEVEL2.getValue());
            } else if (permission.equals(1)) {
                managerDO.setPermission(ManagerPermissionEnum.LEVEL1.getValue());
            }
            managerService.addManager(managerDO);
            return JsonResult.ok();
        } else {
            return JsonResult.errorMsg("该用户名已使用");
        }

    }

    @RequestMapping("/modifyManager")
    public JsonResult modifyManager(String id, String name, String oldPassword, String newPassword, Integer permission) {
        if (StringUtils.isBlank(id)) {
            return JsonResult.errorMsg("修改出错");
        }
        if (StringUtils.isBlank(name)) {
            return JsonResult.errorMsg("用户名不能为空");
        }
        if (StringUtils.isBlank(oldPassword)) {
            return JsonResult.errorMsg("密码不能为空");
        }
        if (StringUtils.isBlank(newPassword)) {
            return JsonResult.errorMsg("新密码不能为空");
        }
        if (permission == null) {
            return JsonResult.errorMsg("权限等级不能为空");
        }
        if (managerService.queryManagerByName(name, id)) {
            return JsonResult.errorMsg("该用户名已使用");
        }
        if (managerService.queryManagerByNameAndPassword(name, MD5Util.getMD5(oldPassword)) != null) {
            ManagerDO managerDO = new ManagerDO();
            managerDO.setId(id);
            managerDO.setName(name);
            managerDO.setPermission(permission);
            managerDO.setPassword(MD5Util.getMD5(newPassword));
            managerService.modifyManager(managerDO);
            return JsonResult.ok();
        } else {
            return JsonResult.errorMsg("原密码错误");
        }

    }

    @RequestMapping("/removeManager")
    public JsonResult removeManager(String id) {
        if (StringUtils.isBlank(id)) {
            return JsonResult.errorMsg("删除出错");
        }
        managerService.removeManager(id);
        return JsonResult.ok();
    }

    @RequestMapping("/queryUserList")
    public PageData queryUserList(Integer page, Integer limit, @RequestParam(value = "phone", required = false) String phone, @RequestParam(value = "name", required = false) String name) {
        return userService.queryUserList(page, limit, phone, name);
    }

    @RequestMapping("/queryUserByPhone")
    public JsonResult queryUserByPhone(String phone) {
        UserDO userDO = userService.queryUserByPhone(phone);
        if (userDO == null) {
            return JsonResult.errorMsg("查询信息出错");
        }
        return JsonResult.ok(userDO);
    }

    @RequestMapping("/removeUser")
    public JsonResult removeUser(@RequestParam("phones[]") String[] phones) {
        if (phones.length == 0) {
            return JsonResult.errorMsg("删除内容为空");
        }
        userService.removeUser(Arrays.asList(phones));
        return JsonResult.ok();
    }

    @PostMapping(value = "/modifyUserInfo", produces = "application/json;charset=UTF-8")
    public JsonResult modifyUserInfo(@RequestBody UserDO userDO) {
        if (StringUtils.isBlank(userDO.getPhone())) {
            return JsonResult.errorMsg("修改错误");
        }
        userService.modifyUser(userDO);
        return JsonResult.ok();
    }

    @PostMapping(value = "/modifyUserPassword", produces = "application/json;charset=UTF-8")
    public JsonResult modifyUserPassword(String phone, String oldPassword, String newPassword) {
        if (StringUtils.isBlank(phone)) {
            return JsonResult.errorMsg("修改错误");
        } else {
            UserDO userDO = new UserDO();
            if (StringUtils.isNotBlank(oldPassword) && StringUtils.isNotBlank(newPassword)) {
                if (userService.queryUserByPhoneAndPassword(phone, MD5Util.getMD5(oldPassword)) != null) {
                    userDO.setPassword(MD5Util.getMD5(newPassword));
                } else {
                    return JsonResult.errorMsg("原密码错误");
                }
            }
            userService.modifyUser(userDO);
            return JsonResult.ok();
        }
    }

    //添加收货人信息
    @PostMapping("/addRecInfo")
    public JsonResult addRecInfo(@RequestBody RecInfoDO recInfoDO) {
        if (StringUtils.isBlank(recInfoDO.getName())) {
            return JsonResult.errorMsg("收货人昵称不能为空");
        }
        if (StringUtils.isBlank(recInfoDO.getRec_phone())) {
            return JsonResult.errorMsg("收货人手机号不能为空");
        }
        if (StringUtils.isBlank(recInfoDO.getAddress())) {
            return JsonResult.errorMsg("收货人地址不能为空");
        }
        if (StringUtils.isBlank(recInfoDO.getUser_phone())) {
            return JsonResult.errorMsg("添加出错");
        }
        recInfoService.addRecInfo(recInfoDO);
        return JsonResult.ok();
    }

    //删除收货人信息
    @PostMapping("/removeRecInfo")
    public JsonResult removeRecInfo(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        if (StringUtils.isBlank(id)) {
            return JsonResult.errorMsg("删除出错");
        }
        recInfoService.removeRecInfoById(id);
        return JsonResult.ok();
    }

    //修改收货人信息
    @PostMapping("/modifyRecInfo")
    public JsonResult modifyRecInfo(@RequestBody RecInfoDO recInfoDO) {
        if (StringUtils.isBlank(recInfoDO.getId()) || StringUtils.isBlank(recInfoDO.getUser_phone())) {
            return JsonResult.errorMsg("修改出错");
        }
        if (StringUtils.isBlank(recInfoDO.getName())) {
            return JsonResult.errorMsg("收货人昵称不能为空");
        }
        if (StringUtils.isBlank(recInfoDO.getRec_phone())) {
            return JsonResult.errorMsg("收货人手机号不能为空");
        }
        if (StringUtils.isBlank(recInfoDO.getAddress())) {
            return JsonResult.errorMsg("收货人地址不能为空");
        }
        recInfoService.modifyRecInfoById(recInfoDO);
        return JsonResult.ok();
    }

    //获取收货人信息列表
    @GetMapping("/queryRecInfo")
    public JsonResult queryRecInfo(String user_phone) {
        if(StringUtils.isBlank(user_phone)){
            return JsonResult.errorMsg("查询出错");
        }
        return JsonResult.ok(recInfoService.queryRecInfoListByUserPhone(user_phone));
    }

    @GetMapping("/queryRecInfoById")
    public JsonResult queryRecInfoById(String rec_info_id){
        return JsonResult.ok(recInfoService.queryRecInfoById(rec_info_id));
    }
}
