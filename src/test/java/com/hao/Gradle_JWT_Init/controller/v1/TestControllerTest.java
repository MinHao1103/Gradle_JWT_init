package com.hao.Gradle_JWT_Init.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hao.Gradle_JWT_Init.dto.in.TestCreateIn;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        String result = mockMvc.perform(post("/v1/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testCreateIn)))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        JsonObject jsonResponse = gson.fromJson(result, JsonObject.class);
        assertEquals(0, jsonResponse.get("result").getAsInt());
    }

}