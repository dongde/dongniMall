package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.pojo.PublicityTemplate;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicityTemplateDAO {

    /**
     * 查询表的全部信息
     * @return
     */
    @Select("select * from publicityTemplate")
    List<PublicityTemplate> selectAll();

    /**
     * 通过类型查找
     * @param templateType
     * @return
     */
    @Select("select * from publicityTemplate where templateType = #{templateType}")
    List<PublicityTemplate> queryByType(@Param("templateType") String templateType);

    /**
     * 通过名字查找
     * @param templateName
     * @return
     */
    @Select("select * from publicityTemplate where templateName = #{templateName}")
    List<PublicityTemplate> queryByName(@Param("templateName") String templateName);

    /**
     * 通过名字和类型查找
     * @param templateName
     * @param templateType
     * @return
     */
    @Select("select * from publicityTemplate where templateName = #{templateName} and templateType = #{templateType}")
    PublicityTemplate findByNameAndType(@Param("templateName") String templateName, @Param("templateType") String templateType);

    /**
     * 插入数据到数据库
     * @param publicityTemplate
     */
    @Insert("insert into publicityTemplate (templateName,templateType,textDescription,image,price,updateTime) values" +
            "(#{publicityTemplate.templateName},#{publicityTemplate.templateType}," +
            "#{publicityTemplate.textDescription},#{publicityTemplate.image}," +
            "#{publicityTemplate.price},#{publicityTemplate.updateTime})")
    void insertTemplate(@Param("publicityTemplate") PublicityTemplate publicityTemplate);

    /**
     * 通过id删除数据
     * @param id
     */
    @Delete("delete from publicityTemplate where id = #{id}")
    void deleteByID(@Param("id") Integer id);

    /**
     * 通过id查找数据
     * @param id
     * @return
     */
    @Select("select * from publicityTemplate where id = #{id}")
    PublicityTemplate findByID(@Param("id") Integer id);

    /**
     * 更新语句
     * @param publicityTemplate
     */
    @Update("update publicityTemplate set templateName= #{publicityTemplate.templateName},templateType=#{publicityTemplate.templateType}" +
            ",textDescription=#{publicityTemplate.textDescription},image=#{publicityTemplate.image}" +
            ",price=#{publicityTemplate.price},updateTime=#{publicityTemplate.updateTime} where id = #{publicityTemplate.id}")
    void updateObject(@Param("publicityTemplate") PublicityTemplate publicityTemplate);
}
