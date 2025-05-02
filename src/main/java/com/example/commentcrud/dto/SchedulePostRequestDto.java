package com.example.commentcrud.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class SchedulePostRequestDto {

    private final String nickname;

    private final String title;

    private final String contents;

    @JsonCreator
    public SchedulePostRequestDto(@JsonProperty("nickname")String nickname,
                                  @JsonProperty("title")String title,
                                  @JsonProperty("contents")String contents) {
        this.nickname = nickname;
        this.title = title;
        this.contents = contents;
    }
}
