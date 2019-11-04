package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.SearchRecordDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-11-04.
 * @version 1.0
 */
@Repository
public interface SearchRecordMapper {
    void insertSearchRecord(@Param("hotSearchDO") SearchRecordDO searchRecordDO);

    List<SearchRecordDO> selectSearchRecordList();
}
