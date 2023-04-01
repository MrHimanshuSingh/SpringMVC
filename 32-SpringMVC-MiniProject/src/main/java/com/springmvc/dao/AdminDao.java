package com.springmvc.dao;

import com.springmvc.pojo.Admin;

public interface AdminDao {
	String signIn(Admin admin);
	String signUp(Admin admin);

}
