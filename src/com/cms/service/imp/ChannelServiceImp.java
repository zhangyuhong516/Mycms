package com.cms.service.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cms.dao.core.ConnectionManager;
import com.cms.pojo.Channel;
import com.cms.service.ChannelService;
import com.cms.service.ServiceBase;


public class ChannelServiceImp extends ServiceBase implements ChannelService {

	@Override
	public void addChannel(Channel channel) throws SQLException {
		String sql="insert into channel(model_id,parent_id,name,path,level,pic1,"
				+"pic2,links,createtime,index_tem,list_tem,content_tem,"
				+"discri,discri_pics,meta_title,meta_key,meta_des)value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object param[]=new Object[]{
				channel.getModel_id(),
				channel.getParent_id(),
				channel.getName(),
				channel.getPath(),
				channel.getLevel(),
				channel.getPic1(),
				channel.getPic2(),
				channel.getLinks(),
				channel.getCreatetime(),
				channel.getIndex_tem(),
				channel.getList_tem(),
				channel.getContent_tem(),
				channel.getDiscri(),
				channel.getDiscri_pics(),
				channel.getMeta_title(),
				channel.getMeta_key(),
				channel.getMeta_des()		
				
		}; 
		run.update(ConnectionManager.getInstance().getConnection(), sql, param);
		

	}

	@Override
	public List<Channel> getParentChannel() throws SQLException {
		String sql="select m.name as modelName,c . * from channel c,model m where c.model_id=m.id and (c.parent_id is null or c.parent_id=0) order by c.level";
		List<Channel> list=run.query(ConnectionManager.getInstance().getConnection(), sql, new BeanListHandler<Channel>(Channel.class));
		return list;
	}

	@Override
	public List<Channel> getsubChannel(int pid) throws SQLException {
		String sql="select m.name as modelName,c.* from channel c,model m where c.model_id=m.id and c.parent_id=? order by c.level";
		List<Channel> list=run.query(ConnectionManager.getInstance().getConnection(), sql, new BeanListHandler<Channel>(Channel.class),pid);
		return list;
		
	}

	@Override
	public Channel getChannelById(int cid) throws SQLException {
		String sql="select * from channel where id=?";
		Channel channel=null;
		channel=run.query(ConnectionManager.getInstance().getConnection(), sql, new BeanHandler<Channel>(Channel.class),cid);
		return channel;
	}

	@Override
	public void updateChannel(Channel channel) throws SQLException {
		String sql="update channel set model_id=?,parent_id=?,name=?,path=?,level=?,pic1=?,"
				+"pic2=?,links=?,index_tem=?,list_tem=?,content_tem=?,"
				+"discri=?,discri_pics=?,meta_title=?,meta_key=?,meta_des=? where id=?";
		Object param[]=new Object[]{
				channel.getModel_id(),
				channel.getParent_id(),
				channel.getName(),
				channel.getPath(),
				channel.getLevel(),
				channel.getPic1(),
				channel.getPic2(),
				channel.getLinks(),
				channel.getIndex_tem(),
				channel.getList_tem(),
				channel.getContent_tem(),
				channel.getDiscri(),
				channel.getDiscri_pics(),
				channel.getMeta_title(),
				channel.getMeta_key(),
				channel.getMeta_des(),
				channel.getId()
				
		}; 
		run.update(ConnectionManager.getInstance().getConnection(), sql, param);
		
	}

	@Override
	public void deleteChannel(int cid) throws SQLException {
		
		Connection con=ConnectionManager.getInstance().getConnection();
		String sql1="select * from contents where channel_id=?";
		List<Object[]> subs=run.query(con, sql1, new ArrayListHandler(),cid);
		if(null!=subs&&subs.size()>0)
		{
			throw new SQLException();
		}else
		{
			String sql2="delete from channel where id=?";
			run.update(con, sql2,cid);
		}
		
	}

}
