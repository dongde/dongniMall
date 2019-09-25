package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.MessageDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-09-25.
 * @version 1.0
 */
@Repository
public interface MessageMapper {
    List<MessageDO> selectMessageList(@Param("user_phone") String user_phone, @Param("type") Integer type);

    List<MessageDO> selectMessageListByUser(String user_phone);

    void insertMessage(@Param("messageDO") MessageDO messageDO);

    void deleteMessage(List<String> ids);
}
