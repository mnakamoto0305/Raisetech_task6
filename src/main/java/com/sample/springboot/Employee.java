package com.sample.springboot;

import lombok.Data;

@Data
public class Employee {

	private Long id;
	private String name;
	private Integer age;
	private String email;
	private String password;
	private String gender = "male";

}
