package com.dongni.dongnimall.base.SystemInfo;

import com.dongni.dongnimall.pojo.SystemInfoDO;
import org.hyperic.sigar.SigarException;

import java.net.UnknownHostException;

/**
 * @author cengshuai on 2019-09-27.
 * @version 1.0
 */
public interface SystemInfoManager {

    /**
     * @Description: 获取系统信息
     * @return
     */
    SystemInfoDO getSystemInfo() throws SigarException, UnknownHostException;
}
