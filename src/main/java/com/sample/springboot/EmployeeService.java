package com.sample.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.springboot.mybatis.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	//新規登録メソッド
	@Transactional
	public boolean insert(Employee employee) {
		return employeeMapper.insert(employee);
	}

	//1件検索用メソッド
	@Transactional
	public Employee findOne(UserSearchRequest userSearchRequest) {
		return employeeMapper.findOne(userSearchRequest);
	}

	//全件検索用メソッド
	@Transactional
	public List<Employee> findAll() {
		return employeeMapper.findAll();
	}
}
