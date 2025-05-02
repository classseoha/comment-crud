package com.example.commentcrud.dto;

import com.example.commentcrud.entity.Comment;
import com.example.commentcrud.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class ScheduleDetailResponseDto {

    private final Long id;

    private final String nickname;

    private final String title;

    private final String contents;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    private final List<CommentResponseDto> comments;

    public static ScheduleDetailResponseDto from (Schedule schedule, List<Comment> commentList) {
        List<CommentResponseDto> comments = commentList.stream()
                .map(CommentResponseDto::from)
                .collect(Collectors.toList());

        return new ScheduleDetailResponseDto(
                schedule.getId(),
                schedule.getNickname(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt(),
                comments
        );
    }
}
