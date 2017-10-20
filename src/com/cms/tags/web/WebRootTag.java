package com.cms.tags.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WebRootTag extends SimpleTagSupport 
{

	@Override
	public void doTag() throws JspException, IOException 
	{
		/*HttpServletRequest  request=(HttpServletRequest) ((PageContext)this.getJspContext()).getRequest();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		*/
		HttpServletRequest  req=(HttpServletRequest) ((PageContext)this.getJspContext()).getRequest();
		   String sch=req.getScheme();
		    String sername=req.getServerName();
			int serport=req.getServerPort();
			String contpath=req.getContextPath();
			String reqpath=null;
		    if(serport==80)
		    	reqpath=sch+"://"+sername+contpath;
		    else
		    	reqpath=sch+"://"+sername+":"+serport+contpath;
		
		this.getJspContext().getOut().println(reqpath);
	}

}
