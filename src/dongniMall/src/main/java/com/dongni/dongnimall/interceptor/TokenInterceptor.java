package com.dongni.dongnimall.interceptor;

import com.alibaba.fastjson.JSON;
import com.dongni.dongnimall.vo.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author cengshuai on 2019-09-21.
 * @version 1.0
 */
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录验证拦截
//        String token = (String) request.getSession().getAttribute("token");
//        if (StringUtils.isBlank(token)) {
//            returnErrorResponse(response, new JsonResult().errorTokenMsg("请登录"));
//            return false;
//        }
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals("token")) {
//                if (cookie.getValue().equals(token)) {
//                    returnErrorResponse(response, new JsonResult().errorTokenMsg("请登录"));
//                }
//            }
//        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public void returnErrorResponse(HttpServletResponse response, JsonResult result) throws IOException {
        OutputStream out = null;

        response.setContentType("text/json");
        response.setCharacterEncoding("utf-8");
        try {
            out = response.getOutputStream();

            out.write(JSON.toJSON(result).toString().getBytes("utf-8"));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }
}
