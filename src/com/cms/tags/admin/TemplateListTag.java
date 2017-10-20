package com.cms.tags.admin;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.cms.utils.TemplateFileFilter;

public class TemplateListTag extends SimpleTagSupport {
	private String temType;
	private String fieldName;
	private String defval;

	
	@Override
	public void doTag() throws JspException, IOException {
		StringBuilder sb=new StringBuilder();
		if("index".equals(temType))
			fieldName="index_tem";
		if("list".equals(temType))
			fieldName="list_tem";
		if("content".equals(temType))
			fieldName="content_tem";
		sb.append("<select class='form-control' name='"+fieldName+"'>");
		if(!"content".equals(temType))
		{
			sb.append("<option value='-1'>不需要"+("list".equals(temType)?"列表":"首页")+"模板</option>");
			
		}
		PageContext pc=(PageContext) this.getJspContext();
		ServletContext sc=pc.getServletContext();
		String realPath=sc.getRealPath("WEB-INF/template");
		String alltem[]=TemplateFileFilter.getTemplateFiles(realPath, temType);
		if(null!=alltem&&alltem.length>0)
		{
			for(String temfile:alltem)
			{
				if(temfile.equals(defval))
				{
					sb.append("<option selected='selected' value='"+temfile+"'>"+temfile+"</option>");
				}else
				{
					sb.append("<option value='"+temfile+"'>"+temfile+"</option>");
				}
			}
		}
		sb.append("</select>");
		this.getJspContext().getOut().println(sb.toString());
		
	}
	
	
	
	
	
	
	
	public String getTemType() {
		return temType;
	}
	public void setTemType(String temType) {
		this.temType = temType;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getDefval() {
		return defval;
	}
	public void setDefval(String defval) {
		this.defval = defval;
	}
	
	
	
	
	
}
