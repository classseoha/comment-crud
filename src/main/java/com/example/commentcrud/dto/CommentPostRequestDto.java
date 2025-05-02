package com.example.commentcrud.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CommentPostRequestDto {

    private final String nickname;

    private final String contents;

    @JsonCreator
    public CommentPostRequestDto(@JsonProperty("nickname") String nickname,
                                 @JsonProperty("contents") String contents) {
        this.nickname = nickname;
        this.contents = contents;
    }
}
