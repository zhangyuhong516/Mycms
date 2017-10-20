package com.cms.servlet.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.pojo.Channel;
import com.cms.servlet.ServletBase;
@WebServlet("/web/contList")
public class ContentsListServlet extends ServletBase {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=this.getInt(req, "id");
		int pageNo=this.getInt(req, "pageNo");
		int pageSize=this.getInt(req, "pageSize");
		int totalPage=this.getInt(req, "totalPage");
		if(pageNo==0)pageNo=1;
		String list_tem=null;
		String index_tem=null;
		
		try {
			if(id>0)
			{
				Channel channel=channelService.getChannelById(id);
				Channel parentChannel=channelService.getChannelById(channel.getParent_id());
				req.setAttribute("parentChannel", parentChannel);
				list_tem=channel.getList_tem();
				index_tem=channel.getIndex_tem();
				req.setAttribute("pageSize", pageSize);
				req.setAttribute("pageNo", pageNo);
				req.setAttribute("channel", channel);
				req.setAttribute("totalPage", totalPage);
			
			this.forward(req, resp, "template/"+list_tem);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void toIndex(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id=this.getInt(req, "id");
		int pageNo=this.getInt(req, "pageNo");
		int pageSize=this.getInt(req, "pageSize");
		int totalPage=this.getInt(req, "totalPage");
		if(pageNo==0)pageNo=1;
		String list_tem=null;
		String index_tem=null;
		
		List<Channel> subChannel=null;
		
		try {
			if(id>0)
			{
				subChannel=channelService.getsubChannel(id);
				Channel channel=channelService.getChannelById(id);
				Channel parentChannel=channelService.getChannelById(channel.getParent_id());
				req.setAttribute("parentChannel", parentChannel);
				list_tem=channel.getList_tem();
				index_tem=channel.getIndex_tem();
				req.setAttribute("pageSize", pageSize);
				req.setAttribute("pageNo", pageNo);
				req.setAttribute("channel", channel);
				req.setAttribute("totalPage", totalPage);
				req.setAttribute("subChannel", subChannel);

				this.forward(req, resp, "template/"+list_tem);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
