package com.dongni.dongnimall.mapper;

//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.dongni.dongnimall.entity.BillShop;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface BillShopMapper extends BaseMapper<BillShop> {
//    /**
//     * 分页获取
//     *
//     * @param page
//     * @return
//     */
//    @Select("select * from bill_shop where name=#{name}")
//    IPage<BillShop> selectPageVo(Page page, @Param("name")String name);
//
//    /**
//     * 方法1：mybatis @Select注解中如何拼写动态sql
//     * https://blog.csdn.net/qq_32786873/article/details/78297551
//     */
////    @Select("<script>"
////            + "SELECT "
////            + "a.id as 'id',a.create_date as 'createDate',a.content as 'content',"
////            + "a.parent_id as 'parentId',a.first_comment_id as 'firstCommentId',"
////            + "b.id as 'fromUser.id',b.realname as 'fromUser.realname',b.avatar as 'fromUser.avatar',"
////            + "c.id as 'toUser.id',c.realname as 'toUser.realname',c.avatar as 'toUser.avatar' "
////            + "FROM t_demand_comment a "
////            + "LEFT JOIN t_user b ON b.id = a.from_uid "
////            + "LEFT JOIN t_user c ON c.id = a.to_uid "
////            + "WHERE a.demand_id = #{demandId} "
////            + "ORDER BY a.create_date ASC "
////            + "<if test='startNo!=null and pageSize != null '>"
////            + "LIMIT #{startNo},#{pageSize}"
////            + "</if>"
////            + "</script>")
////    public List<DemandComment> listDemandComment(@Param("demandId") Long demandId, @Param("startNo") Integer pageNo, @Param("pageSize") Integer pageSize);
//
//    /**
//     * 方法2 : mybatis的注解开发之三种动态sql
//     * https://www.cnblogs.com/guoyafenghome/p/9123442.html
//     */
////    @SelectProvider(type = UserDaoProvider.class, method = "findUserById")
////    public List<User> findUserById(User user);
////
////    class UserDaoProvider {
////        public String findUserById(User user) {
////            String sql = "SELECT * FROM user";
////            if(user.getId()!=null){
////                sql += " where id = #{id}";
////            }
////            return sql;
////        }
////    }
//}
