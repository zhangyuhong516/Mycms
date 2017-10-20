package com.cms.service;

import java.sql.SQLException;
import java.util.List;

import com.cms.pojo.Channel;

public interface ChannelService {
	/**
	 * ������Ŀ
	 * @param channel
	 * @throws SQLException
	 */
	public void addChannel(Channel channel)throws SQLException;
	/**
	 * �޸���Ŀ
	 * @param channel
	 * @throws SQLException
	 */
	public void updateChannel(Channel channel)throws SQLException;
	/**
	 * �õ�����һ�༶��
	 * @return
	 * @throws SQLException
	 */
	public List<Channel> getParentChannel()throws SQLException;
	/**
	 * ָ�����id,�õ�����������Ŀ
	 */
	public List<Channel> getsubChannel(int pid)throws SQLException;
	/**
	 * ͨ��id��channel����
	 */
	public Channel getChannelById(int cid)throws SQLException;
	/**
	 * ɾ����Ŀ
	 */
	public  void deleteChannel(int cid)throws SQLException;
}
