package com.dongni.dongnimall.base.sms;

import com.aliyuncs.exceptions.ClientException;

/**
 * 短信服务
 */
public interface SMSManager {
    /**
     * 发送注册验证码
     *
     * @param phoneNumber
     * @return
     * @throws ClientException
     */
    boolean sendSmsRegisterCode(String phoneNumber);

    /**
     * 注册验证码验证
     *
     * @param phoneNumber
     * @param code
     * @return
     */
    boolean validateRegisterCode(String phoneNumber, String code);
}
