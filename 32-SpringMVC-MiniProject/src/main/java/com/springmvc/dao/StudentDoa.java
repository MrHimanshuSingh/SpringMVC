package com.springmvc.dao;

import java.util.List;

import com.springmvc.pojo.Student;

public interface StudentDoa {
	String add(Student student);

	String update(Student student);

	String delete(int sid);

	Student search(int sid);

	List<Student> getAllStudent();
}
