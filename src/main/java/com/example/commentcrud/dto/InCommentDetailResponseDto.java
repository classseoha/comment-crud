package com.example.commentcrud.dto;

import com.example.commentcrud.entity.Comment;
import com.example.commentcrud.entity.InComment;
import com.example.commentcrud.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class InCommentDetailResponseDto {

    private final CommentResponseDto comment;

    private final InCommentResponseDto inComment;

    public static InCommentDetailResponseDto from (Comment comment,  InComment inComment) {

        return new InCommentDetailResponseDto(
                CommentResponseDto.from(comment),
                InCommentResponseDto.from(inComment)
        );
    }
}
