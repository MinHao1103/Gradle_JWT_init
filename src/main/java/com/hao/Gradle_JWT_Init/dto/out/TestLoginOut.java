package com.hao.Gradle_JWT_Init.dto.out;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class TestLoginOut {

    @Schema(description = "token")
    String token;
    @Schema(description = "編號", example = "1")
    Long id;
    @Schema(description = "信箱", example = "email@example.com")
    String email;
    @Schema(description = "建立時間", example = "2023-11-18T12:30:00")
    Timestamp createdDate;

}
