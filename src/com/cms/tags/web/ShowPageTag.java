package com.cms.tags.web;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.cms.page.PageDiv;
import com.cms.pojo.Contents;

public class ShowPageTag extends SimpleTagSupport {

	private String url;

	@Override
	public void doTag() throws JspException, IOException {
		StringBuilder sb=new StringBuilder();
		int totalPage=(Integer)this.getJspContext().getAttribute("totalPage",PageContext.REQUEST_SCOPE);
		int pageNo=(Integer)this.getJspContext().getAttribute("pageNo",PageContext.REQUEST_SCOPE);
		
		if(totalPage>0)
		{
			sb.append("<div>");
			
			sb.append("<ul class=\"pagination\">");
			sb.append("<li>");
			if(pageNo-1<1)
			{
				sb.append("<a href='./list_1.html'><span aria-hidden=\"true\">&laquo;</span></a>");
			}else
			{
				sb.append("<a href='./list_"+(pageNo-1)+".html'><span aria-hidden=\"true\">&laquo;</span></a>");
			}
			
			sb.append("</li>");
			for(int i=1;i<=totalPage;i++)
		      {
		    	  
		    	  sb.append("<li><a href='./list_'"+i+".html>"+i+"</a></li>");
		    	 
		      }
			if(pageNo>=totalPage)
			{
				sb.append("<li><a href='./list_"+totalPage+".html'><span aria-hidden=\"true\">&raquo;</span></a></li>");
			}else
			{
				sb.append("<li><a href='list_"+(pageNo+1)+".html'><span aria-hidden=\"true\">&raquo;</span></a></li>");
			}
			sb.append("</ul>");
			sb.append("</div>");
		}
		this.getJspContext().getOut().println(sb.toString());
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
