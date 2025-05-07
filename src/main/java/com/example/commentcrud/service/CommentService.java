package com.example.commentcrud.service;

import com.example.commentcrud.common.exception.base.CustomException;
import com.example.commentcrud.common.exception.enums.ErrorCode;
import com.example.commentcrud.dto.CommentPostRequestDto;
import com.example.commentcrud.dto.CommentResponseDto;
import com.example.commentcrud.dto.CommentUpdateRequestDto;
import com.example.commentcrud.entity.Comment;
import com.example.commentcrud.entity.Schedule;
import com.example.commentcrud.repository.CommentRepository;
import com.example.commentcrud.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    public CommentResponseDto createComment(CommentPostRequestDto requestDto) {

        // 일정 조회
        Schedule schedule = scheduleRepository.findById(requestDto.getScheduleId())
                .orElseThrow(() -> new CustomException(ErrorCode.CONTENTS_NOT_FOUND, "일정을 찾을 수 없습니다."));

        // 댓글 생성 시 일정 설정
        Comment comment = new Comment(requestDto.getNickname(), requestDto.getContents(), schedule);

        Comment savedComment = commentRepository.save(comment);

        return CommentResponseDto.from(savedComment);
    }

    public CommentResponseDto findComment(Long id) {

        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.CONTENTS_NOT_FOUND, "댓글을 찾을 수 없습니다."));

        return CommentResponseDto.from(comment);
        }
    public CommentResponseDto updateComment(Long id, CommentUpdateRequestDto requestDto) {

        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.CONTENTS_NOT_FOUND, "댓글을 찾을 수 없습니다."));

        Boolean isUpdated = false;

        if (requestDto.getContents() != null && !requestDto.getContents().isBlank()) {

            comment.updateComment(requestDto);
            isUpdated = true;
        }

        if (!isUpdated) {

            throw new CustomException(ErrorCode.NO_VALUE_CHANGED, "변경된 값이 없습니다.");
        }

        return CommentResponseDto.from(comment);
    }

    public void deleteComment(Long id) {

        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.CONTENTS_NOT_FOUND, "댓글을 찾을 수 없습니다."));

        commentRepository.delete(comment);
    }
}


