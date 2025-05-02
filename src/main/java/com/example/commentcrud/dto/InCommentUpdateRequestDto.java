package com.example.commentcrud.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class InCommentUpdateRequestDto {

    private final String contents;

    @JsonCreator
    public InCommentUpdateRequestDto(@JsonProperty("contents") String contents) {
        this.contents = contents;
    }
}
