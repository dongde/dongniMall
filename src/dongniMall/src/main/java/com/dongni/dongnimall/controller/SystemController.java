package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.vo.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cengshuai on 2019-09-20.
 * @version 1.0
 */
@RestController
@RequestMapping("/system")
public class SystemController {

    @RequestMapping("/getSystemInfo")
    public JsonResult getSystemInfo(){

        return JsonResult.ok();
    }
}
