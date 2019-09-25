package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.MessageMapper;
import com.dongni.dongnimall.pojo.MessageDO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cengshuai on 2019-09-25.
 * @version 1.0
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public PageData queryMessageList(Integer page, Integer pageSize, String user_phone, Integer type) {
        PageHelper.startPage(page, pageSize);
        List<MessageDO> list = messageMapper.selectMessageList(user_phone, type);

        PageInfo<MessageDO> pageInfo = new PageInfo<>(list);

        PageData pageData = new PageData();
        pageData.setMsg("");
        pageData.setData(list);
        pageData.setCount(pageInfo.getTotal());
        pageData.setCode(0);
        return pageData;
    }

    @Override
    public PageData queryMessageListByUser(Integer page, Integer pageSize, String user_phone) {
        PageHelper.startPage(page, pageSize);
        List<MessageDO> list = messageMapper.selectMessageListByUser(user_phone);

        PageInfo<MessageDO> pageInfo = new PageInfo<>(list);

        PageData pageData = new PageData();
        pageData.setMsg("");
        pageData.setData(list);
        pageData.setCount(pageInfo.getTotal());
        pageData.setCode(0);
        return pageData;
    }

    @Override
    public void addMessage(MessageDO messageDO) {
        messageMapper.insertMessage(messageDO);
    }

    @Override
    public void removeMessage(List<String> ids) {
        messageMapper.deleteMessage(ids);
    }
}
