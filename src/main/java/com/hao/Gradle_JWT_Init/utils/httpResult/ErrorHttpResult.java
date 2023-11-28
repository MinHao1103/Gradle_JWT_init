package com.hao.Gradle_JWT_Init.utils.httpResult;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorHttpResult<T> {

    @Schema(description = "回傳代碼")
    String result;
    @Schema(description = "資料物件")
    T data;

}
