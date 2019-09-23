package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.ActicleDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {

    /**
     * 查询全部信息
     * @return
     */
    @Select("select * from newsinformation")
    List<ActicleDO> selectAll();

    /**
     * 插入文章信息
     * @param acticleDO
     */
    @Insert("insert into newsinformation (id,title,source,imageUrl,summary,content,updateTime) " +
            "values(#{acticleDO.id},#{acticleDO.title},#{acticleDO.source},#{acticleDO.imageURL},#{acticleDO.summary},#{acticleDO.content},#{acticleDO.updateTime})")
    void insertObject(@Param("acticleDO") ActicleDO acticleDO);

    /**
     * 通过id查找文章信息
     * @param id
     * @return
     */
    @Select("select * from newsinformation where id = #{id}")
    ActicleDO findByID(@Param("id") String id);


    /**
     * 通过标题查找文章
     * @param title
     * @return
     */
    @Select("select * from newsinformation where title = #{title}")
    ActicleDO findByTitle(@Param("title") String title);

    /**
     * 通过id删除数据
     * @param id
     */
    @Delete("delete from newsinformation where id = #{id}")
    void deleteNewsByID(@Param("id") String id);

    /**
     * 更新文章信息
     * @param acticleDO
     * @param id
     */
    @Update("update acticleDO set title=#{acticleDO.title}" +
            ",source=#{acticleDO.source}" +
            ",summary=#{acticleDO.summary}" +
            ",content=#{acticleDO.content}" +
            ",imageUrl=#{acticleDO.imageURL}"+
            ",updateTime=#{acticleDO.updateTime} where id = #{id}")
    void updateNews(@Param("acticleDO") ActicleDO acticleDO, @Param("id") String id);

    /**
     * 通过标题和来源查询数据
     * @param title
     * @param source
     * @return
     */
    @Select("select * from newsinformation where title=#{title} and source=#{source}")
    List<ActicleDO> findByTitleAndSource(@Param("title") String title, @Param("source") String source);

    /**
     * 通过来源查找
     * @param source
     * @return
     */
    @Select("select * from newsinformation where source = #{source}")
    List<ActicleDO> queryBySource(@Param("source") String source);

    /**
     * 通过标题查找
     * @param title
     * @return
     */
    @Select("select * from newsinformation where title=#{title}")
    List<ActicleDO> queryByTitle(@Param("title") String title);
}
