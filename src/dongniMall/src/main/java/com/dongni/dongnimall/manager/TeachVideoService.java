package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.TeachVideoDO;
import com.dongni.dongnimall.vo.PageData;

/**
 * @author cengshuai on 2019-09-11.
 * @version 1.0
 */

public interface TeachVideoService {
    /**
     * @param page
     * @param pageSize
     * @param title
     * @return
     * @Description: 查询所有教学视频
     */
    PageData queryTeachVideoList(Integer page, Integer pageSize, String title);

    /**
     * @Description: 删除教学视频
     * @param id
     */
    void removeTeachVideo(String id);

    /**
     * @Description: 添加教学视频
     * @param teachVideoDO
     */
    void addTeachVideo(TeachVideoDO teachVideoDO);

    /**
     * @Description: 更新教学视频
     * @param teachVideoDO
     */
    void modifyTeachVideo(TeachVideoDO teachVideoDO);
}
