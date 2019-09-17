package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.SmallImageDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-09-05.
 * @version 1.0
 */

@Repository
public interface SmallImageMapper {
    List<SmallImageDO> selectSmallImageList();

    void insertSmallImage(@Param("smallImageDO") SmallImageDO smallImageDO);

    void deleteSmallImage(List<String> ids);

    void updateSmallImage(@Param("smallImageDO") SmallImageDO smallImageDO);
}
