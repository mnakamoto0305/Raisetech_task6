package com.sample.springboot;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserSearchRequest implements Serializable{

	private Long id;

	private String name;

	private Integer age;

	private String gender;

}
