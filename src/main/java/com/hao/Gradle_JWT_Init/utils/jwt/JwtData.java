package com.hao.Gradle_JWT_Init.utils.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtData {

    private Long id;
    private String email;

}
