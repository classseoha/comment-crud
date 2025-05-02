package com.example.commentcrud.entity;

import com.example.commentcrud.common.entity.BaseEntity;
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
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public InComment(String nickname, String contents, Comment comment) {
        this.nickname = nickname;
        this.contents = contents;
        this.comment = comment;
    }
}
