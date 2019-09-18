package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.BaseStore;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseTradeMapper {
    /**
     * 查询所有底料信息
     * @return
     */
    List<BaseStore> selectAllTrade();

    /**
     * 增加一个底料
     * @param baseStore
     */
    void insertTrade(@Param("baseStore") BaseStore baseStore);

    /**
     * 修改货物信息
     * @param baseStore
     */
    void updateTrade(BaseStore baseStore);

    /**
     * 删除一个底料信息
     * @param id
     */
    void deleteTrade(@Param("id") Integer id);


}
