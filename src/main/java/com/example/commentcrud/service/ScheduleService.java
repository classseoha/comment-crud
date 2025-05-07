package com.example.commentcrud.service;

import com.example.commentcrud.common.exception.base.CustomException;
import com.example.commentcrud.common.exception.enums.ErrorCode;
import com.example.commentcrud.dto.*;
import com.example.commentcrud.entity.Comment;
import com.example.commentcrud.entity.Schedule;
import com.example.commentcrud.repository.CommentRepository;
import com.example.commentcrud.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.commentcrud.common.exception.enums.ErrorCode.CONTENTS_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    public ScheduleResponseDto createSchedule(SchedulePostRequestDto requestDto) {

        Schedule schedule = new Schedule(requestDto.getNickname(), requestDto.getTitle(), requestDto.getContents());
        
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return ScheduleResponseDto.from(schedule);
    }

    public List<ScheduleAllGetResponseDto> findSchedules() {

        List<Schedule> schedules = scheduleRepository.findAll();

        return schedules.stream()
                .map(schedule -> {
                    int commentCount = commentRepository.countByScheduleId(schedule.getId());
                    return ScheduleAllGetResponseDto.from(schedule, commentCount);
                })
                .collect(Collectors.toList());
    }

    public ScheduleDetailResponseDto getSchedule(Long id) {

        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.CONTENTS_NOT_FOUND, "일정을 찾을 수 없습니다."));

        List<Comment> comments = commentRepository.findByScheduleIdOrderByCreatedAtAsc(id);

        return ScheduleDetailResponseDto.from(schedule, comments);
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleUpdateRequestDto requestDto) {

        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.CONTENTS_NOT_FOUND, "일정을 찾을 수 없습니다."));

        boolean isUpdated = schedule.updateSchedule(requestDto);

        if (!isUpdated) {

            throw new CustomException(ErrorCode.NO_VALUE_CHANGED, "변경된 값이 없습니다.");
        }

        return ScheduleResponseDto.from(schedule);
    }

    @Transactional
    public void deleteSchedule(Long id) {

        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.CONTENTS_NOT_FOUND, "일정을 찾을 수 없습니다."));

        scheduleRepository.delete(schedule);
    }
}
