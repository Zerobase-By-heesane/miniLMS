package com.zerobase.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CustomErrorCode {

    RESULT_NOT_FOUND(HttpStatus.BAD_REQUEST, "E001", "결과를 찾을 수 없습니다."),
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "E002", "잘못된 파라미터입니다."),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "E003", "잘못된 요청입니다.");

    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

}
