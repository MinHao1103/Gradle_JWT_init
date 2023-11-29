package com.hao.Gradle_JWT_Init.interceptor;

import com.hao.Gradle_JWT_Init.exception.JwtVerificationException;
import com.hao.Gradle_JWT_Init.utils.jwt.JwtData;
import com.hao.Gradle_JWT_Init.utils.jwt.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.hao.Gradle_JWT_Init.define.Constance.AUTHORIZATION_PROPERTY;

@Component
public class JWTInterceptor implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(JWTInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logRequestInfo(request);
        request.setAttribute("LoginInfo", JWTInterceptor.verifyJwtToken(request));
        return true;
    }

    private void logRequestInfo(HttpServletRequest request) {
        log.info(String.format("[URI: %s://%s:%d%s]", request.getScheme(), request.getServerName(), request.getServerPort(), request.getRequestURI()));
    }

    private static JwtData verifyJwtToken(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION_PROPERTY);
        try {
            JwtData jwtData = JwtUtil.verifyToken(token);
            log.info("id: " + jwtData.getId());
            return jwtData;
        } catch (Exception e) {
            log.info("JWT Token Verification Failed");
            throw new JwtVerificationException();
        }
    }

}
