package com.example.commentcrud.common.exception.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessCode {

    SCHEDULE_CREATE_SUCCESS(201, HttpStatus.CREATED,"일정이 생성되었습니다."),
    SCHEDULE_GET_SUCCESS(200, HttpStatus.OK, "일정을 조회하였습니다."),
    SCHEDULE_UPDATE_SUCCESS(200, HttpStatus.OK,"일정이 수정되었습니다."),
    SCHEDULE_DELETE_SUCCESS(200, HttpStatus.OK,"일정이 삭제되었습니다."),

    COMMENT_CREATE_SUCCESS(201, HttpStatus.CREATED,"댓글이 생성되었습니다."),
    COMMENT_GET_SUCCESS(200, HttpStatus.OK, "댓글을 조회하였습니다."),
    COMMENT_UPDATE_SUCCESS(200, HttpStatus.OK,"댓글이 수정되었습니다."),
    COMMENT_DELETE_SUCCESS(200, HttpStatus.OK,"댓글이 삭제되었습니다."),

    INCOMMENT_CREATE_SUCCESS(201, HttpStatus.CREATED,"대댓글이 생성되었습니다."),
    INCOMMENT_GET_SUCCESS(200, HttpStatus.OK, "대댓글을 조회하였습니다."),
    INCOMMENT_UPDATE_SUCCESS(200, HttpStatus.OK,"대댓글이 수정되었습니다."),
    INCOMMENT_DELETE_SUCCESS(200, HttpStatus.OK,"대댓글이 삭제되었습니다.");

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;

    SuccessCode(Integer code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}