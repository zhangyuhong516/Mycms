package com.cms.service;

import java.sql.SQLException;
import java.util.List;

import com.cms.pojo.Channel;

public interface ChannelService {
	/**
	 * 增加栏目
	 * @param channel
	 * @throws SQLException
	 */
	public void addChannel(Channel channel)throws SQLException;
	/**
	 * 修改栏目
	 * @param channel
	 * @throws SQLException
	 */
	public void updateChannel(Channel channel)throws SQLException;
	/**
	 * 得到所有一类级别
	 * @return
	 * @throws SQLException
	 */
	public List<Channel> getParentChannel()throws SQLException;
	/**
	 * 指定类别id,得到其所有子栏目
	 */
	public List<Channel> getsubChannel(int pid)throws SQLException;
	/**
	 * 通过id找channel对象
	 */
	public Channel getChannelById(int cid)throws SQLException;
	/**
	 * 删除栏目
	 */
	public  void deleteChannel(int cid)throws SQLException;
}
