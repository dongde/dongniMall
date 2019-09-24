package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.BaseTradeTypeDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseTradeTypeMapper {

    /**
     * 查询所有类型
     */
    @Select("select * from tradeType")
    List<BaseTradeTypeDO> selectAllType();

    /**
     * 插入类型
     */
    @Insert("insert into tradeType (id,type,updateTime) values(#{baseTradeTypeDO.id},#{baseTradeTypeDO.type},#{baseTradeTypeDO.updateTime})")
    void insertType(@Param("baseTradeTypeDO") BaseTradeTypeDO baseTradeTypeDO);

    /**
     * 删除类型数据
     * @param id
     */
    @Delete("delete from tradeType where id = #{id}")
    void deleteType(@Param("id") String id);
}
