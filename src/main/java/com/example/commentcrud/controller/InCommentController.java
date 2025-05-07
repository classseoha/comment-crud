package com.example.commentcrud.controller;

import com.example.commentcrud.common.exception.enums.SuccessCode;
import com.example.commentcrud.common.response.ApiResponseDto;
import com.example.commentcrud.dto.InCommentDetailResponseDto;
import com.example.commentcrud.dto.InCommentPostRequestDto;
import com.example.commentcrud.dto.InCommentResponseDto;
import com.example.commentcrud.dto.InCommentUpdateRequestDto;
import com.example.commentcrud.repository.InCommentRepository;
import com.example.commentcrud.service.InCommentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/incomments")
@RequiredArgsConstructor
public class InCommentController {

    private final InCommentService inCommentService;

    @PostMapping
    public ResponseEntity<ApiResponseDto<InCommentResponseDto>> createInComment (
            @RequestBody InCommentPostRequestDto requestDto,
            HttpServletRequest request
            ) {

        InCommentResponseDto responseDto = inCommentService.createInComment(requestDto);

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.INCOMMENT_CREATE_SUCCESS, responseDto, request.getRequestURI()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<InCommentDetailResponseDto>> findInComment (
            @PathVariable Long id,
            HttpServletRequest request
    ) {

        InCommentDetailResponseDto responseDto = inCommentService.findInComment(id);

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.INCOMMENT_GET_SUCCESS, responseDto, request.getRequestURI()));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponseDto<InCommentResponseDto>> updateInComment (
            @PathVariable Long id,
            @RequestBody InCommentUpdateRequestDto requestDto,
            HttpServletRequest request
            ) {

        InCommentResponseDto responseDto = inCommentService.updateInComment(id, requestDto);

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.INCOMMENT_UPDATE_SUCCESS, responseDto, request.getRequestURI()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Void>> deleteInComment (
            @PathVariable Long id,
            HttpServletRequest request
    ) {

        inCommentService.deleteInComment(id);

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.INCOMMENT_DELETE_SUCCESS, null, request.getRequestURI()));
    }

}
