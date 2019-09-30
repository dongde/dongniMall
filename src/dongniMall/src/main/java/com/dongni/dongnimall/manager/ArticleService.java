package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.ActicleDO;
import com.dongni.dongnimall.vo.PageData;

import java.util.List;

public interface ArticleService {
    /**
     * 查询所有信息
     * @param page
     * @return
     */
    PageData selectAll(Integer page, Integer limit, String title, String source);
    List<ActicleDO> selectAll();

    /**
     * 插入文章
     * @param acticleDO
     */
    void insertArticle(ActicleDO acticleDO);

    /**
     * 通过id查找文章
     * @param id
     * @return
     */
    ActicleDO findByID(String id);

    /**
     * 删除文章信息
     * @param id
     */
    void deleteArticle(String id);

    /**
     * 修改文章
     */
    void updateArticle(ActicleDO acticleDO, String id);
}
