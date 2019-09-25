package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.manager.MessageService;
import com.dongni.dongnimall.manager.UserService;
import com.dongni.dongnimall.pojo.MessageDO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * @author cengshuai on 2019-09-25.
 * @version 1.0
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    @Autowired
    private Sid sid;

    @GetMapping("/queryMessageList")
    public PageData queryMessageList(Integer page, Integer limit, @RequestParam(value = "user_phone", required = false) String user_phone, @RequestParam(value = "type", required = false) Integer type) {
        return messageService.queryMessageList(page, limit, user_phone, type);
    }

    @GetMapping("/queryMessageListByUser")
    public PageData queryMessageListByUser(Integer page, Integer limit, String user_phone) {
        return messageService.queryMessageListByUser(page, limit, user_phone);
    }

    @PostMapping("/addMessage")
    public JsonResult addMessage(Integer type,String user_phone,String content){
        if(type==null||StringUtils.isBlank(content)){
            return JsonResult.errorMsg("添加错误");
        }
        if(type==1){
            if(StringUtils.isBlank(user_phone)){
                return JsonResult.errorMsg("添加错误");
            }
            if(userService.queryUserByPhone(user_phone)==null){
                return JsonResult.errorMsg("用户不存在");
            }
        }
        MessageDO messageDO = new MessageDO();
        messageDO.setId(sid.nextShort());
        messageDO.setUser_phone(user_phone);
        messageDO.setContent(content);
        messageDO.setType(type);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String create_time = simpleDateFormat.format(date);
        messageDO.setCreate_time(create_time);
        messageService.addMessage(messageDO);
        return JsonResult.ok();
    }

    @PostMapping("/removeMessage")
    public JsonResult removeMessage(@RequestParam(value = "ids[]") String[] ids){
        messageService.removeMessage(Arrays.asList(ids));
        return JsonResult.ok();
    }
}
