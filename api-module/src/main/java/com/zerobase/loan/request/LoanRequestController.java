package com.zerobase.loan.request;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/fintech/api/v1")
public class LoanRequestController {
    // 심사 요청 POST API
    private final LoanRequestService loanRequestService;

    @PostMapping("/request")
    ResponseEntity<LoanRequestResponseDto> requestLoan(@RequestBody LoanRequestInputDto loanRequestInputDto) throws Exception {
        return ResponseEntity.ok(loanRequestService.loanRequestsMain(loanRequestInputDto));
    }

}
