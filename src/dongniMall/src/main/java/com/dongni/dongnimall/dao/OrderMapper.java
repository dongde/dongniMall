package com.dongni.dongnimall.dao;

import com.dongni.dongnimall.pojo.OrderDO;
import com.dongni.dongnimall.vo.OrderVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
@Repository
public interface OrderMapper {

    void insertOrder(@Param("orderDO") OrderDO orderDO);

    void deleteOrder(String order_number);

    List<OrderDO> selectOrderList();

    void updateOrder(@Param("orderDO") OrderDO orderDO);
}
