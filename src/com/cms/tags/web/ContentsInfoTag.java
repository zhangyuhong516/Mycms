package com.cms.tags.web;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.cms.pojo.Contents;
import com.cms.service.ContentsService;
import com.cms.service.proxy.ProxyFacotry;

public class ContentsInfoTag extends SimpleTagSupport 
{
	private int cid;
	private String pname;
	@Override
	public void doTag() throws JspException, IOException {
		
		String re=null;
		Contents contents=null;
		try {
			contents=(Contents)this.getJspContext().getAttribute("contents", PageContext.REQUEST_SCOPE);
			if(null==contents)
			{
				ContentsService cs=(ContentsService)ProxyFacotry.getProxy(ContentsService.class);
				contents=cs.get(cid);
				this.getJspContext().setAttribute("contents", contents,PageContext.REQUEST_SCOPE);	
			}
			if(null!=contents)
			{
				Class clazz=contents.getClass();
				Field field=clazz.getDeclaredField(pname);
				if(null!=field)
				{
					field.setAccessible(true);
					re=field.get(contents).toString();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getJspContext().getOut().println(re);
		
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
	
}
