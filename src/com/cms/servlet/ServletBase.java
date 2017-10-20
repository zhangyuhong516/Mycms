package com.cms.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.service.AdminService;
import com.cms.service.ChannelService;
import com.cms.service.ContentsService;
import com.cms.service.ModelService;
import com.cms.service.proxy.ProxyFacotry;

public abstract class ServletBase extends HttpServlet
{
	//初始化所有用到的service
	protected AdminService adminService=(AdminService)ProxyFacotry.getProxy(AdminService.class);
	protected ModelService modelService=(ModelService)ProxyFacotry.getProxy(ModelService.class);
	protected ChannelService channelService=(ChannelService)ProxyFacotry.getProxy(ChannelService.class);
	protected ContentsService contentService=(ContentsService)ProxyFacotry.getProxy(ContentsService.class);
	
	
	public abstract void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException ;


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		
		String action=this.getString(req, "action");
		if("".equals(action))
		{
			action="execute";
		}
		
		Class[] class_param=new Class[]{HttpServletRequest.class, HttpServletResponse.class};
		Object[] obj_param=new Object[]{req,resp};
		//this是当前的Servlet
		Class clazz=this.getClass();
		try {
			Method method=clazz.getDeclaredMethod(action, class_param);
			if(null!=method)
			{
				method.invoke(this, obj_param);
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	/**
	 * 获取请求参数
	 * @param req
	 * @param param
	 * @return
	 */
	public String getString(ServletRequest req,String param)
	{
		String re=null;
		re=null==req.getParameter(param)?"":req.getParameter(param);
		
			try {
				byte [] tem=re.getBytes("iso-8859-1");
				re=new String(tem,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return re;
	}
	/**
	 * 通过一个参数得到数组，name=lisi&name=wangwu&name=zs
	 * @param req
	 * @param param
	 * @return
	 */
	public String[] getStringArray(ServletRequest req,String param)
	{
		String []re=null;
	    re=req.getParameterValues(param);
	    if(null!=re&&re.length>0)
	    {
			for(int i=0;i<re.length;i++)
			{
				try {
					byte []tt=re[i].getBytes("iso-8859-1");
					re[i]=new String(tt,"UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    }
		return re;
	}
	/**
	 * 能过参数得到int类型
	 * @param req
	 * @param param
	 * @return
	 */
	public int getInt(ServletRequest req,String param)
	{
		int re=0;
		String str=this.getString(req, param);
		if(null!=str&&str.matches("\\d+"))
		{
			re=Integer.parseInt(str);
		}
	   return re;
	}
	/**
	 * 通过一个参数得到整数数组
	 * @param req
	 * @param param
	 * @return
	 */
	public int[] getIntArray(ServletRequest req,String param)
	{
		  int [] re=null;
		  String [] strs=this.getStringArray(req, param);
		  if(null!=strs&&strs.length>0)
		  {
			  re=new int[strs.length];
			  
			  for(int i=0;i<strs.length;i++)
			  {
				  if(null!=strs[i]&&strs[i].matches("\\d+"))
					{
						re[i]=Integer.parseInt(strs[i]);
					}else
					{
						re[i]=0;
					}
			  }
		  }
		  
		  return re;
	}
	/**
	 * 得到big....
	 * @param req
	 * @param param
	 * @return
	 */
	public BigDecimal getDec(ServletRequest req,String param)
	{
		BigDecimal re=BigDecimal.ZERO;
		String str=this.getString(req, param);
		if(str.matches("\\d+[.]\\d+"))
		{
			re= new BigDecimal(str);
		}
	   return re;
	}
	/**
	 * 将请求参数帮定到指定的Bean对象
	 * Admin admin=new Admin();
	 * this.getBean(req,admin);
	 * @param req
	 * @param obj
	 */
	public void getBean(ServletRequest req,Object obj)
	{
		Class clazz=obj.getClass();
		//得到obj对象的所有成员
		Field [] allf=clazz.getDeclaredFields();
		for(Field f:allf)
		{
			f.setAccessible(true);
		    String fname=f.getName();//得到成员的名字
		    Class ftype=f.getType();//得到这个成员的类型 
		    Object fvalue=null;
		    try {
				if(ftype==String.class)
				{
					f.set(obj,this.getString(req, fname));
				}else if(ftype==int.class||ftype==Integer.class)
				{
					int re=this.getInt(req, fname);
					if(re>0)
					{
						f.set(obj,re);
					}
					
				}else if(ftype==BigDecimal.class)
				{
					BigDecimal de=this.getDec(req, fname);
					f.set(obj, de);
				}/*else if(ftype==Date.class)
				{
					String str=this.getString(req, fname);
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM")
				}*/
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * forward到/web-info/的jsp
	 * @param req
	 * @param resp
	 * @param path
	 */
	public void forward(HttpServletRequest req,HttpServletResponse resp,String path)throws ServletException, IOException 
	{
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/"+path);
		rd.forward(req, resp);
	}

}
