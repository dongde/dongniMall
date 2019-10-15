package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.LeaveMessageDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-09-16.
 * @version 1.0
 */
@Repository
public interface LeaveMessageMapper {
    void insertLeaveMessage(@Param("leaveMessageDO") LeaveMessageDO leaveMessageDO);

    List<LeaveMessageDO> selectLeaveMessageList(@Param("recipient_id") String recipient_id);

    void deleteById(String id);

    void updateLeaveMessage(@Param("id") String id, @Param("verify") Integer verify);
}
