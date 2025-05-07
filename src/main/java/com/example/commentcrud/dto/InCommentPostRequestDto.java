package com.example.commentcrud.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class InCommentPostRequestDto {

    private final Long commentId; // 어떤 댓글에 대한 대댓글인지

    private final String nickname;

    private final String contents;

    @JsonCreator
    public InCommentPostRequestDto(@JsonProperty("commentId") Long commentId,
                                   @JsonProperty("nickname") String nickname,
                                   @JsonProperty("contents") String contents) {
        this.commentId = commentId;
        this.nickname = nickname;
        this.contents = contents;
    }
}
