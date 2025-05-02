package com.example.commentcrud.dto;

import com.example.commentcrud.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleAllGetResponseDto {

    private final Long id;

    private final String nickname;

    private final String title;

    private final String contents;

    private final int commentCount;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public static ScheduleAllGetResponseDto from(Schedule schedule, int commentCount) {

        return new ScheduleAllGetResponseDto(
                schedule.getId(),
                schedule.getNickname(),
                schedule.getTitle(),
                schedule.getContents(),
                commentCount,
                schedule.getCreatedAt(),
                schedule.getUpdatedAt()
        );
    }
}
