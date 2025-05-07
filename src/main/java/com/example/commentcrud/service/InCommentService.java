package com.example.commentcrud.service;

import com.example.commentcrud.common.exception.base.CustomException;
import com.example.commentcrud.common.exception.enums.ErrorCode;
import com.example.commentcrud.dto.*;
import com.example.commentcrud.entity.Comment;
import com.example.commentcrud.entity.InComment;
import com.example.commentcrud.repository.CommentRepository;
import com.example.commentcrud.repository.InCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InCommentService {

    private final CommentRepository commentRepository;
    private final InCommentRepository inCommentRepository;

    public InCommentResponseDto createInComment(InCommentPostRequestDto requestDto) {

        Comment comment = commentRepository.findById(requestDto.getCommentId())
                .orElseThrow(() -> new CustomException((ErrorCode.CONTENTS_NOT_FOUND), "댓글을 찾을 수 없습니다."));

        InComment inComment = new InComment(requestDto.getNickname(), requestDto.getContents(), comment);

        InComment savedInComment = inCommentRepository.save(inComment);

        return InCommentResponseDto.from(savedInComment);
    }

    public InCommentDetailResponseDto findInComment(Long id) {

        InComment inComment = inCommentRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.CONTENTS_NOT_FOUND, "대댓글을 찾을 수 없습니다."));

        Comment comment = inComment.getComment(); // 연관된 상위 댓글 조회

        return InCommentDetailResponseDto.from(comment, inComment);
    }

    public InCommentResponseDto updateInComment(Long id, InCommentUpdateRequestDto requestDto) {

        InComment inComment = inCommentRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.CONTENTS_NOT_FOUND, "대댓글을 찾을 수 없습니다."));

        Boolean isUpdated = false;

        if (requestDto.getContents() != null && !requestDto.getContents().isBlank()) {

            inComment.updateInComment(requestDto);
            isUpdated = true;
        }

        if (!isUpdated) {

            throw new CustomException(ErrorCode.NO_VALUE_CHANGED, "변경된 값이 없습니다.");
        }

        return InCommentResponseDto.from(inComment);
    }

    public void deleteInComment(Long id) {

        InComment inComment = inCommentRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.CONTENTS_NOT_FOUND, "대댓글을 찾을 수 없습니다."));

        inCommentRepository.delete(inComment);
    }
}
