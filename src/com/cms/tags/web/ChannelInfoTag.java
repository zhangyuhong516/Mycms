package com.cms.tags.web;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.cms.pojo.Channel;
import com.cms.service.ChannelService;
import com.cms.service.proxy.ProxyFacotry;

public class ChannelInfoTag extends SimpleTagSupport {

	private int cid;
	private String pname;
	@Override
	public void doTag() throws JspException, IOException {
		StringBuilder sb=new StringBuilder();
		if(cid>0)
		{
			ChannelService cd=(ChannelService)ProxyFacotry.getProxy(ChannelService.class);
			try {
				Channel channel=cd.getChannelById(cid);
				Class clazz=channel.getClass();
				Field field=clazz.getDeclaredField(pname);
				if(null!=field)
				{
					field.setAccessible(true);
					sb.append(field.get(channel));
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		this.getJspContext().getOut().println(sb.toString());
		
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
