package com.cms.tags.web;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.cms.page.PageDiv;
import com.cms.pojo.Contents;

public class ShowPageTag_bak extends SimpleTagSupport 
{
	private String url;

	@Override
	public void doTag() throws JspException, IOException {
		StringBuilder sb=new StringBuilder();
		PageDiv<Contents> pd=(PageDiv<Contents>)this.getJspContext().getAttribute("pd",PageContext.REQUEST_SCOPE);
		if(null!=pd&&null!=pd.getList()&&pd.getList().size()>0)
		{
			sb.append("<div>");
			sb.append("<div style=\"width:30%;\">当前"+pd.getPageNo()+"/<b>"+pd.getTotalPage()+"</b>页&nbsp;&nbsp;&nbsp;总共"+pd.getTotalCount()+"条</div>");
			sb.append("<ul class=\"pagination\">");
			sb.append("<li>");
			if(pd.getPageNo()-1<1)
			{
				sb.append("<a href='"+url+"?pageNo=1' aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a>");
			}else
			{
				sb.append("<a href='"+url+"?pageNo="+(pd.getPageNo()-1)+"' aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a>");
			}
			
			sb.append("</li>");
			for(int i=pd.getStart();i<=pd.getEnd();i++)
		      {
		    	  
		    	  sb.append("<li><a href='"+url+"?pageNo="+i+"'>"+i+"</a></li>");
		    	 
		      }
			if(pd.getPageNo()>=pd.getTotalPage())
			{
				sb.append("<li><a href='"+url+"?pageNo="+pd.getTotalPage()+"' aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
			}else
			{
				sb.append("<li><a href='"+url+"?pageNo="+(pd.getPageNo()+1)+"' aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
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
