package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.springmvc.pojo.Admin;
import com.springmvc.pojo.Student;
import com.springmvc.service.AdminService;
import com.springmvc.service.MyService;
import com.springmvc.validator.AddValidation;
import com.springmvc.validator.DeleteValidation;
import com.springmvc.validator.SearchValidation;
import com.springmvc.validator.SignInValidator;
import com.springmvc.validator.UpdateValidation;

@Controller
@EnableWebMvc
@SessionAttributes("user")
public class MyController {
	@Qualifier("service")
	@Autowired
	private MyService service;

	@Qualifier("adminService")
	@Autowired
	private AdminService adservice;

	@ModelAttribute("admin")
	public Admin getAdmin() {
		return new Admin();
	}

	@ModelAttribute("student")
	public Student getStudent() {
		return new Student();
	}

	@GetMapping("/")
	public String verification(HttpSession session, Model model) {
		if (session.getAttribute("user") != null)
			return "index";
		else
			model.addAttribute("admin", new Admin());
		return "signIn";
	}

	@PostMapping("signIn")
	public String signIn(@ModelAttribute("admin") Admin admin, BindingResult result, HttpServletRequest request,
			HttpSession session) {
		new SignInValidator().validate(admin, result);
		if (result.hasErrors()) {
			request.setAttribute("status", "Field Required!!");
			return "signIn";
		} else {
			String status = adservice.signIn(admin);
			if (status.equals("success")) {
				session.setAttribute("user", admin.getUser());
				return "index";
			} else {
				request.setAttribute("status", status);
				return "signIn";
			}
		}
	}

	@GetMapping("/add")
	public String add() {
		return "add";
	}

	@GetMapping("/update")
	public String update() {
		return "update";
	}

	@GetMapping("/search")
	public String search() {
		return "search";
	}

	@GetMapping("/delete")
	public String delete() {
		return "delete";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute("student") Student student, HttpServletRequest request, BindingResult result) {
		new AddValidation().validate(student, result);
		if (result.hasErrors())
			request.setAttribute("status", "Field Required!!");
		else
			request.setAttribute("status", this.service.add(student));
		return "add";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute("student") Student student, HttpServletRequest request, BindingResult result) {
		new UpdateValidation().validate(student, result);
		if (result.hasErrors())
			request.setAttribute("status", "Field Required!!");
		else
			request.setAttribute("status", this.service.update(student));
		return "update";
	}

	@PostMapping("/delete")
	public String delete(@ModelAttribute("student") Student student, HttpServletRequest request, BindingResult result) {
		new DeleteValidation().validate(student, result);
		if (result.hasErrors())
			request.setAttribute("status", "Field Required");
		else
			request.setAttribute("status", this.service.delete(student.getSid()));
		return "delete";
	}

	@PostMapping("/search")
	public String search(@ModelAttribute("student") Student student, HttpServletRequest request, BindingResult result) {
		new SearchValidation().validate(student, result);
		if (result.hasErrors())
			request.setAttribute("status", "Field Required");
		else {
			request.setAttribute("status", "Not Found");
			request.setAttribute("studentBySid", this.service.search(student.getSid()));
		}
		return "search";
	}

	@GetMapping("/showAll")
	public String showAll(HttpServletRequest request) {
		request.setAttribute("studList", this.service.getAllStudent());
		return "showAll";
	}
}
