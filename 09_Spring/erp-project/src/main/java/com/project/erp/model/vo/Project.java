package com.project.erp.model.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Project {
	private int proNo;
	private String proName;
	private String destination;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;
	private int managerNo;
}
