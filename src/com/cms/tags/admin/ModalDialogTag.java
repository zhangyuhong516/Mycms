package com.cms.tags.admin;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ModalDialogTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		StringBuilder sb=new StringBuilder();
		JspContext js=this.getJspContext();
		String msg=(String) js.getAttribute("msg", PageContext.REQUEST_SCOPE);
		if(null!=msg)
		{
			sb.append("<script type='text/javascript'>");
			sb.append("$(function(){");
			sb.append("$('#mymodal').modal({");
			sb.append("keyboard:false,");
			sb.append("show:true");
			sb.append("});");
			sb.append("});");
			sb.append("</script>");
			sb.append("<div class='modal fade' id='mymodal'>");
			sb.append("<div class='modal-dialog'>");
			sb.append("<div class='modal-content'>");
			sb.append("<div class='modal-header'>");
			sb.append("<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>");
			sb.append("<h4 class='modal-title'>ÌבÊ¾</h4>");
			sb.append("</div>");
			sb.append("<div class='modal-body'>");
			sb.append("<p>"+msg+"</p>");
			sb.append("</div>");
			sb.append("<div class='modal-footer'>");
			sb.append("<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>");
			sb.append("</div>");
			sb.append("</div>");
			sb.append("</div>");
			sb.append("</div>");
		}
		this.getJspContext().getOut().write(sb.toString());
		
	}
	
}
