package com.dongni.dongnimall.manager;

import com.dongni.dongnimall.dao.OrderMapper;
import com.dongni.dongnimall.pojo.OrderDO;
import com.dongni.dongnimall.vo.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
@Service
public class orderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void addOrder(OrderDO orderDO) {
        orderMapper.insertOrder(orderDO);
    }

    @Override
    public void removeOrder(String order_number) {
        orderMapper.deleteOrder(order_number);
    }

    @Override
    public PageData queryOrderList(Integer page, Integer pageSize, String user_phone) {
        PageHelper.startPage(page, pageSize);
        List<OrderDO> list = orderMapper.selectOrderList(user_phone);
        PageInfo<OrderDO> pageInfo = new PageInfo<>(list);
        PageData pageData = new PageData();
        pageData.setCode(0);
        pageData.setCount(pageInfo.getTotal());
        pageData.setData(list);
        pageData.setMsg("");
        return pageData;
    }

    @Override
    public void modifyOrder(OrderDO orderDO) {
        orderMapper.updateOrder(orderDO);
    }
}
