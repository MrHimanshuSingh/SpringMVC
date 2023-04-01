package com.springmvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springmvc.pojo.Student;

public class SearchValidation implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		if(((Student)target).getSid()==0)
			errors.rejectValue("sid","errors.required",new Object[] {"Sid"},"Sid Required");
	}
}
