package com.dongni.dongnimall.controller;

import com.alibaba.fastjson.JSONObject;
import com.dongni.dongnimall.manager.GoodsService;
import com.dongni.dongnimall.manager.LogisticsService;
import com.dongni.dongnimall.manager.OrderService;
import com.dongni.dongnimall.pojo.GoodsDO;
import com.dongni.dongnimall.pojo.LogisticsDO;
import com.dongni.dongnimall.pojo.OrderDO;
import com.dongni.dongnimall.vo.JsonResult;
import com.dongni.dongnimall.vo.PageData;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
    private Sid sid;
    @Autowired
    private OrderService orderService;
    @Autowired
    private LogisticsService logisticsService;
    @Autowired
    private GoodsService goodsService;

    @PostMapping("/addGoods")
    public JsonResult addGoods(@RequestBody GoodsDO goodsDO) {
        if (StringUtils.isBlank(goodsDO.getUser_phone()) || StringUtils.isBlank(goodsDO.getGoods_name()) || StringUtils.isBlank(goodsDO.getGoods_img()) || goodsDO.getGoods_price() == null || goodsDO.getGoods_count() == null || goodsDO.getSubtotal() == null) {
            return JsonResult.errorMsg("添加出错");
        }
        goodsDO.setId(sid.nextShort());
        goodsService.addGoods(goodsDO);
        return JsonResult.ok();
    }

    @GetMapping("/queryGoods")
    public JsonResult queryGoods(String user_phone) {
        return JsonResult.ok(goodsService.queryGoods(user_phone));
    }

    @PostMapping("/removeGoodsById")
    public JsonResult removeGoodsById(@RequestBody JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        if (StringUtils.isBlank(id)) {
            return JsonResult.errorMsg("删除出错");
        }
        goodsService.removeGoodsById(id);
        return JsonResult.ok();
    }

    @PostMapping("/modifyGoods")
    public JsonResult modifyGoods(@RequestBody GoodsDO goodsDO) {
        if (StringUtils.isBlank(goodsDO.getId()) || goodsDO.getGoods_count() == null || goodsDO.getSubtotal() == null) {
            return JsonResult.errorMsg("异常出错");
        }
        goodsService.modifyGoods(goodsDO);
        return JsonResult.ok();
    }

    @GetMapping("/queryOrderList")
    public PageData queryOrderList(Integer page, Integer limit,@RequestParam(value = "user_phone",required = false) String user_phone) {
        return orderService.queryOrderList(page, limit, user_phone);
    }

    @PostMapping(value = "/addOrder", produces = "application/json;charset=UTF-8")
    public JsonResult addOrder(@RequestBody JSONObject jsonObject) {
        List<String> goodsIds = (List<String>) jsonObject.get("goodsIds");
        String user_phone = jsonObject.getString("user_phone");
        BigDecimal payment_amount = jsonObject.getBigDecimal("payment_amount");
        Integer payment_method = jsonObject.getInteger("payment_method");
        if (StringUtils.isBlank(user_phone) || payment_amount == null || payment_method == null) {
            return JsonResult.errorMsg("数据空异常");
        }
        if (goodsIds.size() == 0) {
            return JsonResult.errorMsg("创建订单出错");
        }
        String order_number = UUID.randomUUID().toString();
        OrderDO orderDO = new OrderDO();
        orderDO.setOrder_number(order_number);
        orderDO.setUser_phone(user_phone);
        orderDO.setPayment_amount(payment_amount);
        orderDO.setPayment_method(payment_method);
        orderDO.setOrder_status(1);
        orderDO.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        orderService.addOrder(orderDO);
        goodsService.modifyGoodsOrderNumber(order_number, goodsIds);
        return JsonResult.ok();
    }

    @PostMapping("/modifyOrder")
    public JsonResult modifyOrder(String order_number, Integer payment_method, Integer order_status) {
        if (StringUtils.isBlank(order_number)) {
            return JsonResult.errorMsg("修改订单出错");
        }
        OrderDO orderDO = new OrderDO();
        orderDO.setOrder_number(order_number);
        orderDO.setPayment_method(payment_method);
        orderDO.setOrder_status(order_status);
        if (order_status == 3) {
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
        goodsService.removeGoodsByOrderNumber(order_number);
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

    @GetMapping("/queryOrderGoods")
    public JsonResult queryOrderGoods(String order_number) {
        return JsonResult.ok(goodsService.queryOrderGoods(order_number));
    }
}
