package com.hao.Gradle_JWT_Init.dto.in;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TestLogin {

    @Schema(description = "信箱", example = "email@example.com")
    String email;
    @Schema(description = "密碼", example = "password")
    String password;

}
