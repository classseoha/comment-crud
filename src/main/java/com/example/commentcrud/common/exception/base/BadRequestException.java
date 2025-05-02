package com.example.commentcrud.common.exception.base;

import com.example.commentcrud.common.exception.enums.ErrorCode;

public class BadRequestException extends CustomException {
    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }
}
