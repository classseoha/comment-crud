package com.example.commentcrud.entity;

import com.example.commentcrud.common.entity.BaseEntity;
import com.example.commentcrud.dto.CommentUpdateRequestDto;
import com.example.commentcrud.dto.InCommentUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "in_comment")
@NoArgsConstructor
public class InComment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, columnDefinition = "longtext")
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;

    public InComment(String nickname, String contents, Comment comment) {
        this.nickname = nickname;
        this.contents = contents;
        this.comment = comment;
    }

    public void updateInComment(InCommentUpdateRequestDto requestDto) {

        if(requestDto.getContents() != null && !requestDto.getContents().isBlank()) {
            this.contents = requestDto.getContents();
        }
    }
}
