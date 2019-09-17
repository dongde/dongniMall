package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.SmallImageDO;
import com.dongni.dongnimall.vo.PageData;

import java.util.List;

/**
 * @author cengshuai on 2019-09-05.
 * @version 1.0
 */

public interface SmallImageService {
    /**
     * @Description: 查询所有推荐小图
     * @param page
     * @param pageSize
     * @return
     */
    PageData querySmallImageList(Integer page, Integer pageSize);

    /**
     * @Description: 添加推荐小图
     * @param smallImageDO
     */
    void addSmallImage(SmallImageDO smallImageDO);

    /**
     * @Description: 删除推荐小图
     * @param ids
     */
    void removeSmallImage(List<String> ids);

    /**
     * @Description: 修改推荐小图使用状态
     * @param smallImageDO
     */
    void changeUsedStatus(SmallImageDO smallImageDO);
}
