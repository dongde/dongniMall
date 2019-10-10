package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.BaseStoreDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseTradeMapper {
    /**
     * 查询所有底料信息
     * @return
     * @param tradeName
     * @param tradeType
     */
    List<BaseStoreDO> selectAllTrade(@Param("tradeName") String tradeName, @Param("tradeType") String tradeType);

    /**
     * 增加一个底料
     * @param baseStoreDO
     */
    void insertTrade(@Param("baseStoreDO") BaseStoreDO baseStoreDO);

    /**
     * 修改货物信息
     * @param baseStoreDO
     */
    void updateTrade(@Param("baseStoreDO") BaseStoreDO baseStoreDO);

    /**
     * 删除一个底料信息
     * @param id
     */
    void deleteTrade(@Param("id") String id);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    BaseStoreDO selectByID(@Param("id") String id);

    /**
     * 更新浏览次数
     * @param newViewCount
     * @param id
     */
    void updateViewCount(@Param("newViewCount") Integer newViewCount, @Param("id") String id);
}
