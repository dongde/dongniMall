package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.manager.OrderService;
import com.dongni.dongnimall.vo.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cengshuai on 2019-09-17.
 * @version 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/queryOrderList")
    public PageData queryOrderList(Integer page,Integer limit){
        return orderService.queryOrderList(page,limit);
    }
}
