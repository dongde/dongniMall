package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.BannerDO;
import com.dongni.dongnimall.vo.PageData;

import java.util.List;

/**
 * @author cengshuai on 2019-09-05.
 * @version 1.0
 */

public interface BannerService {
    /**
     * @Description: 查询所有轮播图
     * @param page
     * @param pageSize
     * @return
     */
    PageData queryBannerList(Integer page, Integer pageSize);

    /**
     * @Description: 查询展示的轮播图
     * @return
     */
    List<BannerDO> queryBannerIsUsedList();

    /**
     * @Description: 查询已使用的轮播图数量
     * @return
     */
    Integer queryBannerUsedCount();

    /**
     * @Description: 添加轮播图
     * @param bannerDO
     */
    void addBanner(BannerDO bannerDO);

    /**
     * @Description: 删除轮播图
     * @param ids
     */
    void removeBanner(List<String> ids);

    /**
     * @Description: 修改轮播图使用状态
     * @param bannerDO
     */
    void modifyBanner(BannerDO bannerDO);
}
