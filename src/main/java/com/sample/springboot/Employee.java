package com.sample.springboot;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class Employee {

	private Long id;

	@NotEmpty
	private String name;

	@NotNull
    @Range(min=0, max=100)
	private Integer age;

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
    @Pattern(regexp="[\\w]+")
	@Min(5)
	private String password;


	private String gender = "male";

}
