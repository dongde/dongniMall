package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.NewsInformation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsInformationDAO {

    /**
     * 查询全部信息
     * @return
     */
    @Select("select * from newsinformation")
    List<NewsInformation> selectAll();

    /**
     * 插入文章信息
     * @param newsInformation
     */
    @Insert("insert into newsinformation (title,source,imageUrl,summary,content,updateTime) " +
            "values(#{newsInformation.title},#{newsInformation.source},#{newsInformation.imageURL},#{newsInformation.summary},#{newsInformation.content},#{newsInformation.updateTime})")
    void insertObject(@Param("newsInformation") NewsInformation newsInformation);

    /**
     * 通过id查找文章信息
     * @param id
     * @return
     */
    @Select("select * from newsinformation where id = #{id}")
    NewsInformation findByID(@Param("id") Integer id);


    /**
     * 通过标题查找文章
     * @param title
     * @return
     */
    @Select("select * from newsinformation where title = #{title}")
    NewsInformation findByTitle(@Param("title") String title);

    /**
     * 通过id删除数据
     * @param id
     */
    @Delete("delete from newsinformation where id = #{id}")
    void deleteNewsByID(@Param("id") Integer id);

    /**
     * 更新文章信息
     * @param newsInformation
     * @param id
     */
    @Update("update newsInformation set title=#{newsInformation.title}" +
            ",source=#{newsInformation.source}" +
            ",summary=#{newsInformation.summary}" +
            ",content=#{newsInformation.content}" +
            ",imageUrl=#{newsInformation.imageURL}"+
            ",updateTime=#{newsInformation.updateTime} where id = #{id}")
    void updateNews(@Param("newsInformation") NewsInformation newsInformation, @Param("id") Integer id);

    /**
     * 通过标题和来源查询数据
     * @param title
     * @param source
     * @return
     */
    @Select("select * from newsinformation where title=#{title} and source=#{source}")
    NewsInformation findByTitleAndSource(@Param("title") String title, @Param("source") String source);

    /**
     * 通过来源查找
     * @param source
     * @return
     */
    @Select("select * from newsinformation where source = #{source}")
    List<NewsInformation> queryBySource(@Param("source") String source);

    /**
     * 通过标题查找
     * @param title
     * @return
     */
    @Select("select * from newsinformation where title=#{title}")
    List<NewsInformation> queryByTitle(@Param("title") String title);
}
