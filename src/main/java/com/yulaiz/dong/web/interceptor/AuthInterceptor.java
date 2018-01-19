package com.yulaiz.dong.web.interceptor;

import com.yulaiz.dong.web.common.annotation.IgnoreSecurity;
import com.yulaiz.dong.web.model.entity.UserInfo;
import com.yulaiz.dong.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by YuLai on 2018/1/19.
 */
@Slf4j
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    /**
     * This implementation always returns {@code true}.
     *
     * @param request
     * @param response
     * @param handler
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        log.debug("Method : " + method.getName() + " : " + method.isAnnotationPresent(IgnoreSecurity.class));
        String requestPath = request.getRequestURI();
        log.debug("requestPath:" + requestPath);
        if (requestPath.contains("/v2/api-docs") || requestPath.contains("/swagger") || requestPath.contains("/configuration/ui")) {
            return true;
        }
        if (requestPath.contains("/error")) {
            return true;
        }
        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
            return true;
        }
        String token = request.getHeader("ACCESS_TOKEN");
        log.info("token:" + token);
        UserInfo userInfo = userService.getUserByToken(token);
        return true;

    }
}
