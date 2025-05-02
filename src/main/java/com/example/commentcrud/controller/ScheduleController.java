package com.example.commentcrud.controller;

import com.example.commentcrud.common.exception.enums.SuccessCode;
import com.example.commentcrud.common.response.ApiResponseDto;
import com.example.commentcrud.dto.*;
import com.example.commentcrud.service.ScheduleService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ApiResponseDto<ScheduleResponseDto>> createSchedule (
            @RequestBody SchedulePostRequestDto requestDto,
            HttpServletRequest request) {

        ScheduleResponseDto responseDto = scheduleService.createSchedule(requestDto);

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.SCHEDULE_CREATE_SUCCESS, responseDto, request.getRequestURI()));
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<ScheduleAllGetResponseDto>>> findSchedules (HttpServletRequest request) {

        List<ScheduleAllGetResponseDto> responseDtos = scheduleService.findSchedules();

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.SCHEDULE_GET_SUCCESS, responseDtos, request.getRequestURI()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<ScheduleDetailResponseDto>> getSchedule (
            @PathVariable Long id,
            HttpServletRequest request
    ) {

        ScheduleDetailResponseDto responseDto = scheduleService.getSchedule(id);

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.SCHEDULE_GET_SUCCESS, responseDto, request.getRequestURI()));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponseDto<ScheduleResponseDto>> updateSchedule (
            @PathVariable Long id,
            @RequestBody ScheduleUpdateRequestDto requestDto,
            HttpServletRequest request
            ) {

        ScheduleResponseDto responseDto = scheduleService.updateSchedule(id, requestDto);

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.SCHEDULE_UPDATE_SUCCESS, responseDto, request.getRequestURI()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Void>> deleteSchedule (
            @PathVariable Long id,
            HttpServletRequest request
    ) {

        scheduleService.deleteSchedule(id);

        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.SCHEDULE_DELETE_SUCCESS, null, request.getRequestURI()));
    }
}
