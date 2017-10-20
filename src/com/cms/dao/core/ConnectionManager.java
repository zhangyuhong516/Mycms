package com.cms.dao.core;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public abstract class ConnectionManager 
{
	public static ThreadLocal<Connection> conts=new ThreadLocal<Connection>();
	private static ConnectionManager cm;
	private static ResourceBundle res=null;
	private static String cminstance=null;
	static{
		res=ResourceBundle.getBundle("jdbc");
		cminstance=res.getString("connection");
	}
	
	public Connection getConnection()
	{
		Connection con=conts.get();
		try {
			if(null==con||con.isClosed())
			{
				con=this.getRealConnection();
				conts.set(con);
			}
		} catch (Exception e) {
			System.out.println("ERROR_001_��ȡconnection����ʧ��");
			e.printStackTrace();
		}
		return con;
		
	}
	public abstract Connection getRealConnection() throws ClassNotFoundException;
	public void closeConnection()
	{
		Connection con=this.getConnection();
		try {
			if(null!=con&&!con.isClosed())
			{
				con.isClosed();
			}
		} catch (SQLException e) {
			System.out.println("ERROR_002_�ر�connection����ʧ��");
			e.printStackTrace();
		}
	}
	public void startTransaction()
	{
		Connection con=this.getConnection();
		try {
			if(null!=con&&!con.isClosed())
			{
				con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			System.out.println("ERROR_003_��ʼ����ʧ��");
			e.printStackTrace();
		}
	}
	public void commitTransaction()
	{
		Connection con=this.getConnection();
		try {
			if(null!=con&&!con.isClosed())
			{
				con.commit();
			}
		} catch (SQLException e) {
			System.out.println("ERROR_004_�ύ����ʧ��");
			e.printStackTrace();
		}
	}
	public void rollbackTransaction()
	{
		Connection con=this.getConnection();
		try {
			if(null!=con&&!con.isClosed())
			{
				con.rollback();
			}
		} catch (SQLException e) {
			System.out.println("ERROR_005_�ع�����ʧ��");
			e.printStackTrace();
		}
	}
	public static ConnectionManager getInstance()
	{
		if(null==cm)
		{
			try {
				cm=(ConnectionManager) Class.forName(cminstance).newInstance();
			} catch (Exception e) {
				System.out.println("ERROR_006_��������ļ�jdbc.properties");
				e.printStackTrace();
			} 
		}
		return cm;
	}
}
