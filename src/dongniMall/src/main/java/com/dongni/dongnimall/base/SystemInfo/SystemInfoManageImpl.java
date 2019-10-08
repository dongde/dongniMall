package com.dongni.dongnimall.base.SystemInfo;

import com.dongni.dongnimall.pojo.CpuDO;
import com.dongni.dongnimall.pojo.DiskDO;
import com.dongni.dongnimall.pojo.SystemInfoDO;
import org.hyperic.sigar.*;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author cengshuai on 2019-09-27.
 * @version 1.0
 */
@Service
public class SystemInfoManageImpl implements SystemInfoManager {

    @Override
    public SystemInfoDO getSystemInfo() throws SigarException, UnknownHostException {
        SystemInfoDO systemInfoDO = new SystemInfoDO();
        Sigar sigar = new Sigar();

        //获取cpu信息
        CpuInfo[] infos = sigar.getCpuInfoList();
        CpuPerc[] cpuList = sigar.getCpuPercList();
        List<CpuDO> list = new ArrayList<>();
        for (int i = 0; i < infos.length; i++) {
            CpuInfo info = infos[i];
            CpuDO cpuDO = new CpuDO();
            cpuDO.setCpuNumber(i + 1);
            cpuDO.setCpuMhz(info.getMhz());
            cpuDO.setCpuVendor(info.getVendor());
            cpuDO.setCpuModel(info.getModel());
            cpuDO.setCpuCacheSize(info.getCacheSize());
            cpuDO.setCpuUser(CpuPerc.format(cpuList[i].getUser()));
            cpuDO.setCpuSys(CpuPerc.format(cpuList[i].getSys()));
            cpuDO.setCpuWait(CpuPerc.format(cpuList[i].getWait()));
            cpuDO.setCpuNice(CpuPerc.format(cpuList[i].getNice()));
            cpuDO.setCpuIdle(CpuPerc.format(cpuList[i].getIdle()));
            cpuDO.setCpuCombined(CpuPerc.format(cpuList[i].getCombined()));
            list.add(cpuDO);
        }
        systemInfoDO.setCpus(list);

        //获取内存信息
        Mem mem = sigar.getMem();
        systemInfoDO.setMemoryTotal(mem.getTotal() / 1024L / 1024L);
        systemInfoDO.setMemoryUsed(mem.getUsed() / 1024L / 1024L);
        systemInfoDO.setMemoryFree(mem.getFree() / 1024L / 1024L);
        Swap swap = sigar.getSwap();
        systemInfoDO.setSwapTotal(swap.getTotal() / 1024L / 1024L);
        systemInfoDO.setSwapUsed(swap.getUsed() / 1024L / 1024L);
        systemInfoDO.setSwapFree(swap.getFree() / 1024L / 1024L);

        //获取磁盘信息
        FileSystem[] fslist = sigar.getFileSystemList();
        List<DiskDO> list1 = new ArrayList<>();
        for (FileSystem fs : fslist) {
            DiskDO diskDO = new DiskDO();

            diskDO.setDevName(fs.getDevName());
            diskDO.setDirName(fs.getDirName());
            diskDO.setFlags(fs.getFlags());
            diskDO.setSysTypeName(fs.getSysTypeName());
            diskDO.setTypeName(fs.getTypeName());
            diskDO.setType(fs.getType());

            FileSystemUsage usage = sigar.getFileSystemUsage(fs.getDirName());
            diskDO.setUsageTotal(usage.getTotal() / 1024L);
            diskDO.setUsageFree(usage.getFree() / 1024L);
            diskDO.setUsageAvail(usage.getAvail() / 1024L);
            diskDO.setUsageUsed(usage.getUsed() / 1024L);
            diskDO.setUsePercent(usage.getUsePercent() * 100D);

            list1.add(diskDO);
        }
        systemInfoDO.setDisks(list1);

        //获取jvm信息
        Runtime r = Runtime.getRuntime();
        Properties props = System.getProperties();
        systemInfoDO.setTotalMemory(r.totalMemory() / 1024L);
        systemInfoDO.setFreeMemory(r.freeMemory() / 1024L);
        systemInfoDO.setAvailableProcessors(r.availableProcessors());
        systemInfoDO.setVersion(props.getProperty("java.version"));
        systemInfoDO.setHome(props.getProperty("java.home"));

        //获取服务器信息
        InetAddress addr = InetAddress.getLocalHost();
        systemInfoDO.setIp(addr.getHostAddress());
        systemInfoDO.setOsName(props.getProperty("os.name"));
        systemInfoDO.setOsArch(props.getProperty("os.arch"));
        systemInfoDO.setOsVersion(props.getProperty("os.version"));

        return systemInfoDO;
    }

}
