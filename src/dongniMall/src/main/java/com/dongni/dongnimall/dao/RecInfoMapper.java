package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.RecInfoDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-11-02.
 * @version 1.0
 */
@Repository
public interface RecInfoMapper {
    void insertRecInfo(@Param("recInfoDO") RecInfoDO recInfoDO);

    List<RecInfoDO> selectRecInfoListByUserPhone(String user_phone);

    RecInfoDO selectRecInfoById(String id);

    void deleteRecInfoById(String id);

    void updateRecInfoById(@Param("recInfoDO") RecInfoDO recInfoDO);

    void updateRecInfoToNoDefault();
}
