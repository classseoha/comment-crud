package com.example.commentcrud.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {

    private final String title;

    private final String contents;

    @JsonCreator
    public ScheduleUpdateRequestDto(@JsonProperty("title")String title,
                                    @JsonProperty("contents")String contents) {
        this.title = title;
        this.contents = contents;
    }
}
