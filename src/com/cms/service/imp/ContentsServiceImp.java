package com.cms.service.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.text.AbstractDocument.Content;

import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cms.dao.core.ConnectionManager;
import com.cms.page.PageDiv;
import com.cms.pojo.Contents;
import com.cms.service.ContentsService;
import com.cms.service.ServiceBase;

public class ContentsServiceImp extends ServiceBase implements ContentsService {

	@Override
	public int addContent(Contents contens) throws SQLException
	{
		int re=0;
		Connection con=ConnectionManager.getInstance().getConnection();
		String sql="insert into contents(channel_id,admin_id,title,tags,"
				+ "origin,origin_url,discri,createtime,level,titlecolor,"
				+ "links,content_tem,status,isrecom,pic1,pic2,pic3,extstr1,"
				+ "extstr2,extint1,extint2) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object []params=new Object[]{
				contens.getChannel_id(),
				contens.getAdmin_id(),
				contens.getTitle(),
				contens.getTags(),
				contens.getOrigin(),
				contens.getOrigin_url(),
				contens.getDiscri(),
				contens.getCreatetime(),
				contens.getLevel(),
				contens.getTitlecolor(),
				contens.getLinks(),
				contens.getContent_tem(),
				contens.getStatus(),
				contens.getIsrecom(),
				contens.getPic1(),
				contens.getPic2(),
				contens.getPic3(),
				contens.getExtstr1(),
				contens.getExtstr2(),
				contens.getExtint1(),
				contens.getExtint2()
		};
		run.update(con,sql,params);
		
		String sql1="select last_insert_id() from dual";
		Long lastId=(Long)run.query(con, sql1,new ArrayHandler())[0];
		
		String sql2="insert into contents_txt(content_id,txt,txt_pic) values(?,?,?)";
		run.update(con,sql2,lastId.intValue(),contens.getTxt(),contens.getTxt_pic());
		re=lastId.intValue();
		
		return re;
		
		
	}

	@Override
	public void updateContent(Contents contens) throws SQLException {
		Connection con=ConnectionManager.getInstance().getConnection();
		String sql="update contents set channel_id=?,admin_id=?,title=?,tags=?,"
				+ "origin=?,origin_url=?,discri=?,level=?,titlecolor=?,"
				+ "links=?,content_tem=?,status=?,isrecom=?,pic1=?,pic2=?,pic3=?,extstr1=?,"
				+ "extstr2=?,extint1=?,extint2=? where id=? ";
		Object []params=new Object[]{
				contens.getChannel_id(),
				contens.getAdmin_id(),
				contens.getTitle(),
				contens.getTags(),
				contens.getOrigin(),
				contens.getOrigin_url(),
				contens.getDiscri(),
				contens.getLevel(),
				contens.getTitlecolor(),
				contens.getLinks(),
				contens.getContent_tem(),
				contens.getStatus(),
				contens.getIsrecom(),
				contens.getPic1(),
				contens.getPic2(),
				contens.getPic3(),
				contens.getExtstr1(),
				contens.getExtstr2(),
				contens.getExtint1(),
				contens.getExtint2(),
				contens.getId()
		};
		run.update(con,sql,params);
		String sql2="update contents_txt set txt=?,txt_pic=? where content_id=?";
		run.update(con,sql2,contens.getTxt(),contens.getTxt_pic(),contens.getId());
		
	}

	@Override
	public void deleteContent(int cid) throws SQLException 
	{
		Connection con=ConnectionManager.getInstance().getConnection();
		//step1:先看contents_txt中的txt_pic中有没有图片，如果有将图片删除
		//step2:再看contents表中pic1 pic2 pic3有没有图，有的话删除
		//step3:删除contents_txt中的一条记录
		String sql2="delete from contents_txt where content_id=?";
		run.update(con,sql2,cid);
		//step4:删除contents中的记录
		String sql="delete from contents where id=?";
		run.update(con,sql,cid);
		
	}

	@Override
	public Contents get(int cid) throws SQLException {
		//String sql="select t.name as channelName, c.* from contents c,channel t where id=? and c.channel_id=t.id";
		
		String sql="select txt.*,cont.* from contents cont,contents_txt txt where txt.content_id=cont.id and cont.id=?";
		
		Contents con=run.query(ConnectionManager.getInstance().getConnection(),sql, new BeanHandler<Contents>(Contents.class),cid);
		
		return con;
	}

	@Override
	public List<Contents> getContentsByChannelId(int channelId, int top)
			throws SQLException {
		String sql="select t.name as channelName, c.* from contents c,channel t where channel_id=? and c.channel_id=t.id order by c.level asc,c.id desc limit ?";
		List<Contents> list=run.query(ConnectionManager.getInstance().getConnection(),sql, new BeanListHandler<Contents>(Contents.class),channelId,top);
		
		return list;
	}

	@Override
	public PageDiv<Contents> getContentsByPage(int channelId, int pageNo,
			int pageSize) throws SQLException {
		PageDiv<Contents> pd=null;
		Connection con=ConnectionManager.getInstance().getConnection();
		String sql="select t.name as channelName, c.* from contents c,channel t where channel_id=? and c.channel_id=t.id order by c.level asc,c.id desc  limit ?,?";
		List<Contents> list=run.query(con,sql, new BeanListHandler<Contents>(Contents.class),channelId,(pageNo-1)*pageSize,pageSize);
		
		String sql2="select count(id) from contents where channel_id=?";
		Long totalCount=(Long)run.query(con, sql2,new ArrayHandler(),channelId)[0];
		pd=new PageDiv<Contents>(pageNo, pageSize, totalCount.intValue(), list);
		return pd;
	}

	@Override
	public PageDiv<Contents> getContentsByPage(String exp, int pageNo,
			int pageSize) throws SQLException {
		PageDiv<Contents> pd=null;
		Connection con=ConnectionManager.getInstance().getConnection();
		String sql="select t.name as channelName, c.* from contents c,channel t where ? and c.channel_id=t.id order by c.level asc,c.id desc  limit ?,?";
		List<Contents> list=run.query(con,sql, new BeanListHandler<Contents>(Contents.class),exp,(pageNo-1)*pageSize,pageSize);
		
		String sql2="select count(id) from contents where ?";
		Long totalCount=(Long)run.query(con, sql2,new ArrayHandler(),exp)[0];
		pd=new PageDiv<Contents>(pageNo, pageSize, totalCount.intValue(), list);
		return pd;
	}

	@Override
	public PageDiv<Contents> getAllContentsByPage(int pageNo, int pageSize)
			throws SQLException {

			PageDiv<Contents> pd=null;
			Connection con=ConnectionManager.getInstance().getConnection();
			String sql="select t.name as channelName, c.* from contents c,channel t where  c.channel_id=t.id order by c.level asc,c.id desc limit ?,?";
			List<Contents> list=run.query(con,sql, new BeanListHandler<Contents>(Contents.class),(pageNo-1)*pageSize,pageSize);
			
			String sql2="select count(id) from contents";
			Long totalCount=(Long)run.query(con, sql2,new ArrayHandler())[0];
			pd=new PageDiv<Contents>(pageNo, pageSize, totalCount.intValue(), list);
			return pd;
	}



}
