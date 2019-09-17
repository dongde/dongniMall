package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.ManagerDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-09-09.
 * @version 1.0
 */
@Repository
public interface ManagerMapper {

    List<ManagerDO> selectManageList();

    void insertManager(@Param("managerDO") ManagerDO managerDO);

    List<ManagerDO> selectManagerByName(@Param("name") String name, @Param("id") String id);

    ManagerDO selectManagerByNameAndPassword(@Param("name") String name, @Param("password") String password);

    void updateManager(@Param("managerDO") ManagerDO managerDO);

    void deleteManager(String id);
}
