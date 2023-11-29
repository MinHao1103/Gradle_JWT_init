package com.hao.Gradle_JWT_Init.controller;

import com.hao.Gradle_JWT_Init.dto.in.TestCreateIn;
import com.hao.Gradle_JWT_Init.dto.in.TestUpdateIn;
import com.hao.Gradle_JWT_Init.dto.out.TestOut;
import com.hao.Gradle_JWT_Init.utils.httpResult.CommonHttpResult;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.MethodName.class)
class TestControllerTest extends BaseServiceTest {

    private Long testLong;

    @Autowired
    private TestController testController;

    @Test
    void a_testCreateUser() {
        TestCreateIn testCreateIn = new TestCreateIn();
        testCreateIn.setEmail("test@example.com");
        testCreateIn.setPassword("testPassword");
        CommonHttpResult<Long> result = testController.createUser(testCreateIn);
        assertNotNull(result);
        assertNotNull(result.getData());
        testLong = result.getData();
    }

    @Test
    void b_getAllUsers() {
        CommonHttpResult<List<TestOut>> result = testController.getAllUsers(createMockRequest());
        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    void c_getUserById() {
        CommonHttpResult<TestOut> result = testController.getUserById(testLong);
        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    void d_updateUser() {
        TestUpdateIn updateUserIn = new TestUpdateIn();
        updateUserIn.setPassword("123");
        CommonHttpResult<Long> result = testController.updateUser(testLong, updateUserIn);
        assertNotNull(result);
        assertNotNull(result.getData());
    }

    @Test
    void e_deleteUser() {
        CommonHttpResult<Long> result = testController.deleteUser(testLong);
        assertNotNull(result);
        assertNotNull(result.getData());
    }

}