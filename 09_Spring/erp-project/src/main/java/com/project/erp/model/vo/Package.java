package com.project.erp.model.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Package {
	private int packageNo;
    private String packageName;
    private String destination;
    private int durationDays;
    private int priceAdult;
    private int priceChild;
    private int priceInfant;
    private int minParticipants;
    private int maxParticipants;
    private boolean includeFlight;
    private boolean includeHotel;
    private boolean includeMeal;
    private String packageDesc;
    private String status;
    private LocalDateTime createDate;
    private int proNo;
}
