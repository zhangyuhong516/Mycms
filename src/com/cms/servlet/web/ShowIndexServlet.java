package com.cms.servlet.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.servlet.ServletBase;
@WebServlet("/web/index")
public class ShowIndexServlet extends ServletBase 
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
	 this.forward(req, resp,"index.jsp");
		
	}

}
