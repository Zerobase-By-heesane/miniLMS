package com.zerobase.loan.request;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/fintech/api/v1")
@Tag(name = "LoanRequest", description = "대출 심사 요청 API")
public class LoanRequestController {
    // 심사 요청 POST API
    private final LoanRequestService loanRequestService;

    @Operation(summary = "대출 심사 요청 API", description = "대출 심사 요청을 하는 API")
    @PostMapping("/request")
    ResponseEntity<LoanRequestResponseDto> requestLoan(
            @RequestBody
            @Parameter(description = "대출 심사 요청 정보")
            LoanRequestInputDto loanRequestInputDto) throws Exception {
        return ResponseEntity.ok(loanRequestService.loanRequestsMain(loanRequestInputDto));
    }

}
