package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.common.MD5Util;
import com.dongni.dongnimall.common.ManagerPermissionEnum;
import com.dongni.dongnimall.manager.ManagerService;
import com.dongni.dongnimall.pojo.ManagerDO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.n3r.idworker.Sid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cengshuai on 2019-09-09.
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

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
        if(!managerService.queryManagerByName(name,null)) {
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
        }else{
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
        if(managerService.queryManagerByName(name,id)) {
            return JsonResult.errorMsg("该用户名已使用");
        }
        if(managerService.queryManagerByNameAndPassword(name,MD5Util.getMD5(oldPassword))!=null){
            ManagerDO managerDO = new ManagerDO();
            managerDO.setId(id);
            managerDO.setName(name);
            managerDO.setPermission(permission);
            managerDO.setPassword(MD5Util.getMD5(newPassword));
            managerService.modifyManager(managerDO);
            return JsonResult.ok();
        }else{
            return JsonResult.errorMsg("原密码错误");
        }

    }

    @RequestMapping("/removeManager")
    public JsonResult removeManager(String id){
        if (StringUtils.isBlank(id)){
            return JsonResult.errorMsg("删除出错");
        }
        managerService.removeManager(id);
        return JsonResult.ok();
    }
}
