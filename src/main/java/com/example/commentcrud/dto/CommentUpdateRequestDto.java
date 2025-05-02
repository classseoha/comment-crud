package com.example.commentcrud.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CommentUpdateRequestDto {

    private final String contents;

    @JsonCreator
    public CommentUpdateRequestDto(@JsonProperty("contents") String contents) {
        this.contents = contents;
    }
}
