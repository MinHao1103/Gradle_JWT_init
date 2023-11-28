package com.hao.Gradle_JWT_Init.controller;

import com.hao.Gradle_JWT_Init.dto.in.TestCreateIn;
import com.hao.Gradle_JWT_Init.dto.in.TestUpdateIn;
import com.hao.Gradle_JWT_Init.dto.out.TestOut;
import com.hao.Gradle_JWT_Init.service.TestService;
import com.hao.Gradle_JWT_Init.utils.httpResult.CommonHttpResult;
import com.hao.Gradle_JWT_Init.utils.httpResult.ErrorHttpResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "測試")
@RestController
@RequestMapping(path = "/v1/test")
@SecurityScheme(name = "Authorization", in = SecuritySchemeIn.HEADER, type = SecuritySchemeType.APIKEY, description = "JWT format")
public class TestController {

    @Autowired
    private TestService testService;

    @Operation(summary = "Create a new user", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CommonHttpResult.class))),
            @ApiResponse(responseCode = "503", content = @Content(schema = @Schema(implementation = ErrorHttpResult.class)))
    }, security = @SecurityRequirement(name = "Authorization"))
    @PostMapping
    public CommonHttpResult<Long> createUser(@RequestBody TestCreateIn testCreateIn) {
        return testService.createUser(testCreateIn);
    }

    @Operation(summary = "Get all users", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CommonHttpResult.class))),
            @ApiResponse(responseCode = "503", content = @Content(schema = @Schema(implementation = ErrorHttpResult.class)))
    }, security = @SecurityRequirement(name = "Authorization"))
    @GetMapping
    public CommonHttpResult<List<TestOut>> getAllUsers() {
        return testService.getAllUsers();
    }

    @Operation(summary = "Get user by ID", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CommonHttpResult.class))),
            @ApiResponse(responseCode = "503", content = @Content(schema = @Schema(implementation = ErrorHttpResult.class)))
    }, security = @SecurityRequirement(name = "Authorization"))
    @GetMapping("/{id}")
    public CommonHttpResult<TestOut> getUserById(@PathVariable Long id) {
        return testService.getUserById(id);
    }

    @Operation(summary = "Update user by ID", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CommonHttpResult.class))),
            @ApiResponse(responseCode = "503", content = @Content(schema = @Schema(implementation = ErrorHttpResult.class)))
    }, security = @SecurityRequirement(name = "Authorization"))
    @PutMapping("/{id}")
    public CommonHttpResult<Long> updateUser(@PathVariable Long id, @RequestBody TestUpdateIn testUpdateIn) {
        return testService.updateUser(id, testUpdateIn);
    }

    @Operation(summary = "Delete user by ID", responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CommonHttpResult.class))),
            @ApiResponse(responseCode = "503", content = @Content(schema = @Schema(implementation = ErrorHttpResult.class)))
    }, security = @SecurityRequirement(name = "Authorization"))
    @DeleteMapping("/{id}")
    public CommonHttpResult<Long> deleteUser(@PathVariable Long id) {
        return testService.deleteUser(id);
    }

}
