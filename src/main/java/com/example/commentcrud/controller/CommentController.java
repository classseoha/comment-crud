package com.example.commentcrud.controller;

import com.example.commentcrud.common.response.ApiResponseDto;
import com.example.commentcrud.dto.CommentResponseDto;
import com.example.commentcrud.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<ApiResponseDto<CommentResponseDto>> createComment (

    )
}
