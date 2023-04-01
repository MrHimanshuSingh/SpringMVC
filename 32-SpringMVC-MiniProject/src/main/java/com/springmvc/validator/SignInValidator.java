package com.springmvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springmvc.pojo.Admin;
import com.springmvc.pojo.Student;

public class SignInValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Admin admin = (Admin) target;
		if (admin.getUser() == null || admin.getUser().trim().equals("")) {
			errors.rejectValue("user", "errors.required", new Object[] {}, "Username is required");
		}
		if (admin.getPassword() == null || admin.getPassword().trim().equals("")) {
			errors.rejectValue("password", "errors.required", new Object[] {}, "Password is required");
		}
	}
}
