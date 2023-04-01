package com.springmvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springmvc.pojo.Student;

public class AddValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Student student = (Student) target;
		if (student.getSid() == 0) {
			errors.rejectValue("sid", "errors.required", new Object[] { "Sid" }, "Sid Mandatory.");
		}
		if (student.getName() == null || student.getName().trim().equals("")) {
			errors.rejectValue("name", "errors.required", new Object[] { "Name" }, "Name Mandatory.");
		}
		if (student.getSurname() == null || student.getSurname().trim().equals("")) {
			errors.rejectValue("surname", "errors.required", new Object[] { "Surname" }, "Surname Mandatory.");
		}
		if (student.getEmail() == null || student.getEmail().trim().equals("")) {
			errors.rejectValue("email", "errors.required", new Object[] { "Email" }, "Email Mandatory.");
		}
	}

}
