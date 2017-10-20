package com.cms.servlet.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.servlet.ServletBase;
import com.cms.utils.HtmlUtil;
@WebServlet("/admin/createindex")
public class CreateIndexServlet extends ServletBase {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		 //得到请求前端的url
	     String sch=req.getScheme();
	    String sername=req.getServerName();
		int serport=req.getServerPort();
		String contpath=req.getContextPath();
		String reqpath=null;
	    if(serport==80)
	    	reqpath=sch+"://"+sername+contpath+"/web/index";
	    else
	    	reqpath=sch+"://"+sername+":"+serport+contpath+"/web/index";
	   
	    String realpath=this.getServletContext().getRealPath("/");
	   
		HtmlUtil.saveFile(realpath+File.separator+"index.html", reqpath);
		req.setAttribute("msg","生成首页成功!");
		this.forward(req, resp, "admin/admin_index.jsp");
	}

}
