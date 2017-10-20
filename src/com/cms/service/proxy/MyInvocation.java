package com.cms.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.cms.dao.core.ConnectionManager;

public class MyInvocation implements InvocationHandler {

	private Object org;
	public MyInvocation(Object obj)
	{
		this.org=obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result1=null;
		ConnectionManager cm=ConnectionManager.getInstance();
		cm.startTransaction();
		 try {
			result1=method.invoke(org, args);
			cm.commitTransaction();
		} catch (Exception e) {
			cm.rollbackTransaction();
			e.printStackTrace();
		}finally
		 {
			cm.closeConnection();
		 }
		
		return result1;
	}

}
