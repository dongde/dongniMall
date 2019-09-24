package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.SmallImageMapper;
import com.dongni.dongnimall.pojo.SmallImageDO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author cengshuai on 2019-09-05.
 * @version 1.0
 */
@Service
public class SmallImageServiceImpl implements SmallImageService {
    @Autowired
    private SmallImageMapper smallImageMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PageData querySmallImageList(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<SmallImageDO> list = smallImageMapper.selectSmallImageList();

        PageInfo<SmallImageDO> pageInfo = new PageInfo<>(list);

        PageData pageData = new PageData();
        pageData.setCode(0);
        pageData.setCount(pageInfo.getTotal());
        pageData.setMsg("");
        pageData.setData(list);
        return pageData;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<SmallImageDO> querySmallImageShowList() {
        return smallImageMapper.selectSmallImageIsUsedList();
    }

    @Override
    public Integer querySmallImageUsedCount() {
        return smallImageMapper.selectSmallImageUsedCount();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addSmallImage(SmallImageDO smallImageDO) {
        smallImageMapper.insertSmallImage(smallImageDO);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void removeSmallImage(List<String> ids) {
        smallImageMapper.deleteSmallImage(ids);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void modifySmallImage(SmallImageDO smallImageDO) {
        smallImageMapper.updateSmallImage(smallImageDO);
    }
}
