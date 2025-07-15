package com.project.erp.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class Customer {
	private int customerNo;
    private String name;
    private String phone;
    private String email;
    private String vipLevel;
    private int managerNo;
}
