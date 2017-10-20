package com.cms.dao.core;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.cms.pojo.Admin;
import com.cms.service.AdminService;
import com.cms.service.proxy.ProxyFacotry;

public class TestConnection {

	@Test
	public void testJdbc()
	{
		ConnectionManager cm=ConnectionManager.getInstance();
		Connection con1=cm.getConnection();
		Connection con2=cm.getConnection();
		System.out.println(con1);
		System.out.println(con2);
		cm.closeConnection();
		System.out.println("------------------");
		Connection con3=cm.getConnection();
		Connection con4=cm.getConnection();
		System.out.println(con3);
		System.out.println(con4);
	}
	public void testProxy()
	{
		AdminService as=(AdminService)ProxyFacotry.getProxy(AdminService.class);
	    try {
			as.add(new Admin());
			System.out.println(as);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
