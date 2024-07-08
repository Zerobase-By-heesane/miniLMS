package com.zerobase.user.controller;

import com.zerobase.loan.request.LoanRequestInputDto;
import com.zerobase.loan.request.LoanRequestResponseDto;
import com.zerobase.loan.request.UserInfoDto;
import com.zerobase.user.dto.UserInformationDto;
import com.zerobase.user.dto.UserInputDto;
import com.zerobase.user.dto.UserResponse;
import com.zerobase.user.service.UserService;
import io.lettuce.core.dynamic.annotation.Param;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fintech/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "유저 정보 조회 API", description = "유저 정보를 조회하는 API")
    @GetMapping("/private-info/{userKey}")
    public ResponseEntity<UserResponse> getUserInfo(
            @PathVariable
            @Parameter(description = "user key")
            String userKey) throws Exception {
        return ResponseEntity.ok(userService.getUserInfo(userKey));
    }

    @Operation(summary = "유저 정보 수신 API", description = "유저 정보를 받는 API")
    @PostMapping("/information")
    public ResponseEntity<UserInformationDto> requestLoan(
            @RequestBody
            @Parameter(description = "유저 정보")
            UserInputDto userInputDto) throws Exception {
        return ResponseEntity.ok(userService.createUser(userInputDto));
    }
}
