package com.project.erp.model.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class CustomerInquiry {
	private int inquiryNo;
	private int customerNo;
	private String title;
	private String content;
	private String status;
	private LocalDateTime createDate;
	private int assignedUserNo;
}
