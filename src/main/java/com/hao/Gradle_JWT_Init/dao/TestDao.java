package com.hao.Gradle_JWT_Init.dao;

import com.hao.Gradle_JWT_Init.dto.in.TestCreateIn;
import com.hao.Gradle_JWT_Init.dto.in.TestUpdateIn;
import com.hao.Gradle_JWT_Init.dto.out.TestOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TestDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Long createUser(TestCreateIn in) {
        try {
            String sql = "INSERT INTO testTable (email, password) VALUES (:email, :password)";
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("email", in.getEmail());
            parameters.addValue("password", in.getPassword());

            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update(sql, parameters, keyHolder, new String[]{"id"});

            Number generatedId = keyHolder.getKey();
            if (generatedId != null) {
                return generatedId.longValue();  // 將 Number 轉換為 Long
            } else {
                throw new RuntimeException("Failed to retrieve generated ID after insertion");
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create user", e);
        }
    }

    public List<TestOut> getAllUsers() {
        String sql = "SELECT * FROM testTable";
        return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TestOut.class));
    }

    public TestOut getUserById(Long id) {
        String sql = "SELECT * FROM testTable WHERE id = :id";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", id);
        return namedParameterJdbcTemplate.queryForObject(sql, parameters, new BeanPropertyRowMapper<>(TestOut.class));
    }

    public Long updateUser(Long id, TestUpdateIn in) {
        String sql = "UPDATE testTable SET password = :password WHERE id = :id";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", id);
        parameters.addValue("password", in.getPassword());
        int result = namedParameterJdbcTemplate.update(sql, parameters);
        return (result == 1) ? id : null;
    }

    public Long deleteUser(Long id) {
        String sql = "DELETE FROM testTable WHERE id = :id";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", id);
        int result = namedParameterJdbcTemplate.update(sql, parameters);
        return (result == 1) ? id : null;
    }

}