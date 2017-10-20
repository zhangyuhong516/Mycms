package com.cms.service.imp;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.cms.dao.core.ConnectionManager;
import com.cms.pojo.Admin;
import com.cms.service.AdminService;
import com.cms.service.ServiceBase;
import com.cms.utils.Md5Encrypt;

public class AdminServiceImp extends ServiceBase implements AdminService {

	@Override
	public void add(Admin admin)throws SQLException {
		

	}

	@Override
	public Admin checkLogin(String email, String pwd) throws SQLException {
		
		String sql="select * from admin where email=? and passwd=? limit 1";
		Admin admin=null;
		admin=run.query(ConnectionManager.getInstance().getConnection(), sql,new BeanHandler<Admin>(Admin.class),email,Md5Encrypt.md5(pwd));
		return admin;
	}

}
