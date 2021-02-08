package com.sample.springboot.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.springboot.Employee;
import com.sample.springboot.UserSearchRequest;

@Mapper
public interface EmployeeMapper {

	//1件検索用メソッド
	public Employee findOne(UserSearchRequest userSearchRequest);

	//全件検索用メソッド
	public List<Employee> findAll();

	//登録用メソッド
	public boolean insert(Employee employee);
}
