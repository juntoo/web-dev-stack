package com.kh.mybatis.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// DTO(Data Transfer Object) : 데이터 전송 객체
@Getter @Setter @ToString
public class SearchDTO {
	private String select;
	private String keyword;
}
