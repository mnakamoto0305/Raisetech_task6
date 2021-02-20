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
	public int bulkInsert(@Param("listEmployee") List<Employee> employees) {
		return employeeMapper.bulkInsert(employees);
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

	//複数検索メソッド
	@Transactional
	public List<Employee> findMany(UserSearchRequest userSearchRequest) {
		return employeeMapper.findMany(userSearchRequest);
	}

	//年齢検索用メソッド(◯歳以上)
	@Transactional
	public List<Employee> moreAge(UserSearchRequest userSearchRequest) {
		return employeeMapper.moreAge(userSearchRequest);
	}

	//性別検索用メソッド
	@Transactional
	public List<Employee> searchGender(UserSearchRequest userSearchRequest) {
		return employeeMapper.searchGender(userSearchRequest);
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

	//複数件更新用メソッド
	@Transactional
	public int bulkUpdate(@Param("listEmployee") List<Employee> employees) {
		return employeeMapper.bulkUpdate(employees);
	}

	//1件削除用メソッド
	@Transactional
	public boolean deleteOne(Long id) {
		return employeeMapper.deleteOne(id);
	}
}
