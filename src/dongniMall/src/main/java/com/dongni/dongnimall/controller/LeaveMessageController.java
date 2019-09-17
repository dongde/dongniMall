package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.manager.LeaveMessageService;
import com.dongni.dongnimall.pojo.LeaveMessageDO;
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
 * @author cengshuai on 2019-09-16.
 * @version 1.0
 */

@RestController
@RequestMapping("/leaveMessage")
public class LeaveMessageController {
    @Autowired
    private Sid sid;
    @Autowired
    private LeaveMessageService leaveMessageService;

    @RequestMapping("/addLeaveMessage")
    public JsonResult addLeaveMessage(String content, String user_id, String recipient_id) {
        if (StringUtils.isBlank(user_id) || StringUtils.isBlank(recipient_id)) {
            return JsonResult.errorMsg("留言出错");
        }
        if (StringUtils.isBlank(content)) {
            return JsonResult.errorMsg("留言内容为空");
        }
        LeaveMessageDO leaveMessageDO = new LeaveMessageDO();
        leaveMessageDO.setId(sid.nextShort());
        leaveMessageDO.setContent(content);
        leaveMessageDO.setUser_id(user_id);
        leaveMessageDO.setRecipient_id(recipient_id);
        leaveMessageDO.setVerify(0);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newDate = simpleDateFormat.format(date);
        leaveMessageDO.setCreate_time(newDate);
        leaveMessageService.addLeaveMessage(leaveMessageDO);
        return JsonResult.ok();
    }

    @RequestMapping("/queryLeaveMessageList")
    public PageData queryLeaveMessageList(Integer page, Integer limit) {
        return leaveMessageService.queryLeaveMessageList(page, limit);
    }

    @RequestMapping("/queryLeaveMessageListByRecipientId")
    public PageData queryLeaveMessageListByRecipientId(String recipient_id, Integer page, Integer limit) {
        return leaveMessageService.queryLeaveMessageListByRecipientId(recipient_id, page, limit);
    }

    @RequestMapping("/removeLeaveMessage")
    public JsonResult removeLeaveMessage(String id) {
        if (StringUtils.isBlank(id)) {
            return JsonResult.errorMsg("删除出错");
        }
        leaveMessageService.removeLeaveMessage(id);
        return JsonResult.ok();
    }

    @RequestMapping("/modifyVerify")
    public JsonResult modifyVerify(String id, Integer verify) {
        System.out.println(id+":"+verify);
        if (StringUtils.isBlank(id) || verify == null) {
            return JsonResult.errorMsg("审核出错");
        }
        leaveMessageService.modifyVerify(id, verify);
        return JsonResult.ok();
    }
}
