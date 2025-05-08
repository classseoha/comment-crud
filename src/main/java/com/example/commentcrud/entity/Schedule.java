package com.example.commentcrud.entity;

import com.example.commentcrud.common.entity.BaseEntity;
import com.example.commentcrud.dto.ScheduleUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "schedule")
@NoArgsConstructor
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "longtext")
    private String contents;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public Schedule(String nickname, String title, String contents) {
        this.nickname = nickname;
        this.title = title;
        this.contents = contents;
    }

    public boolean updateSchedule(ScheduleUpdateRequestDto requestDto) {

        boolean updated = false;

        if(requestDto.getTitle() != null && !requestDto.getTitle().isBlank()) {
            this.title = requestDto.getTitle();
            updated = true;
        }

        if(requestDto.getContents() != null && !requestDto.getContents().isBlank()) {
            this.contents = requestDto.getContents();
            updated = true;
        }

        return updated;
    }
}
