package com.cms.service;

import java.sql.SQLException;
import java.util.List;

import com.cms.page.PageDiv;
import com.cms.pojo.Contents;

public interface ContentsService 
{
	/**
	 * 增加一个文章
	 * @param contens
	 * @return int  返回新加的内容的id
	 * @throws SQLException
	 */
   public int addContent(Contents contens)throws SQLException;
   /**
    * 修改文章，一定要封装id
    * @param contens
    * @throws SQLException
    */
   public void updateContent(Contents contens)throws SQLException;
   /**
    * 删除文章
    * @param cid
    * @throws SQLException
    */
   public void deleteContent(int cid)throws SQLException;
   /**
    * 获取文章
    * @param cid
    * @return
    * @throws SQLException
    */
   public Contents get(int cid)throws SQLException;
   /**
    * 取栏目下的文章，
    * @param channelId
    * @param top 你想取几条数据
    * @return
    * @throws SQLException
    */
   public List<Contents> getContentsByChannelId(int channelId,int top)throws SQLException;
   /**
    * 分页查询栏目下的所有内容，
    * @param channelId 栏目id
    * @param pageNo   要查多少页
    * @param pageSize   每页多少条数据
    * @return  
    * @throws SQLException
    */
   public PageDiv<Contents> getContentsByPage(int channelId,int pageNo,int pageSize)throws SQLException;
   /**
    * 查询所有内容，根据level升序，然后再根据id降序
    * @param pageNo
    * @param pageSize
    * @return
    * @throws SQLException
    */
   public PageDiv<Contents> getAllContentsByPage(int pageNo,int pageSize)throws SQLException;
   /**
    * 分页查询数据
    * @param exp  select * from where exp;
    * @param pageNo
    * @param pageSize
    * @return
    * @throws SQLException
    */
   public PageDiv<Contents> getContentsByPage(String exp,int pageNo,int pageSize)throws SQLException;
}
