package com.cms.service.proxy;

import java.lang.reflect.Proxy;

public class ProxyFacotry {

	public static Object getProxy(Class clazz)
	{
		Object proxy=null;
		Object org;
		String name=clazz.getName();
		int lastdot=name.lastIndexOf(".");
		String imp=name.substring(0,lastdot+1)+"imp"+name.substring(lastdot)+"Imp";
		try {
			Class impclazz=Class.forName(imp);
			org=impclazz.newInstance();
			MyInvocation myin=new MyInvocation(org);
			proxy=Proxy.newProxyInstance(org.getClass().getClassLoader(), org.getClass().getInterfaces(), myin);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return proxy;
		
	}
}
