package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springmvc.dao.StudentDoa;
import com.springmvc.pojo.Student;

@Service("service")
public class MyServiceImpl implements MyService {
	@Qualifier("component")
	@Autowired
	StudentDoa dao;

	@Override
	public String add(Student student) {
		return this.dao.add(student);
	}

	@Override
	public String update(Student student) {
		return this.dao.update(student);
	}

	@Override
	public String delete(int sid) {
		return this.dao.delete(sid);
	}

	@Override
	public Student search(int sid) {
		return this.dao.search(sid);
	}

	@Override
	public List<Student> getAllStudent() {
		return this.dao.getAllStudent();
	}
	
}
