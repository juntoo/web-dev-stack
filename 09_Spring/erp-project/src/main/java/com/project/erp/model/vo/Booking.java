package com.project.erp.model.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Booking {
	private int bookingNo;
    private int customerNo;
    private int adultCount;
    private int childCount;
    private int infantCount;
    private int totalAmount;
    private String paymentStatus;
    private String bookingStatus;
    private LocalDateTime createDate;
}
