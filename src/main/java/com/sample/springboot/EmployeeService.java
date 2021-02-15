package com.sample.springboot;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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

	//一括登録メソッド
	@Transactional
	public int bulkInsert(@Param("listEmployee") List<Employee> listEmployee) {
		return employeeMapper.bulkInsert(listEmployee);
	}

	//1件検索用メソッド
	@Transactional
	public Employee findOne(UserSearchRequest userSearchRequest) {
		return employeeMapper.findOne(userSearchRequest);
	}

	@Transactional
	public Employee findOne(Long id) {
		return employeeMapper.findOne(id);
	}

	//全件検索用メソッド
	@Transactional
	public List<Employee> findAll() {
		return employeeMapper.findAll();
	}

	//1件更新用メソッド
	@Transactional
	public boolean updateOne(Employee employee) {
		return employeeMapper.updateOne(employee);
	}

	//1件削除用メソッド
	@Transactional
	public boolean deleteOne(Long id) {
		return employeeMapper.deleteOne(id);
	}
}
