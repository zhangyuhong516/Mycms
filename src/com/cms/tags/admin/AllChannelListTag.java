package com.cms.tags.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.cms.pojo.Channel;
import com.cms.service.ChannelService;
import com.cms.service.proxy.ProxyFacotry;

public class AllChannelListTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		StringBuilder sb=new StringBuilder();
		ChannelService cs=(ChannelService) ProxyFacotry.getProxy(ChannelService.class);
		
		
		try {
			List<Channel> parent=cs.getParentChannel();
			if(null!=parent&&parent.size()>0)
			{
				int index=1;
				for(Channel c:parent)
				{
					sb.append("<tr>");
					sb.append("<td align='center'>"+(index++)+"</td>");
					sb.append("<td><b>"+c.getName()+"</b></td>");
					sb.append("<td>"+c.getModelName()+"</td>");
					sb.append("<td>"+c.getLevel()+"</td>");
					sb.append("<td> <a class='btn btn-info btn-sm' href='channel?action=toEdit&cid="+c.getId()+"'>修改</a>");
					sb.append("&nbsp;<a  class='btn btn-danger btn-sm' href='channel?action=delChannel&cid="+c.getId()+"' >删除</a>");
					sb.append("&nbsp;<a class='btn btn-info btn-sm' href='channel?action=pubsChannel&cid="+c.getId()+"' >发布</a>");
					sb.append("</td>");																	
					sb.append("</tr>");
					List<Channel> subs=cs.getsubChannel(c.getId());
					if(null!=subs&&subs.size()>0)
					{
						
						for(Channel s:subs)
						{
							sb.append("<tr>");
							sb.append("<td align='center'>"+(index++)+"</td>");
							sb.append("<td>&nbsp;&nbsp;&nbsp;|--"+s.getName()+"</td>");
							sb.append("<td>"+s.getModelName()+"</td>");
							sb.append("<td>"+s.getLevel()+"</td>");
							sb.append("<td> <a class='btn btn-success btn-sm' href='channel?action=toEdit&cid="+s.getId()+"'>修改</a>");
							sb.append("&nbsp;<a  class='btn btn-danger btn-sm' href='channel?action=delChannel&cid="+s.getId()+"' >删除</a>");
							sb.append("&nbsp;<a class='btn btn-success btn-sm' href='channel?action=pubsChannel&cid="+s.getId()+"' >发布</a>");
							sb.append("</td>");																	
							sb.append("</tr>");
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getJspContext().getOut().println(sb.toString());
	}

	
}
