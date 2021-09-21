package com.huixiong.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-09-07 13:48
 */
@Component
public class LoggerInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("hhhhhhhhhhh");

    }
}
