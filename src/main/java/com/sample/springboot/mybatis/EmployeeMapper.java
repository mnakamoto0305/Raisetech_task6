package com.sample.springboot.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sample.springboot.Employee;
import com.sample.springboot.UserSearchRequest;

@Mapper
public interface EmployeeMapper {

	//1件検索用メソッド
	public Employee findOne(UserSearchRequest userSearchRequest);
	public Employee findOne(Long id);

	//全件検索用メソッド
	public List<Employee> findAll();

	//1件登録用メソッド
	public boolean insert(Employee employee);

	//複数件登録用メソッド(バルクインサート)
	public int bulkInsert(@Param("listEmployee") List<Employee> listEmployee);

	//1件更新用メソッド
	public boolean updateOne(Employee employee);

	//1件削除用メソッド
	public boolean deleteOne(Long id);

}
