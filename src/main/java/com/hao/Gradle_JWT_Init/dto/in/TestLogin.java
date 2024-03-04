package com.hao.Gradle_JWT_Init.dto.in;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestLogin {

    @Schema(description = "信箱", example = "email@example.com")
    String email;
    @Schema(description = "密碼", example = "password")
    String password;

}
