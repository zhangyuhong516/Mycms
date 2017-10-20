package com.cms.tags.web;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cms.dao.core.ConnectionManager;
import com.cms.pojo.Channel;

public class ChannelListTag extends TagSupport
{
	private QueryRunner run=new QueryRunner();
	private  String isParent="false";//�Ƿ�Ҫһ����Ŀ�б�
	private int parentId;//����Ŀid
	private int top;//ֻ��ʾtop����Ŀ
	
	private List<Channel> list=null;
	private Channel tem=null;//��ǰ��������Ŀ
	private int index=0;//��ǰȡ���˵ڼ���Ԫ��

	@Override
	public int doStartTag() throws JspException
	{
		Connection con=ConnectionManager.getInstance().getConnection();
		
		try {
			//��Ҫ�����ݿ��е���Ŀȡ����
			String sql=null;
			if("true".equals(isParent.toLowerCase()))
			{
				sql="select * from channel where parent_id is null or parent_id=0 order by level asc,id desc";
				list=run.query(con, sql,new BeanListHandler<Channel>(Channel.class));
			}else
			{
				if(top==0)
				{
					sql="select * from channel where parent_id=? order by level asc,id desc";
					list=run.query(con, sql,new BeanListHandler<Channel>(Channel.class),parentId);
				}else
				{
				sql="select * from channel where parent_id=? order by level asc,id desc limit ?";
				list=run.query(con, sql,new BeanListHandler<Channel>(Channel.class),parentId,top);
				}
			}
			
			if(null!=list&&list.size()>0)
			{
			
				tem=list.get(index++);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return EVAL_BODY_INCLUDE;
	}
	@Override
	public int doAfterBody() throws JspException 
	{
		int curindex=index++;
		if(curindex<list.size())
		{
			tem=list.get(curindex);
			
				return EVAL_BODY_AGAIN;
		}
		
		else
			return SKIP_BODY;
		  
	}

	@Override
	public int doEndTag() throws JspException 
	{
		// TODO Auto-generated method stub
		return super.doEndTag();
	}

	public String getIsParent() {
		return isParent;
	}
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public Channel getTem() {
		return tem;
	}
	public void setTem(Channel tem) {
		this.tem = tem;
	}



}
