package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.NewsInformation;
import com.dongni.dongnimall.vo.PageData;

public interface NewsService {

    /**
     * 查询所有信息
     * @param page
     * @return
     */
    PageData selectAll(Integer page, Integer limit, String title, String source);

    /**
     * 插入文章
     * @param newsInformation
     */
    void insertObject(NewsInformation newsInformation);

    /**
     * 通过id查找文章
     * @param id
     * @return
     */
    NewsInformation findByID(Integer id);


    /**
     * 通过标题查找文章
     * @param title
     * @return
     */
    NewsInformation findByTitle(String title);

    /**
     * 删除文章信息
     * @param id
     */
    void deleteNews(Integer id);
    /**
     * 修改文章
     */
    void updateNews(NewsInformation newsInformation, Integer id);

}
