package com.sample.springboot;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeList {

	private List<Employee> listEmployee;

	public void addList() {
		Employee employee = new Employee();
		listEmployee.add(employee);
	}
}
