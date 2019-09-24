package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.LeaveMessageDO;
import com.dongni.dongnimall.vo.PageData;

/**
 * @author cengshuai on 2019-09-16.
 * @version 1.0
 */
public interface LeaveMessageService {
    /**
     * @param leaveMessageDO
     * @Description: 添加留言
     */
    void addLeaveMessage(LeaveMessageDO leaveMessageDO);

    /**
     * @Description: 获取留言列表
     * @param recipient_id
     * @param page
     * @param pageSize
     * @return
     */
    PageData queryLeaveMessageList(String recipient_id,Integer page, Integer pageSize);

    /**
     * @param id
     * @Description: 删除留言
     */
    void removeLeaveMessage(String id);

    /**
     * @param id
     * @param verify
     * @Description: 修改审核状态
     */
    void modifyVerify(String id, Integer verify);
}
