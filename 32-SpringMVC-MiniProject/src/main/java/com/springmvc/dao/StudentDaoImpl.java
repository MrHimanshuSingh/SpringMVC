package com.springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springmvc.pojo.Student;

@Component("component")
public class StudentDaoImpl implements StudentDoa {
	@Qualifier("template")
	@Autowired
	JdbcTemplate template;

	private RowMapper<Student> mapper = (res, index) -> {
		Student student = new Student();
		student.setSid(res.getInt(1));
		student.setName(res.getString(2));
		student.setSurname(res.getString(3));
		student.setEmail(res.getString(4));
		return student;
	};

	@Override
	public String add(Student student) {
		try {
			if (search(student.getSid()) != null)
				return "existed";
			else {
				int rowCount = this.template.update("insert into students values(?,?,?,?)", student.getSid(),
						student.getName(), student.getSurname(), student.getEmail());
				if (rowCount == 1)
					return "success";
				else
					return "failed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "exception";
		}
	}

	@Override
	public String update(Student student) {
		try {
			if (search(student.getSid()) != null) {
				int rowCount = this.template.update("update students set name=?,surname=?,email=? where sid =?",
						student.getName(), student.getSurname(), student.getEmail(), student.getSid());
				if (rowCount == 1)
					return "success";
				else
					return "failed";
			} else
				return "notExisted";
		} catch (Exception e) {
			return "exception";
		}
	}

	@Override
	public String delete(int sid) {
		try {
			if (search(sid) != null) {
				int rowCount = this.template.update("delete from students where sid = ?", sid);
				if (rowCount == 1)
					return "success";
				else
					return "failed";
			} else
				return "existed";
		} catch (Exception e) {
			return "exception";
		}
	}

	@Override
	public Student search(int sid) {
		try {
			Student student=this.template.queryForObject("select * from students where sid = ?", mapper, sid);
			return student;
		} catch (Exception e) {
//			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Student> getAllStudent() {
		try {
			return this.template.query("select * from students", mapper);
		} catch (Exception e) {
			return null;
		}
	}

}
