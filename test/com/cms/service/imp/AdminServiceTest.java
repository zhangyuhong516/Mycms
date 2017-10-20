package com.cms.service.imp;

import java.sql.SQLException;

import com.cms.pojo.Admin;
import com.cms.service.AdminService;
import com.cms.service.proxy.ProxyFacotry;

public class AdminServiceTest {

	public void testCheckLogin()
	{
		AdminService as=(AdminService)ProxyFacotry.getProxy(AdminService.class);
		Admin admin=null;
		try {
			admin=as.checkLogin("admin@qq.com", "admin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(admin);
	}
	
}
