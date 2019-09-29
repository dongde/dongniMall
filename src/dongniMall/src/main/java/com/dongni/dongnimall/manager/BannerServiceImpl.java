package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.BannerMapper;
import com.dongni.dongnimall.pojo.BannerDO;
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
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PageData queryBannerList(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<BannerDO> list = bannerMapper.selectBannerList();

        PageInfo<BannerDO> pageInfo = new PageInfo<>(list);

        PageData pageData = new PageData();
        pageData.setCode(0);
        pageData.setCount(pageInfo.getTotal());
        pageData.setMsg("");
        pageData.setData(list);
        return pageData;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<BannerDO> queryBannerIsUsedList() {
        return bannerMapper.selectBannerIsUsedList();
    }

    @Override
    public Integer queryBannerUsedCount() {
        return bannerMapper.selectBannerUsedCount();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addBanner(BannerDO bannerDO) {
        bannerMapper.insertBanner(bannerDO);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void removeBanner(List<String> ids) {
        bannerMapper.deleteBanner(ids);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void modifyBanner(BannerDO bannerDO) {
        bannerMapper.updateBanner(bannerDO);
    }
}
