package com.dongni.dongnimall.vo;

import java.util.List;

/**
 * @author cengshuai on 2019-09-06.
 * @version 1.0
 */
public class PageData {
    private int code;

    private String msg;

    private long count;

    private List data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
