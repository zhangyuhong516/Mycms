package com.cms.servlet.admin;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.page.PageDiv;
import com.cms.pojo.Channel;
import com.cms.pojo.Contents;
import com.cms.pojo.Model;
import com.cms.pojo.ModelItem;
import com.cms.servlet.ServletBase;
import com.cms.utils.HtmlRegexpUtil;
import com.cms.utils.HtmlUtil;
@WebServlet("/admin/contents")
public class ContentsServlet extends ServletBase {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		int pageNo=this.getInt(req, "pageNo");
		if(pageNo==0)pageNo=1;
		int pageSize=10;
		int channelId=this.getInt(req, "channelId");

		PageDiv<Contents> pd=null;
		try {
			if(channelId<=0)
			pd=contentService.getAllContentsByPage(pageNo, pageSize);
			else
		    pd=contentService.getContentsByPage(channelId, pageNo, pageSize);
			
			req.setAttribute("pd", pd);
			req.setAttribute("channelId",channelId);
		} catch (SQLException e) {
			req.setAttribute("msg","查询内容数据失败!");
			e.printStackTrace();
		}
		System.out.println("--------------");
		
		this.forward(req, resp, "admin/contents_list.jsp");
		
	}
	//跳转了增加文章界面
	public void toAdd(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		int channelId=this.getInt(req, "channelId");
		
		try {
			Channel channel=channelService.getChannelById(channelId);
			Model model=modelService.getModelById(channel.getModel_id());
			List<ModelItem> modelItems=modelService.getModelItem(model.getId(), 0);
			
			Map<String,ModelItem> validItems=new HashMap<String,ModelItem>();
			if(null!=modelItems&&modelItems.size()>0)
			{
				for(ModelItem mi:modelItems)
				{
					validItems.put(mi.getFname(), mi);
				}
			}
			
			
			
			req.setAttribute("channel", channel);
			req.setAttribute("model", model);
			req.setAttribute("validItems", validItems);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.forward(req, resp, "admin/contents_add.jsp");
		
	}
	//向数据库中增加文章
	public void saveAdd(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		
		ServletContext sc=this.getServletContext();
		
		Contents cont=new Contents();
		this.getBean(req, cont);
		cont.setTxt(this.getString(req,"txt"));
	
		cont.setCreatetime(new Date());
		if(null!=cont.getTxt()&&!"".equals(cont.getTxt()))
		{
			cont.setTxt_pic(HtmlRegexpUtil.getAllPic(cont.getTxt()));
		}
		Channel channel=null;
		 int lastId=0;
		try {
			channel=channelService.getChannelById(cont.getChannel_id());
			//将cms/截掉
			
			
			lastId=contentService.addContent(cont);
		     
		    
			req.setAttribute("msg", "增加内容成功!");
		} catch (SQLException e) {
			req.setAttribute("msg", "增加内容失败!");
			e.printStackTrace();
		}
		
		this.pubContentHtml(req, resp, lastId, channel);
	}
	/**
	 * 删掉一条
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteCont(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		ServletContext sc=this.getServletContext();
		String realpath=sc.getRealPath("uppics");
		
	   int id=this.getInt(req, "id");
	   if(id<=0)
	   {
		   id=(Integer)req.getAttribute("ccid");
	   }
	   
	   if(id>0)
	   {
		  try {
			Contents cont=contentService.get(id); 
			 //step1:先看contents_txt中的txt_pic中有没有图片，如果有将图片删除
             String txtpic=null!=cont?cont.getTxt_pic():null;
             if(null!=txtpic&&!"".equals(txtpic))
             {
            	 String []all=txtpic.split("[|]{2}");
            	 for(String tem:all)
            		 {
            		 File f=new File(realpath,fileNamesplit(tem));
            		 if(f.exists())f.delete();
            		 }
             }
			 //step2:再看contents表中pic1 pic2 pic3有没有图，有的话删除
			   String pic1=cont.getPic1();
			   String pic2=cont.getPic2();
			   String pic3=cont.getPic3();
			   if(null!=pic1&&!"".equals(pic1))
			   {
				   File f=new File(realpath,fileNamesplit(pic1));
				   if(f.exists())f.delete();
			   }
			   if(null!=pic2&&!"".equals(pic2))
			   {
				   File f=new File(realpath,fileNamesplit(pic2));
				   if(f.exists())f.delete();
			   }
			   if(null!=pic3&&!"".equals(pic3))
			   {
				   File f=new File(realpath,fileNamesplit(pic3));
				   if(f.exists())f.delete();
			   }
			   
				//step3:删除contents_txt中的一条记录
			
				//step4:删除contents中的记录
			   contentService.deleteContent(id);
			   req.setAttribute("msg","删除内容成功!");
		} catch (SQLException e) {
			req.setAttribute("msg","删除内容失败!");
			e.printStackTrace();
		}
	   }
	   if(null==req.getAttribute("ccid"))
	   this.execute(req, resp);
	}
	
	public static String fileNamesplit(String fname)
	{
		String re=null;
		int index=fname.lastIndexOf("/");
		if(index>0)
		{
			re=fname.substring(index+1);
		}
		return re;
	}
	//多选删除
	public void deleteAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		int []ids=this.getIntArray(req, "cid");
		for(int id:ids)
		{
			req.setAttribute("ccid", id);
			this.deleteCont(req, resp);
		}
		req.setAttribute("msg","多选删除成功!");
		this.execute(req, resp);
	}
	//跳转到修改界面
	public void editContents(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		 int id=this.getInt(req, "id");
		   if(id>=0)
		   {

				try {
			   Contents contents=contentService.get(id);
			   
				int channelId=contents.getChannel_id();
				
					Channel channel=channelService.getChannelById(channelId);
					Model model=modelService.getModelById(channel.getModel_id());
					List<ModelItem> modelItems=modelService.getModelItem(model.getId(), 0);
					
					Map<String,ModelItem> validItems=new HashMap<String,ModelItem>();
					if(null!=modelItems&&modelItems.size()>0)
					{
						for(ModelItem mi:modelItems)
						{
							validItems.put(mi.getFname(), mi);
						}
					}
					
					
					req.setAttribute("contents",contents);
					req.setAttribute("channel", channel);
					req.setAttribute("model", model);
					req.setAttribute("validItems", validItems);
					this.forward(req, resp, "admin/contents_edit.jsp");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		   
		   }else
		   {
			   
			   this.execute(req, resp);  
		   }
		  
	}
	
	public void saveEdit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
	    int id=this.getInt(req, "id");
	    Channel channel=null;
	    if(id>0)
	    {
	    	try {
	    	Contents cont=(Contents)contentService.get(id);
	    	this.getBean(req, cont);
			cont.setTxt(this.getString(req,"txt"));
		
			cont.setCreatetime(new Date());
			if(null!=cont.getTxt()&&!"".equals(cont.getTxt()))
			{
				cont.setTxt_pic(HtmlRegexpUtil.getAllPic(cont.getTxt()));
			}
			channel=channelService.getChannelById(cont.getChannel_id());
			contentService.updateContent(cont);;
				req.setAttribute("msg", "修改内容成功!");
			} catch (SQLException e) {
				req.setAttribute("msg", "修改内容失败!");
				e.printStackTrace();
			}
	    }

		
	   pubContentHtml(req, resp, id, channel);
	}
	/**
	 * 生成内容对应内容页
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	/**
	 * 生成内容对应内容页
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void pubContentHtml(HttpServletRequest req, HttpServletResponse resp,int lastId,Channel channel)
			throws ServletException, IOException 
	{
		ServletContext sc=this.getServletContext();
		 //得到请求前端的url
	     String sch=req.getScheme();
	    String sername=req.getServerName();
		int serport=req.getServerPort();
		String contpath=req.getContextPath();
		String reqpath=null;
	    if(serport==80)
	    	reqpath=sch+"://"+sername+contpath+"/web/showContents?id="+lastId;
	    else
	    	reqpath=sch+"://"+sername+":"+serport+contpath+"/web/showContents?id="+lastId;
	   
	    String htmlpath=sc.getRealPath("html");
	    
	    File chanpath=new File(htmlpath+"/"+channel.getPath());
	    if(!chanpath.exists())
	    {
	    	chanpath.mkdir();
	    }
	    
	    File realhtml=new File(chanpath,"article_"+channel.getId()+"_"+lastId+".html");
	    HtmlUtil.saveFile(realhtml.toString(), reqpath);
	    this.execute(req, resp);
	 
	}
	
	
	public void pubContentHtml2(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		int lastId=this.getInt(req,"id");
		Channel channel=null;
		if(lastId>0)
		{
			try 
			{
				Contents cont=contentService.get(lastId);
				channel=channelService.getChannelById(cont.getChannel_id());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		req.setAttribute("msg", "发布内容成功!");
		pubContentHtml(req, resp, lastId, channel);
	}
}
