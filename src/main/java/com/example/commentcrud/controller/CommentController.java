package com.example.commentcrud.controller;

import com.example.commentcrud.common.exception.enums.SuccessCode;
import com.example.commentcrud.common.response.ApiResponseDto;
import com.example.commentcrud.dto.CommentPostRequestDto;
import com.example.commentcrud.dto.CommentResponseDto;
import com.example.commentcrud.dto.CommentUpdateRequestDto;
import com.example.commentcrud.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<ApiResponseDto<CommentResponseDto>> createComment (
            @RequestBody CommentPostRequestDto requestDto,
            HttpServletRequest request
    ) {

        CommentResponseDto responseDto = commentService.createComment(requestDto);

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.COMMENT_CREATE_SUCCESS, responseDto, request.getRequestURI()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<CommentResponseDto>> findComment (
            @PathVariable Long id,
            HttpServletRequest request
    ) {

        CommentResponseDto responseDto = commentService.findComment(id);

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.COMMENT_GET_SUCCESS, responseDto, request.getRequestURI()));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponseDto<CommentResponseDto>> updateComment (
            @PathVariable Long id,
            @RequestBody CommentUpdateRequestDto requestDto,
            HttpServletRequest request
            ) {

        CommentResponseDto responseDto = commentService.updateComment(id, requestDto);

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.COMMENT_UPDATE_SUCCESS, responseDto, request.getRequestURI()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Void>> deleteComment (
            @PathVariable Long id,
            HttpServletRequest request
    ) {

        commentService.deleteComment(id);

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.COMMENT_DELETE_SUCCESS, null, request.getRequestURI()));
    }
}
