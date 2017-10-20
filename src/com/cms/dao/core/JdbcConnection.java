package com.cms.dao.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JdbcConnection extends ConnectionManager {

	Connection con=null;
	@Override
	public Connection getRealConnection()  {
		ResourceBundle res=ResourceBundle.getBundle("jdbc");
		String url=res.getString("url");
		String user=res.getString("user");
		String pwd=res.getString("pwd");
		String driver=res.getString("driver");
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return con;
		
	}

}
