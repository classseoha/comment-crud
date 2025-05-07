package com.example.commentcrud.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CommentPostRequestDto {

    private Long scheduleId; // 일정 ID 추가

    private final String nickname;

    private final String contents;

    @JsonCreator
    public CommentPostRequestDto(@JsonProperty("scheduleId") Long scheduleId,
                                 @JsonProperty("nickname") String nickname,
                                 @JsonProperty("contents") String contents) {
        this.scheduleId = scheduleId;
        this.nickname = nickname;
        this.contents = contents;
    }
}
