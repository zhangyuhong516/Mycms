package com.cms.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cms.pojo.Admin;
import com.cms.servlet.ServletBase;
@WebServlet("/admin/login")
public class LoginServlet extends ServletBase 
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.forward(req, resp, "admin/login.jsp");
		//req.getRequestDispatcher("/WEB-INF/admin/login.jsp").forward(req, resp);
		
	}
	public void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=this.getString(req, "email");
		String pwd=this.getString(req, "passwd");
		String randimg=this.getString(req,"randimg");
		HttpSession hs=req.getSession();
		String serverimg=(String)hs.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		Admin admin=null;
		try {
			admin=adminService.checkLogin(email, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(randimg.equals(serverimg)&&null!=admin)
		{
			hs.setAttribute("loged", admin);
			this.forward(req, resp, "admin/admin_index.jsp");
		}else
		{
			this.forward(req, resp, "admin/login.jsp");
		}
		
		
	}
	public void checkEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		PrintWriter out=resp.getWriter();
		String email=this.getString(req, "email");
		if(email.equals("admin@qq.com"))
		{
			out.println(1);
		}else
		{
			out.println(2);
		}
		out.close();
		System.out.println(" ’µΩ°£°£"+email);
		
	}
	public void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession();
		hs.invalidate();
		this.forward(req,resp,"admin/login.jsp");
		
		
	}
	
	
}
