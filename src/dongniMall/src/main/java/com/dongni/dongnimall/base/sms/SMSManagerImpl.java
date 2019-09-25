package com.dongni.dongnimall.base.sms;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.gson.Gson;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 短信服务
 */
@Service
public class SMSManagerImpl implements SMSManager {
    private static final Logger logger = LoggerFactory.getLogger(SMSManagerImpl.class);

    @Value("${aliyun.message.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.message.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.message.signName}")
    private String signName;

    @Autowired
    private Gson gson;

    @Override
    public boolean sendSmsRegisterCode(String phoneNumber){
        String code = getRandomCode();
        boolean success = false;
        try {
            success = isSuccess(sendSms(phoneNumber, "SMS_170800227", code));
            if (success) {
                numberCodeMapping.put(phoneNumber, Optional.of(code));
            }
        } catch (ClientException e) {
            logger.error("发送短信异常：", e);
        }
        return success;
    }

    @Override
    public boolean validateRegisterCode(String phoneNumber, String code) {
        Optional<String> optional = getValue(phoneNumber);
        return optional.filter(s -> Objects.equals(code, s)).isPresent();
    }

    /**
     * 判断是否成功
     *
     * @param response
     * @return
     */
    private boolean isSuccess(CommonResponse response) {
        boolean success = response.getHttpStatus() == 200;
        if (!success) {
            logger.error("短信发送失败：" + response.getData());
        } else {
            Map map = gson.fromJson(response.getData(), Map.class);
            success = Objects.equals("OK", map.get("Code"));
        }
        return success;
    }

    private IAcsClient getClient() {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        return new DefaultAcsClient(profile);
    }

    /**
     * 发送短信验证码
     *
     * @param phoneNumber
     * @param templateCode
     * @param code
     * @return
     */
    private CommonResponse sendSms(String phoneNumber, String templateCode, String code) throws ClientException {
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        return getClient().getCommonResponse(request);
    }

    //============================================
    // 验证码缓存
    //============================================
    // 手机号<->验证码映射
    private LoadingCache<String, Optional<String>> numberCodeMapping = CacheBuilder.newBuilder()
            .concurrencyLevel(50).expireAfterAccess(15, TimeUnit.MINUTES)
            .build(new CacheLoader<String, Optional<String>>() {
                @Override
                public Optional<String> load(String key) throws Exception {
                    return Optional.empty();
                }
            });
    /**
     * 获取随机码
     *
     * @return
     */
    private String getRandomCode() {
        return RandomStringUtils.randomNumeric(6);
    }

    private Optional<String> getValue(String key) {
        try {
            return numberCodeMapping.get(key);
        } catch (ExecutionException e) {
            logger.error("获取缓存出错：", e);
        }
        return Optional.empty();
    }
}
