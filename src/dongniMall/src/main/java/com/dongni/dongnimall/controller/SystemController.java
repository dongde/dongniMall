package com.dongni.dongnimall.controller;

import com.dongni.dongnimall.base.SystemInfo.SystemInfoManager;
import com.dongni.dongnimall.vo.JsonResult;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;

/**
 * @author cengshuai on 2019-09-20.
 * @version 1.0
 */
@RestController
@RequestMapping("/system")
public class SystemController {
    @Autowired
    private SystemInfoManager systemInfoManager;

    @RequestMapping("/getSystemInfo")
    public JsonResult getSystemInfo() throws SigarException, UnknownHostException {
        return JsonResult.ok(systemInfoManager.getSystemInfo());
    }
}
