package com.dongni.dongnimall.pojo;

import org.springframework.stereotype.Component;

/**
 * @author cengshuai on 2019-09-27.
 * @version 1.0
 */
@Component
public class DiskDO {
    //盘符名称
    private String devName;
    //盘符路径
    private String dirName;
    //盘符标志
    private Long flags;
    //盘符类型
    private String sysTypeName;
    //盘符类型名
    private String typeName;
    //盘符文件系统类型
    private Integer type;
    //盘符总大小
    private Long usageTotal;
    //盘符剩余大小
    private Long usageFree;
    //盘符可用大小
    private Long usageAvail;
    //盘符已经使用量
    private Long usageUsed;
    //资源利用率
    private Double usePercent;

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public Long getFlags() {
        return flags;
    }

    public void setFlags(Long flags) {
        this.flags = flags;
    }

    public String getSysTypeName() {
        return sysTypeName;
    }

    public void setSysTypeName(String sysTypeName) {
        this.sysTypeName = sysTypeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getUsageTotal() {
        return usageTotal;
    }

    public void setUsageTotal(Long usageTotal) {
        this.usageTotal = usageTotal;
    }

    public Long getUsageFree() {
        return usageFree;
    }

    public void setUsageFree(Long usageFree) {
        this.usageFree = usageFree;
    }

    public Long getUsageAvail() {
        return usageAvail;
    }

    public void setUsageAvail(Long usageAvail) {
        this.usageAvail = usageAvail;
    }

    public Long getUsageUsed() {
        return usageUsed;
    }

    public void setUsageUsed(Long usageUsed) {
        this.usageUsed = usageUsed;
    }

    public Double getUsePercent() {
        return usePercent;
    }

    public void setUsePercent(Double usePercent) {
        this.usePercent = usePercent;
    }
}
