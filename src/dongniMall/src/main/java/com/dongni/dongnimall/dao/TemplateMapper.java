package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.TemplateDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemplateMapper {
    /**
     * 查询表的全部信息
     * @return
     */
    @Select("select * from publicitytemplate order by updateTime desc")
    List<TemplateDO> selectAll();

    /**
     * 通过类型查找
     * @param templateType
     * @return
     */
    @Select("select * from publicitytemplate where templateType = #{templateType} ")
    List<TemplateDO> queryByType(@Param("templateType") String templateType);

    /**
     * 通过名字查找
     * @param templateName
     * @return
     */
    @Select("select * from publicitytemplate where templateName like concat(concat('%',#{templateName}),'%') ")
    List<TemplateDO> queryByName(@Param("templateName") String templateName);

    /**
     * 通过名字和类型查找
     * @param templateName
     * @param templateType
     * @return
     */
    @Select("select * from publicitytemplate where templateName like concat(concat('%',#{templateName}),'%') and templateType = #{templateType}")
    TemplateDO findByNameAndType(@Param("templateName") String templateName, @Param("templateType") String templateType);

    /**
     * 插入数据到数据库
     * @param templateDO
     */
    @Insert("insert into publicitytemplate (id,templateName,templateType,textDescription,image,price,updateTime) values" +
            "( #{templateDO.id},#{templateDO.templateName},#{templateDO.templateType}," +
            "#{templateDO.textDescription},#{templateDO.image}," +
            "#{templateDO.price},#{templateDO.updateTime})")
    void insertTemplate(@Param("templateDO") TemplateDO templateDO);

    /**
     * 通过id删除数据
     * @param id
     */
    @Delete("delete from publicitytemplate where id = #{id}")
    void deleteByID(@Param("id") String id);

    /**
     * 通过id查找数据
     * @param id
     * @return
     */
    @Select("select * from publicitytemplate where id = #{id}")
    TemplateDO findByID(@Param("id") String id);

    /**
     * 更新语句
     * @param templateDO
     */
    @Update("update publicitytemplate set templateName= #{templateDO.templateName},templateType=#{templateDO.templateType}" +
            ",textDescription=#{templateDO.textDescription},image=#{templateDO.image}" +
            ",price=#{templateDO.price},updateTime=#{templateDO.updateTime} where id = #{templateDO.id}")
    void updateObject(@Param("templateDO") TemplateDO templateDO);
}
