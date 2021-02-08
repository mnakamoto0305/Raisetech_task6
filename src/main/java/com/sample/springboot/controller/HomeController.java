package com.sample.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sample.springboot.Employee;
import com.sample.springboot.EmployeeService;
import com.sample.springboot.UserSearchRequest;

@Controller
public class HomeController {

	@Autowired
	EmployeeService employeeService;

	//メインページ
//	@GetMapping("/")
//	public ModelAndView index(ModelAndView mav) {
//		mav.setViewName("index");
//		mav.addObject("title", "社員情報管理システム");
//		return mav;
//	}
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("title", "社員情報管理システム");
		return mav;
	}

	//新規登録用
	@GetMapping("/register")
	public ModelAndView register(ModelAndView mav) {
		mav.setViewName("register");
		mav.addObject("title", "新規登録");
		return mav;
	}

	@PostMapping("/register/id_employee")
	public ModelAndView addEmployee(@ModelAttribute Employee employee , ModelAndView mav) {
		employeeService.insert(employee);
		mav.setViewName("register");
		return mav;
	}

//	//検索結果表示
//	@GetMapping("/search/{id}")
//	public ModelAndView search(@ModelAttribute UserSearchRequest userSearchRequest, ModelAndView mav) {
//		mav.setViewName("search");
//		mav.addObject("employee", employeeService.findOne(id));
//		return mav;
//	}

	//フォーム検索
	@PostMapping("/search/result")
	public ModelAndView form(@ModelAttribute UserSearchRequest userSearchRequest, ModelAndView mav) {
		Employee employee = employeeService.findOne(userSearchRequest);
		mav.setViewName("index");
		mav.addObject("employee", employee);
		return mav;
//		return new ModelAndView("redirect:/search/{id}");
	}

	//全件検索結果表示
	@GetMapping("/search")
	public ModelAndView searchAll(ModelAndView mav) {
		mav.setViewName("searchAll");
		mav.addObject("employees", employeeService.findAll());
		return mav;
	}
}
