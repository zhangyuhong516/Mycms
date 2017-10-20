package com.cms.service;

import java.sql.SQLException;
import java.util.List;

import com.cms.page.PageDiv;
import com.cms.pojo.Contents;

public interface ContentsService 
{
	/**
	 * ����һ������
	 * @param contens
	 * @return int  �����¼ӵ����ݵ�id
	 * @throws SQLException
	 */
   public int addContent(Contents contens)throws SQLException;
   /**
    * �޸����£�һ��Ҫ��װid
    * @param contens
    * @throws SQLException
    */
   public void updateContent(Contents contens)throws SQLException;
   /**
    * ɾ������
    * @param cid
    * @throws SQLException
    */
   public void deleteContent(int cid)throws SQLException;
   /**
    * ��ȡ����
    * @param cid
    * @return
    * @throws SQLException
    */
   public Contents get(int cid)throws SQLException;
   /**
    * ȡ��Ŀ�µ����£�
    * @param channelId
    * @param top ����ȡ��������
    * @return
    * @throws SQLException
    */
   public List<Contents> getContentsByChannelId(int channelId,int top)throws SQLException;
   /**
    * ��ҳ��ѯ��Ŀ�µ��������ݣ�
    * @param channelId ��Ŀid
    * @param pageNo   Ҫ�����ҳ
    * @param pageSize   ÿҳ����������
    * @return  
    * @throws SQLException
    */
   public PageDiv<Contents> getContentsByPage(int channelId,int pageNo,int pageSize)throws SQLException;
   /**
    * ��ѯ�������ݣ�����level����Ȼ���ٸ���id����
    * @param pageNo
    * @param pageSize
    * @return
    * @throws SQLException
    */
   public PageDiv<Contents> getAllContentsByPage(int pageNo,int pageSize)throws SQLException;
   /**
    * ��ҳ��ѯ����
    * @param exp  select * from where exp;
    * @param pageNo
    * @param pageSize
    * @return
    * @throws SQLException
    */
   public PageDiv<Contents> getContentsByPage(String exp,int pageNo,int pageSize)throws SQLException;
}
