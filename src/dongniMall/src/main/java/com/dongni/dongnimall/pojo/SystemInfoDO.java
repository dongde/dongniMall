package com.dongni.dongnimall.pojo;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cengshuai on 2019-09-27.
 * @version 1.0
 */
@Service
public class SystemInfoDO {
    //cpu信息列表
    private List<CpuDO> cpus;

    //内存总量
    private Long memoryTotal;
    //当前内存使用量
    private Long memoryUsed;
    //当前内存剩余余量
    private Long memoryFree;
    //交换区总量
    private Long swapTotal;
    //当前交换区使用量
    private Long swapUsed;
    //当前交换区剩余量
    private Long swapFree;

    //磁盘信息列表
    private List<DiskDO> disks;

    //jvm可以使用的内存
    private Long totalMemory;
    //jvm可以使用的剩余内存
    private Long freeMemory;
    //jvm可使用的处理器个数
    private Integer availableProcessors;
    //java运行版本
    private String version;
    //java的安装路径
    private String home;

    //系统名
    private String osName;
    //服务器架构
    private String osArch;
    //服务器版本
    private String osVersion;
    //IP
    private String ip;

    public List<CpuDO> getCpus() {
        return cpus;
    }

    public void setCpus(List<CpuDO> cpus) {
        this.cpus = cpus;
    }

    public List<DiskDO> getDisks() {
        return disks;
    }

    public void setDisks(List<DiskDO> disks) {
        this.disks = disks;
    }

    public Long getMemoryTotal() {
        return memoryTotal;
    }

    public void setMemoryTotal(Long memoryTotal) {
        this.memoryTotal = memoryTotal;
    }

    public Long getMemoryUsed() {
        return memoryUsed;
    }

    public void setMemoryUsed(Long memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    public Long getMemoryFree() {
        return memoryFree;
    }

    public void setMemoryFree(Long memoryFree) {
        this.memoryFree = memoryFree;
    }

    public Long getSwapTotal() {
        return swapTotal;
    }

    public void setSwapTotal(Long swapTotal) {
        this.swapTotal = swapTotal;
    }

    public Long getSwapUsed() {
        return swapUsed;
    }

    public void setSwapUsed(Long swapUsed) {
        this.swapUsed = swapUsed;
    }

    public Long getSwapFree() {
        return swapFree;
    }

    public void setSwapFree(Long swapFree) {
        this.swapFree = swapFree;
    }

    public Long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(Long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public Long getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(Long freeMemory) {
        this.freeMemory = freeMemory;
    }

    public Integer getAvailableProcessors() {
        return availableProcessors;
    }

    public void setAvailableProcessors(Integer availableProcessors) {
        this.availableProcessors = availableProcessors;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsArch() {
        return osArch;
    }

    public void setOsArch(String osArch) {
        this.osArch = osArch;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
