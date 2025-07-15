package com.project.erp.model.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Schedule {
	private int scheduleNo;
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private String scheduleType;
    private int userNo;
}
