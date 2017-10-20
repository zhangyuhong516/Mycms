package com.cms.tags.web;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.cms.pojo.Channel;
import com.cms.pojo.Contents;

public class PropertyTag extends SimpleTagSupport {

	private String pname;

	@Override
	public void doTag() throws JspException, IOException {
		StringBuilder sb=new StringBuilder();
		JspTag parent=this.getParent();
		try {
			if(parent instanceof ChannelListTag)
			{
				ChannelListTag channelList=(ChannelListTag)parent;
				Channel tem=channelList.getTem();
				
				Class clazz=tem.getClass();
				Field field=clazz.getDeclaredField(pname);
				if(null!=field)
				{
					field.setAccessible(true);
					sb.append(field.get(tem));
				}
			
			
			}
			if(parent instanceof ContentsListTag)
			{
				ContentsListTag contentsList=(ContentsListTag)parent;
				Contents tem=contentsList.getTem();
				Class clazz=tem.getClass();
				Field field=clazz.getDeclaredField(pname);
				if(null!=field)
				{
					field.setAccessible(true);
					sb.append(field.get(tem));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		this.getJspContext().getOut().println(sb.toString());
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
}
