package com.dongni.dongnimall.pojo;

/**
 * @author cengshuai on 2019-09-10.
 * @version 1.0
 */
public class CodeDO {
    //验证码
    private String code;
    //验证码图片路径
    private String codeUrl;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }
}
