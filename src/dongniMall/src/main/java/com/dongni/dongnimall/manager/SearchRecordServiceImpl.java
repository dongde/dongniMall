package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.SearchRecordMapper;
import com.dongni.dongnimall.pojo.SearchRecordDO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cengshuai on 2019-11-04.
 * @version 1.0
 */
@Service
public class SearchRecordServiceImpl implements SearchRecordService {
    @Autowired
    private SearchRecordMapper searchRecordMapper;

    @Override
    public void addSearchRecord(SearchRecordDO searchRecordDO) {
        searchRecordMapper.insertSearchRecord(searchRecordDO);
    }

    @Override
    public PageData querySearchRecordList(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<SearchRecordDO> list = searchRecordMapper.selectSearchRecordList();
        PageInfo<SearchRecordDO> pageInfo = new PageInfo<>(list);

        PageData pageData = new PageData();
        pageData.setMsg("");
        pageData.setData(list);
        pageData.setCount(pageInfo.getTotal());
        pageData.setCode(0);
        return pageData;
    }
}
