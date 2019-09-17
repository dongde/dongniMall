package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.BannerDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-09-05.
 * @version 1.0
 */

@Repository
public interface BannerMapper {
    List<BannerDO> selectBannerList();

    void insertBanner(@Param("bannerDO") BannerDO bannerDO);

    void deleteBanner(List<String> ids);

    void updateBanner(@Param("bannerDO") BannerDO bannerDO);
}
