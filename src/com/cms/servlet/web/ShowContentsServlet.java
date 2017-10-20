package com.cms.servlet.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.pojo.Channel;
import com.cms.pojo.Contents;
import com.cms.servlet.ServletBase;
@WebServlet("/web/showContents")
public class ShowContentsServlet extends ServletBase {
  //把内容取来，传给jsp
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		int id=this.getInt(req, "id");
		if(id>0)
		{
			   try {
				Contents cont=contentService.get(id);
				Channel channel=channelService.getChannelById(cont.getChannel_id());
				if(channel.getParent_id()>0)
				{
				Channel parentChannel=channelService.getChannelById(channel.getParent_id());
				req.setAttribute("parentChannel", parentChannel);
				}
				req.setAttribute("contents", cont);
				req.setAttribute("channel", channel);
				this.forward(req, resp, "template/"+cont.getContent_tem());
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
