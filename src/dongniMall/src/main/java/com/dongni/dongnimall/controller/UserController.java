package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.common.MD5Util;
import com.dongni.dongnimall.common.ManagerPermissionEnum;
import com.dongni.dongnimall.manager.ManagerService;
import com.dongni.dongnimall.manager.UserService;
import com.dongni.dongnimall.pojo.ManagerDO;
import com.dongni.dongnimall.pojo.UserDO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.apache.catalina.User;
import org.n3r.idworker.Sid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @RequestMapping("/addUser")
    public JsonResult addUser(String phone, String name, String gender, String address, String email, String postal_code, String password) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(name) || StringUtils.isBlank(address) || StringUtils.isBlank(email) || StringUtils.isBlank(postal_code) || StringUtils.isBlank(password) || StringUtils.isBlank(gender)) {
            return JsonResult.errorMsg("用户信息不能有空值！");
        }
        UserDO userDO = new UserDO();
        userDO.setPhone(phone);
        userDO.setName(name);
        if (gender.equals("男")) {
            userDO.setGender(0);
        } else if (gender.equals("女")) {
            userDO.setGender(1);
        }
        userDO.setAddress(address);
        userDO.setEmail(email);
        userDO.setPostal_code(postal_code);
        userDO.setPassword(MD5Util.getMD5(password));
        userService.addUser(userDO);
        return JsonResult.ok();
    }

    @RequestMapping("/queryUserList")
    public PageData queryUserList(Integer page, Integer limit) {
        return userService.queryUserList(page, limit);
    }

    @RequestMapping("/queryUserByPhone")
    public JsonResult queryUserByPhone(String phone) {
        UserDO userDO = userService.queryUserByPhone(phone);
        System.out.println(userDO);
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

    @RequestMapping("/modifyUser")
    public JsonResult modifyUser(String phone, String oldPassword, String newPassword, String name, String gender, String email, String address, String postal_code) {
        if (StringUtils.isBlank(phone)) {
            return JsonResult.errorMsg("修改错误");
        } else {
            UserDO userDO = new UserDO();
            userDO.setPhone(phone);
            userDO.setName(name);
            if (StringUtils.isNotBlank(gender)) {
                if (gender.equals("男")) {
                    userDO.setGender(0);
                } else if (gender.equals("女")) {
                    userDO.setGender(1);
                }
            }
            userDO.setAddress(address);
            userDO.setEmail(email);
            userDO.setPostal_code(postal_code);
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
}
