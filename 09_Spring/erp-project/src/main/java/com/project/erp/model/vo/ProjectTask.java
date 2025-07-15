package com.project.erp.model.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class ProjectTask {
	private int taskNo;
	private int proNo;
	private String taskName;
	private String status;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private int assignedUserNo;
}
