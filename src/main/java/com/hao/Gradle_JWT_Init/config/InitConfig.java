package com.hao.Gradle_JWT_Init.config;

import com.hao.Gradle_JWT_Init.utils.jwt.JwtUtil;
import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class InitConfig {

    private static Logger log = LoggerFactory.getLogger(InitConfig.class);

    @PostConstruct
    public void init() {
        initJWT();
        log.info("Swagger UI：http://localhost:8080/gradle_JWT_Init/swagger-ui.html");
    }

    private void initJWT() {
        if (StringUtils.isNotBlank(Config.CRT) && StringUtils.isNotBlank(Config.KEY)) {
            JwtUtil.init(Config.CRT, Config.KEY); // 初始化 JWT
        } else {
            log.info("JWT initialization failed.");
            log.info("Confirm the Config file parameters CRT and KEY.");
        }
    }

}
