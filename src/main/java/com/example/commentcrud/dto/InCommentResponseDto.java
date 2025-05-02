package com.example.commentcrud.dto;

import com.example.commentcrud.entity.Comment;
import com.example.commentcrud.entity.InComment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class InCommentResponseDto {

    private final Long id;

    private final String nickname;

    private final String contents;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public static InCommentResponseDto from(InComment inComment) {

        return new InCommentResponseDto(
                inComment.getId(),
                inComment.getNickname(),
                inComment.getContents(),
                inComment.getCreatedAt(),
                inComment.getUpdatedAt()
        );
    }
}
