package com.cms.service;

import java.sql.SQLException;

import com.cms.pojo.Admin;

public interface AdminService {
	public void add(Admin admin) throws SQLException;
	
	public Admin checkLogin(String email,String pwd) throws SQLException;
	
}
