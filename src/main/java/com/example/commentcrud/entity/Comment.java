package com.example.commentcrud.entity;

import com.example.commentcrud.common.entity.BaseEntity;
import com.example.commentcrud.dto.CommentUpdateRequestDto;
import com.example.commentcrud.dto.ScheduleUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comment")
@Getter
@NoArgsConstructor
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, columnDefinition = "longtext")
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InComment> inComments = new ArrayList<>();

    public Comment(String nickname, String contents, Schedule schedule) {
        this.nickname = nickname;
        this.contents = contents;
        this.schedule = schedule;
    }

    public void updateComment(CommentUpdateRequestDto requestDto) {

        if(requestDto.getContents() != null && !requestDto.getContents().isBlank()) {
            this.contents = requestDto.getContents();
        }
    }
}
