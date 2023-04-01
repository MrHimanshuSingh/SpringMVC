package com.springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springmvc.pojo.Admin;

@Component("adminComponent")
public class AdminDaoImpl implements AdminDao {

	@Qualifier("template")
	@Autowired
	private JdbcTemplate template;

	private RowMapper<Admin> mapper = (res, index) -> {
		Admin admin = new Admin();
		admin.setUser(res.getString(1));
		admin.setPassword(res.getString(2));
		return admin;
	};

	@Override
	public String signIn(Admin admin) {
		try {
			Admin admin1 = template.queryForObject("select * from admin where User = ?", mapper, admin.getUser());
			if (admin1 != null && admin1.getPassword().equals(admin.getPassword()))
				return "success";
			else
				return "inCorrect";
		} catch (Exception e) {
			return "userNotExisted";
		}
	}

	@Override
	public String signUp(Admin admin) {
		try {
			if (signIn(admin).equals("userNotExisted")) {
				int rowCount = template.update("insert into admin values(?,?)", admin.getUser(), admin.getPassword());
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
}
