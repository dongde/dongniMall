package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.TeachVideoDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-09-11.
 * @version 1.0
 */
@Repository
public interface TeachVideoMapper {
    List<TeachVideoDO> selectTeachVideoList(@Param("title") String title);

    void deleteTeachVideo(String id);

    void insertTeachVideo(@Param("teachVideoDO") TeachVideoDO teachVideoDO);

    void updateTeachVideo(@Param("teachVideoDO") TeachVideoDO teachVideoDO);
}
