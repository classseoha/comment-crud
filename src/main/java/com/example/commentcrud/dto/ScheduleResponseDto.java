package com.example.commentcrud.dto;

import com.example.commentcrud.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private final Long id;

    private final String nickname;

    private final String title;

    private final String contents;

    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;

    public static ScheduleResponseDto from(Schedule schedule) {

        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getNickname(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt()
        );
    }
}
