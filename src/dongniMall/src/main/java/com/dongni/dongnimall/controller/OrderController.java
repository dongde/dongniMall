package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.manager.GoodsService;
import com.dongni.dongnimall.manager.LogisticsService;
import com.dongni.dongnimall.manager.OrderService;
import com.dongni.dongnimall.pojo.GoodsDO;
import com.dongni.dongnimall.pojo.LogisticsDO;
import com.dongni.dongnimall.pojo.OrderDO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private LogisticsService logisticsService;
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/queryOrderList")
    public PageData queryOrderList(Integer page, Integer limit) {
        return orderService.queryOrderList(page, limit);
    }

    @RequestMapping("/addOrder")
    public JsonResult addOrder(String order_number, String user_phone, BigDecimal payment_amount, @RequestBody List<GoodsDO> goodsList) {
        if (StringUtils.isBlank(user_phone) || payment_amount == null || goodsList.size() == 0) {
            return JsonResult.errorMsg("创建订单出错");
        }
//        String order_number = UUID.randomUUID().toString();
        OrderDO orderDO = new OrderDO();
        orderDO.setOrder_number(order_number);
        orderDO.setUser_phone(user_phone);
        orderDO.setPayment_amount(payment_amount);
        orderService.addOrder(orderDO);
        for (GoodsDO goodsDO : goodsList) {
            goodsDO.setOrder_number(order_number);
        }
        goodsService.addGoods(goodsList);
        return JsonResult.ok();
    }

    @RequestMapping("/modifyOrder")
    public JsonResult modifyOrder(String order_number, Integer payment_method, Integer order_status) {
        if (StringUtils.isBlank(order_number)) {
            return JsonResult.errorMsg("修改订单出错");
        }
        OrderDO orderDO = new OrderDO();
        orderDO.setOrder_number(order_number);
        orderDO.setPayment_method(payment_method);
        orderDO.setOrder_status(order_status);
        if(order_status == 3) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String complete_time = simpleDateFormat.format(date);
            orderDO.setComplete_time(complete_time);
        }
        orderService.modifyOrder(orderDO);
        return JsonResult.ok();
    }

    @RequestMapping("/removeOrder")
    public JsonResult removeOrder(String order_number) {
        if (StringUtils.isBlank(order_number)) {
            return JsonResult.errorMsg("删除订单出错");
        }
        orderService.removeOrder(order_number);
        logisticsService.removeLogistics(order_number);
        goodsService.removeGoods(order_number);
        return JsonResult.ok();
    }


    @RequestMapping("/queryLogistics")
    public JsonResult queryLogistics(String order_number) {
        return JsonResult.ok(logisticsService.queryLogistics(order_number));
    }

    @RequestMapping("/addLogistics")
    public JsonResult addLogistics(String order_number, String logistics_number, Integer delivery_method) {
        if (StringUtils.isBlank(order_number) || StringUtils.isBlank(logistics_number) || delivery_method == null) {
            return JsonResult.errorMsg("物流添加出错");
        }
        LogisticsDO logisticsDO = new LogisticsDO();
        logisticsDO.setOrder_number(order_number);
        logisticsDO.setLogistics_number(logistics_number);
        logisticsDO.setDelivery_method(delivery_method);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newDate = simpleDateFormat.format(date);
        logisticsDO.setCreate_time(newDate);
        logisticsService.addLogistics(logisticsDO);

        OrderDO orderDO = new OrderDO();
        orderDO.setOrder_number(order_number);
        orderDO.setOrder_status(2);
        orderService.modifyOrder(orderDO);
        return JsonResult.ok();
    }


    @RequestMapping("/queryGoods")
    public JsonResult queryGoods(String order_number) {
        return JsonResult.ok(goodsService.queryGoods(order_number));
    }
}
