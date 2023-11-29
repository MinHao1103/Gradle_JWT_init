package com.hao.Gradle_JWT_Init.service;

import com.hao.Gradle_JWT_Init.dao.TestDao;
import com.hao.Gradle_JWT_Init.dto.in.TestCreateIn;
import com.hao.Gradle_JWT_Init.dto.in.TestLogin;
import com.hao.Gradle_JWT_Init.dto.in.TestUpdateIn;
import com.hao.Gradle_JWT_Init.dto.out.TestLoginOut;
import com.hao.Gradle_JWT_Init.dto.out.TestOut;
import com.hao.Gradle_JWT_Init.utils.httpResult.CommonHttpResult;
import com.hao.Gradle_JWT_Init.utils.jwt.JwtData;
import com.hao.Gradle_JWT_Init.utils.jwt.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hao.Gradle_JWT_Init.define.ErrorId.*;

@Service
public class TestService {

    private static String TAG = "TestService";

    @Autowired
    private TestDao testDao;

    public CommonHttpResult<Long> createUser(TestCreateIn testCreateIn) {
        Long result = testDao.createUser(testCreateIn);
        return new CommonHttpResult<>(result != null ? SUCCESS : Test_Insert_Fail, result);
    }

    public CommonHttpResult<List<TestOut>> getAllUsers() {
        return new CommonHttpResult<>(SUCCESS, testDao.getAllUsers());
    }

    public CommonHttpResult<TestOut> getUserById(Long id) {
        TestOut result = testDao.getUserById(id);
        return new CommonHttpResult<>(result != null ? SUCCESS : Test_Not_Found, result);
    }

    public CommonHttpResult<Long> updateUser(Long id, TestUpdateIn testUpdateIn) {
        Long result = testDao.updateUser(id, testUpdateIn);
        return new CommonHttpResult<>(result != null ? SUCCESS : Test_Update_Fail, result);
    }

    public CommonHttpResult<Long> deleteUser(Long id) {
        Long result = testDao.deleteUser(id);
        return new CommonHttpResult<>(result != null ? SUCCESS : Test_Delete_Fail, result);
    }

    public CommonHttpResult<TestLoginOut> login(TestLogin testLogin) {

        // 判斷資料庫使否有資訊
        TestOut testOut = testDao.getUserByEmailAndPassword(testLogin.getEmail(), testLogin.getPassword());
        if (testOut == null) {
            return new CommonHttpResult<>(Test_Find_Fail, null);
        }

        // 建立 JwtData 取得 Token
        JwtData jwtData = new JwtData();
        jwtData.setId(testOut.getId());
        jwtData.setEmail(testOut.getEmail());
        String token = JwtUtil.createToken(jwtData);

        // 回傳
        TestLoginOut result = new TestLoginOut();
        BeanUtils.copyProperties(testOut, result);
        result.setToken(token);

        return new CommonHttpResult<>(result != null ? SUCCESS : Test_Delete_Fail, result);
    }

}
