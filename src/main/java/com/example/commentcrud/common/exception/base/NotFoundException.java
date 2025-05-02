package com.example.commentcrud.common.exception.base;

import com.example.commentcrud.common.exception.enums.ErrorCode;

public class NotFoundException extends CustomException {
    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
