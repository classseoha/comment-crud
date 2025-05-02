package com.example.commentcrud.common.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 400 - 잘못된 요청
    BAD_REQUEST(400,HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    MISSING_PARAMETER(400,HttpStatus.BAD_REQUEST, "필수 파라미터가 누락되었습니다."),
    INVALID_PARAMETER(400,HttpStatus.BAD_REQUEST, "유효하지 않은 요청 파라미터입니다."),
    NOT_CORRECT_VALUE(400,HttpStatus.BAD_REQUEST, "입력값이 올바르지 않습니다."),
    NO_VALUE_CHANGED(400, HttpStatus.BAD_REQUEST, "변경된 값이 없습니다."),

    // 405 - 지원하지 않는 메서드
    METHOD_NOT_ALLOWED(405,HttpStatus.METHOD_NOT_ALLOWED, "지원하지 않는 메소드입니다."),

    // 404 - Not Found
    NOT_FOUND(404,HttpStatus.NOT_FOUND, "존재하지 않는 API입니다."),
    CONTENTS_NOT_FOUND(404, HttpStatus.NOT_FOUND, "조회할 데이터가 없습니다"),

    // 500 - 서버 내부 오류
    INTERNAL_SERVER_ERROR(500,HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다."),
    TEST_ERROR(500,HttpStatus.INTERNAL_SERVER_ERROR, "테스트 에러입니다.");

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
