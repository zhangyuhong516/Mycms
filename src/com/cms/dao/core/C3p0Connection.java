package com.cms.dao.core;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Connection extends ConnectionManager {

   public static ComboPooledDataSource ds=new ComboPooledDataSource();
	@Override
	public Connection getRealConnection() throws ClassNotFoundException {
		Connection con=null;
		try {
			con=ds.getConnection();
		} catch (SQLException e) {
			System.out.println("ERROR_007_c3p0得到连接对象失败");
			e.printStackTrace();
		}
		return con;
		
	}

}
