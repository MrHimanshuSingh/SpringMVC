package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springmvc.dao.AdminDao;
import com.springmvc.pojo.Admin;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Qualifier("adminComponent")
	@Autowired
	private AdminDao adminDao;

	@Override
	public String signIn(Admin admin) {
		return this.adminDao.signIn(admin);
	}

	@Override
	public String signUp(Admin admin) {
		return this.adminDao.signIn(admin);
	}
}
