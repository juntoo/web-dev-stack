package com.kh.polymorphism.controller;

import com.kh.polymorphism.model.Employee;
import com.kh.polymorphism.model.Engineer;

public class EmployeeController {
	
	public Employee findEmployee(Employee[] emp, String name) {
		Employee findEmployee = null;
		for(Employee employee : emp) {
			if(employee.getName().equals(name)) {
				System.out.println(employee);
				findEmployee = employee;
			}
		}
		return findEmployee;
	}
	
	public int getAnnualSalary(Employee findEmployee) {
		if(findEmployee == null) return -1;
		if(findEmployee instanceof Engineer) {
			Engineer engineer = (Engineer)findEmployee;
			return engineer.getSalary() * 12 + engineer.getBonus();
		}
		return findEmployee.getSalary() * 12;
	}
	
	public int totalSalary(Employee[] emp) {
		int total = 0;
		for(Employee employee : emp) {
			total += employee.getSalary();
		}
		return total;
	}
}
