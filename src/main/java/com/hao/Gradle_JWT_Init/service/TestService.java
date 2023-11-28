package com.hao.Gradle_JWT_Init.service;

import com.hao.Gradle_JWT_Init.dao.TestDao;
import com.hao.Gradle_JWT_Init.define.ErrorId;
import com.hao.Gradle_JWT_Init.dto.in.TestCreateIn;
import com.hao.Gradle_JWT_Init.dto.in.TestUpdateIn;
import com.hao.Gradle_JWT_Init.dto.out.TestOut;
import com.hao.Gradle_JWT_Init.utils.httpResult.CommonHttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private static String TAG = "TestService";

    @Autowired
    private TestDao testDao;

    public CommonHttpResult<Long> createUser(TestCreateIn testCreateIn) {
        Long result = testDao.createUser(testCreateIn);
        return new CommonHttpResult<>(result != null ? ErrorId.SUCCESS : ErrorId.Test_Insert_Fail, result);
    }

    public CommonHttpResult<List<TestOut>> getAllUsers() {
        return new CommonHttpResult<>(ErrorId.SUCCESS, testDao.getAllUsers());
    }

    public CommonHttpResult<TestOut> getUserById(Long id) {
        TestOut result = testDao.getUserById(id);
        return new CommonHttpResult<>(result != null ? ErrorId.SUCCESS : ErrorId.Test_Not_Found, result);
    }

    public CommonHttpResult<Long> updateUser(Long id, TestUpdateIn testUpdateIn) {
        Long result = testDao.updateUser(id, testUpdateIn);
        return new CommonHttpResult<>(result != null ? ErrorId.SUCCESS : ErrorId.Test_Update_Fail, result);
    }

    public CommonHttpResult<Long> deleteUser(Long id) {
        Long result = testDao.deleteUser(id);
        return new CommonHttpResult<>(result != null ? ErrorId.SUCCESS : ErrorId.Test_Delete_Fail, result);
    }

}
