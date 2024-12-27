package com.hao.Gradle_JWT_Init.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hao.Gradle_JWT_Init.dto.in.TestCreateIn;
import com.hao.Gradle_JWT_Init.dto.in.TestLogin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Gson gson;

    @Test
    void createUser_ShouldReturn200() throws Exception {
        TestCreateIn testCreateIn = new TestCreateIn();
        testCreateIn.setEmail("example@example.com");
        testCreateIn.setPassword("password");

        MvcResult createResult = mockMvc.perform(post("/v1/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testCreateIn)))
                .andExpect(status().isOk())
                .andReturn();

        String createResponse = createResult.getResponse().getContentAsString();
        JsonObject createJsonResponse = gson.fromJson(createResponse, JsonObject.class);
        assertEquals(0, createJsonResponse.get("result").getAsInt());
    }

    @Test
    void getAllUsers_ShouldReturn200() throws Exception {
        TestLogin testLogin = new TestLogin();
        testLogin.setEmail("user1@example.com");
        testLogin.setPassword("password");

        MvcResult loginResult = mockMvc.perform(post("/v1/test/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testLogin)))
                .andExpect(status().isOk())
                .andReturn();

        String loginResponse = loginResult.getResponse().getContentAsString();
        JsonObject loginJsonResponse = gson.fromJson(loginResponse, JsonObject.class);
        String validJwtToken = loginJsonResponse.getAsJsonObject("data").get("token").getAsString();

        MvcResult listResult = mockMvc.perform(get("/v1/test/list")
                        .header("Authorization", validJwtToken)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String listResponse = listResult.getResponse().getContentAsString();
        JsonObject listJsonResponse = gson.fromJson(listResponse, JsonObject.class);
        assertEquals(0, listJsonResponse.get("result").getAsInt());
    }

}