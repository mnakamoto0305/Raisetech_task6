package com.sample.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sample.springboot.Employee;
import com.sample.springboot.EmployeeList;
import com.sample.springboot.EmployeeService;
import com.sample.springboot.UserSearchRequest;

@Controller
public class HomeController {

	@Autowired
	EmployeeService employeeService;

	//メインページ
	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("title", "社員情報管理システム");
		return mav;
	}

	//新規登録用
	@GetMapping("/register")
	public ModelAndView register(@ModelAttribute Employee employee, ModelAndView mav) {
		mav.setViewName("register");
		mav.addObject("title", "新規登録");
		return mav;
	}

	@PostMapping("/register/id_employee")
	public ModelAndView addEmployee(@ModelAttribute Employee employee , ModelAndView mav) {
		employeeService.insert(employee);
		mav.setViewName("register");
		return new ModelAndView("redirect:/register");
	}

	//一括登録用
	@GetMapping("/registerMany")
	public ModelAndView registerMany(@ModelAttribute EmployeeList employeeList, ModelAndView mav) {
		List<Employee> listEmployee = new ArrayList<>();
		Employee employee = new Employee();
		listEmployee.add(employee);
		employeeList.setListEmployee(listEmployee);
		mav.setViewName("registerMany");
		mav.addObject("title", "新規登録");
		return mav;
	}

	//一括登録　追加ボタン
	@PostMapping(value = "/register/id_employees", params = "add")
	public ModelAndView addList(@ModelAttribute EmployeeList employeeList , ModelAndView mav) {
		employeeList.addList();
		mav.setViewName("registerMany");
		return mav;
	}

	//一括登録　登録ボタン
	@PostMapping(value = "/register/id_employees", params = "create")
	public ModelAndView addEmployees(@ModelAttribute EmployeeList employeeList , ModelAndView mav, HttpServletRequest request) {
		employeeService.bulkInsert(employeeList.getListEmployee());
		mav.setViewName("registerMany");
		return new ModelAndView("redirect:/registerMany");
	}

	//フォーム検索
	@GetMapping("/search")
	public ModelAndView search(@ModelAttribute Employee employee, ModelAndView mav) {
		mav.setViewName("search");
		return mav;
	}

	@PostMapping("/search/result")
	public ModelAndView form(@ModelAttribute UserSearchRequest userSearchRequest, ModelAndView mav) {
		Employee employee = employeeService.findOne(userSearchRequest);
		mav.setViewName("search");
		mav.addObject("employee", employee);
		return mav;
	}

	//全件検索結果表示
	@GetMapping("/searchAll")
	public ModelAndView searchAll(ModelAndView mav) {
		mav.setViewName("searchAll");
		mav.addObject("employees", employeeService.findAll());
		return mav;
	}
}
