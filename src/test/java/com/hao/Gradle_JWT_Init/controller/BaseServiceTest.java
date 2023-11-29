package com.hao.Gradle_JWT_Init.controller;

import com.hao.Gradle_JWT_Init.utils.jwt.JwtData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BaseServiceTest {
    @Autowired
    private MockMvc mockMvc;

    private MockHttpServletRequest request;

    public static MockHttpServletRequest createMockRequest() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        JwtData testJwtData = new JwtData();
        testJwtData.setId(1L);
        testJwtData.setEmail("test@example.com");
        request.setAttribute("LoginInfo", testJwtData);
        return request;
    }

}