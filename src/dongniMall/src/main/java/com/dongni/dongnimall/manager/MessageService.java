package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.MessageDO;
import com.dongni.dongnimall.vo.PageData;

import java.util.List;

/**
 * @author cengshuai on 2019-09-25.
 * @version 1.0
 */
public interface MessageService {

    /**
     * @param user_phone
     * @param type
     * @return
     * @Description: 查询所有消息列表
     */
    PageData queryMessageList(Integer page, Integer pageSize, String user_phone, Integer type);

    /**
     * @param user_phone
     * @return
     * @Description: 查询用户消息列表
     */
    PageData queryMessageListByUser(Integer page, Integer pageSize, String user_phone);

    /**
     * @param messageDO
     * @Description: 添加消息信息
     */
    void addMessage(MessageDO messageDO);

    /**
     * @param ids
     * @Description: 删除消息
     */
    void removeMessage(List<String> ids);
}
