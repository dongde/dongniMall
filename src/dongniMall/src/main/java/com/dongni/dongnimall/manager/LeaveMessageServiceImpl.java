package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.LeaveMessageMapper;
import com.dongni.dongnimall.pojo.LeaveMessageDO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author cengshuai on 2019-09-16.
 * @version 1.0
 */
@Service
public class LeaveMessageServiceImpl implements LeaveMessageService {
    @Autowired
    private LeaveMessageMapper leaveMessageMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addLeaveMessage(LeaveMessageDO leaveMessageDO) {
        leaveMessageMapper.insertLeaveMessage(leaveMessageDO);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PageData queryLeaveMessageList(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<LeaveMessageDO> list = leaveMessageMapper.selectLeaveMessageList();

        PageInfo<LeaveMessageDO> pageInfo = new PageInfo<>(list);

        PageData pageData = new PageData();
        pageData.setCount(pageInfo.getTotal());
        pageData.setCode(0);
        pageData.setData(list);
        pageData.setMsg("");
        return pageData;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PageData queryLeaveMessageListByRecipientId(String recipient_id, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<LeaveMessageDO> list = leaveMessageMapper.selectLeaveMessageListByRecipientId(recipient_id);

        PageInfo<LeaveMessageDO> pageInfo = new PageInfo<>(list);

        PageData pageData = new PageData();
        pageData.setCount(pageInfo.getTotal());
        pageData.setCode(0);
        pageData.setData(list);
        pageData.setMsg("");
        return pageData;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void removeLeaveMessage(String id) {
        leaveMessageMapper.deleteById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void modifyVerify(String id, Integer verify) {
        leaveMessageMapper.updateLeaveMessage(id, verify);
    }
}
