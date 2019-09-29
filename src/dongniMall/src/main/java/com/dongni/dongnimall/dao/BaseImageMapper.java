package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.BaseImageDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 底料图片
 */
@Repository
public interface BaseImageMapper {

    @Select("select * from imageurl_save where basestoreID = #{id}")
    List<BaseImageDO> findByID(@Param("id") String id);

    @Insert("insert into imageurl_save (id,image_url) values (#{baseImageDO.id},#{baseImageDO.imageURL})")
    void insert(@Param("baseImageDO") BaseImageDO baseImageDO);

    @Select("select * from imageurl_save where image_url=#{url}")
    BaseImageDO findByurl(@Param("url") String url);

    @Select("select * from imageurl_save where id = #{imageId}")
    BaseImageDO finbyID(@Param("imageId") String imageId);

    @Update("update imageurl_save set basestoreID = #{baseImageDO.baseStoreId} where id = #{baseImageDO.id}")
    void updateMessage(@Param("baseImageDO") BaseImageDO baseImageDO);
}
