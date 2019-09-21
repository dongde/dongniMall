package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.ActicleDO;
import com.dongni.dongnimall.vo.PageData;

public interface ArticleService {

    /**
     * 查询所有信息
     * @param page
     * @return
     */
    PageData selectAll(Integer page, Integer limit, String title, String source);

    /**
     * 插入文章
     * @param acticleDO
     */
    void insertObject(ActicleDO acticleDO);

    /**
     * 通过id查找文章
     * @param id
     * @return
     */
    ActicleDO findByID(String id);


    /**
     * 通过标题查找文章
     * @param title
     * @return
     */
    ActicleDO findByTitle(String title);

    /**
     * 删除文章信息
     * @param id
     */
    void deleteNews(String id);
    /**
     * 修改文章
     */
    void updateNews(ActicleDO acticleDO, String id);

}
