package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.common.MD5Util;
import com.dongni.dongnimall.common.VerifyCode;
import com.dongni.dongnimall.manager.ManagerService;
import com.dongni.dongnimall.pojo.CodeDO;
import com.dongni.dongnimall.pojo.ManagerDO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.ManagerVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author cengshuai on 2019-09-10.
 * @version 1.0
 */

@RestController
public class LoginController extends BaseController{

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/login")
    public JsonResult login(String name, String password, HttpServletRequest request){
        if(StringUtils.isBlank(name)){
            return JsonResult.errorMsg("用户名不能为空");
        }
        if (StringUtils.isBlank(password)){
            return JsonResult.errorMsg("密码不能为空");
        }
        if(!managerService.queryManagerByName(name,null)){
            return JsonResult.errorMsg("用户不存在");
        }
        ManagerDO managerDO = managerService.queryManagerByNameAndPassword(name, MD5Util.getMD5(password));
        if(managerDO!=null){
            ManagerVO managerVO = new ManagerVO();
            BeanUtils.copyProperties(managerDO,managerVO);
            String token = UUID.randomUUID().toString();
            managerVO.setToken(token);
            request.getSession().setAttribute("token",token);
            return JsonResult.ok(managerDO);
        }else{
            return JsonResult.errorMsg("密码错误");
        }
    }

    @RequestMapping("/getCode")
    public CodeDO getCode(){
        CodeDO codeDO = new CodeDO();
        codeDO.setCode(VerifyCode.getImage(CODE_IMAGE_PATH));
        codeDO.setCodeUrl("/code.jpg");
        return codeDO;
    }
}
