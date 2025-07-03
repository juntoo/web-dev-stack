package model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// VO(Value Object)
@NoArgsConstructor @AllArgsConstructor @Data
public class Person {
	private int id;
	private String name;
	private int age;
	private String addr;
}
