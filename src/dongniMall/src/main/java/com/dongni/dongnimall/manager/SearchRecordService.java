package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.SearchRecordDO;
import com.dongni.dongnimall.vo.PageData;

import java.util.List;

/**
 * @author cengshuai on 2019-11-04.
 * @version 1.0
 */
public interface SearchRecordService {
    /**
     * 添加搜索记录
     * @param searchRecordDO
     */
    void addSearchRecord(SearchRecordDO searchRecordDO);

    /**
     * 查询热搜词汇
     * @param page
     * @param pageSize
     * @return
     */
    PageData querySearchRecordList(Integer page,Integer pageSize);
}
