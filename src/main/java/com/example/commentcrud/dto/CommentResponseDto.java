package com.example.commentcrud.dto;

import com.example.commentcrud.entity.Comment;
import com.example.commentcrud.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentResponseDto {

    private final Long id;

    private final String nickname;

    private final String contents;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public static CommentResponseDto from(Comment comment) {

        return new CommentResponseDto(
                comment.getId(),
                comment.getNickname(),
                comment.getContents(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );
    }
}
