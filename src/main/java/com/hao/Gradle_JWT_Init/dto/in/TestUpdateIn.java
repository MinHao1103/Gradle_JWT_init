package com.hao.Gradle_JWT_Init.dto.in;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TestUpdateIn {

    @Schema(description = "密碼", example = "password")
    String password;

}
