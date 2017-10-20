package com.cms.servlet.admin;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.page.PageDiv;
import com.cms.pojo.Channel;
import com.cms.pojo.Contents;
import com.cms.pojo.Model;
import com.cms.servlet.ServletBase;
import com.cms.utils.HtmlRegexpUtil;
import com.cms.utils.HtmlUtil;
@WebServlet("/admin/channel")
public class ChannelServlet extends ServletBase {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.forward(req, resp, "admin/channel_list.jsp");

	}
	public void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Model> mlist=null;
		List<Channel> clist=null;
		try {
			mlist=modelService.getAllModel();
			clist=channelService.getParentChannel();
			req.setAttribute("mlist", mlist);
			req.setAttribute("clist", clist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.forward(req,resp,"admin/channel_add.jsp");

	}
	public void saveAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Channel channel=new Channel();
		this.getBean(req, channel);
		channel.setCreatetime(new Date());
		if(-1==channel.getParent_id())channel.setParent_id(0);
		if(null!=channel.getDiscri())
		{
			channel.setDiscri_pics(HtmlRegexpUtil.getAllPic(channel.getDiscri()));
		}
		try {
			channelService.addChannel(channel);
			req.setAttribute("msg", "������Ŀ�ɹ�");
		} catch (SQLException e) {
			req.setAttribute("msg", "������Ŀʧ��");
			e.printStackTrace();
		}
		
		this.toAdd(req, resp);
	}
	public void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Model> mlist=null;
		List<Channel> clist=null;
		int cid=this.getInt(req, "cid");
		if(cid>0)
		{
			try {
				mlist=modelService.getAllModel();
				clist=channelService.getParentChannel();
				Channel channel=channelService.getChannelById(cid);
				System.out.println(channel);
				req.setAttribute("channel", channel);
				req.setAttribute("mlist", mlist);
				req.setAttribute("clist", clist);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.forward(req,resp,"admin/channel_edit.jsp");
		}else
		{
			req.setAttribute("msg", "�޸���Ŀʧ��");
			this.execute(req, resp);
		}
		
	}
	/**
	 * �޸ĵ����ݿ�
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void saveEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cid=this.getInt(req, "cid");
		if(cid>0)
		{
			try {
				Channel channel=channelService.getChannelById(cid);
				this.getBean(req, channel);
				if(null!=channel.getDiscri())
				{
					channel.setDiscri_pics(HtmlRegexpUtil.getAllPic(channel.getDiscri()));
				}
				channelService.updateChannel(channel);
				req.setAttribute("msg", "�޸ĳɹ�");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else
		{
			req.setAttribute("msg", "�޸���Ŀʧ��");
		}
		this.execute(req, resp);
	}
	public void delChannel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cid=this.getInt(req, "cid");
		if(cid>0)
		{
			try {
				List<Channel> subs=channelService.getsubChannel(cid);
				if(null!=subs&&subs.size()>0)
				{
					//������Ŀ
					req.setAttribute("msg", "����Ŀ������Ŀ������ɾ��");
					
				}else
				{
					//û������Ŀ
					channelService.deleteChannel(cid);
					req.setAttribute("msg", "ɾ����Ŀ�ɹ�");
					
				}
			} catch (SQLException e) {
				req.setAttribute("msg", "����Ŀ�����ݣ�����ɾ��");
				e.printStackTrace();
			}
			
		}else
		{
			req.setAttribute("msg", "��ѡ��Ҫɾ������Ŀ");
		}
		this.execute(req, resp);
	}
	/**
	 * ����ָ����Ŀ���б�ҳ��
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void pubsChannel(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		ServletContext sc=this.getServletContext();
		 //�õ�����ǰ�˵�url
	     String sch=req.getScheme();
	    String sername=req.getServerName();
		int serport=req.getServerPort();
		String contpath=req.getContextPath();
		String reqpath=null;
		
		int id=this.getInt(req, "cid");
		Channel channel=null;
		PageDiv<Contents> pd=null;
		int pageSize=14;
		int totalPage=0;
		
		String list_tem=null;
		String index_tem=null;
		 String htmlpath=sc.getRealPath("html");
		if(id>0)
		{
		    try {
				channel=channelService.getChannelById(id);
				pd=contentService.getContentsByPage(id, 1, pageSize);
				totalPage=pd.getTotalPage();
				
                list_tem=channel.getList_tem();
                index_tem=channel.getIndex_tem();
                if(null!=index_tem&&!"-1".equals(index_tem)&&index_tem.toLowerCase().endsWith("index.jsp"))
                {

                	//�����б���ҳ
					   if(serport==80)
					    	reqpath=sch+"://"+sername+contpath+"/web/contList?action=toIndex&id="+id;
					    else
					    	reqpath=sch+"://"+sername+":"+serport+contpath+"/web/contList?action=toIndex&id="+id;

					    File chanpath=new File(htmlpath+"/"+channel.getPath());
					    if(!chanpath.exists())
					    {
					    	chanpath.mkdir();
					    }
					    
					    File realhtml=new File(chanpath,"index.html");
					    HtmlUtil.saveFile(realhtml.toString(), reqpath);
                }
                if(null!=list_tem&&(!"-1".equals(list_tem.trim()))&&list_tem.toLowerCase().endsWith("list.jsp"))
                {
                   //������Ŀ�б�	
                	 if(null!=pd&&pd.getTotalPage()>0)
 				    {
 				    	   for(int i=1;i<=pd.getTotalPage();i++)
 				    	   {
 				    
 							   if(serport==80)
 							    	reqpath=sch+"://"+sername+contpath+"/web/contList?id="+id+"&pageNo="+i+"&pageSize="+pageSize+"&totalPage="+totalPage;
 							    else
 							    	reqpath=sch+"://"+sername+":"+serport+contpath+"/web/contList?id="+id+"&pageNo="+i+"&pageSize="+pageSize+"&totalPage="+totalPage;

 							    File chanpath=new File(htmlpath+"/"+channel.getPath());
 							    if(!chanpath.exists())
 							    {
 							    	chanpath.mkdir();
 							    }
 							    
 							    File realhtml=new File(chanpath,"list_"+i+".html");
 							    HtmlUtil.saveFile(realhtml.toString(), reqpath);
 				    	   }   
 				    
 				    }
                }
                
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    req.setAttribute("msg", "������Ŀ�ɹ�!");
		    this.execute(req, resp);
		}
	}
	
	
	
}
