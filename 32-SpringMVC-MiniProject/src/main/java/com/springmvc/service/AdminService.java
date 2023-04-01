package com.springmvc.service;

import com.springmvc.pojo.Admin;

public interface AdminService {
	String signIn(Admin admin);
	String signUp(Admin admin);
}
