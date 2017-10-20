package com.cms.tags.web;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import com.cms.page.PageDiv;
import com.cms.pojo.Contents;
import com.cms.service.ContentsService;
import com.cms.service.proxy.ProxyFacotry;

public class ContentsListTag extends TagSupport
{
	private int channelId;
	private String byPage="false";
	private int top;
	private int pageNo;
	private int pageSize;
	
	private PageDiv<Contents> pd=null;
	private List<Contents> list=null;
	private Contents tem=null;
	private int index=0;
	
	@Override
	public int doStartTag() throws JspException {
		ContentsService cs=(ContentsService)ProxyFacotry.getProxy(ContentsService.class);
		try {
			if("true".equals(byPage))
			{
				//·ÖÒ³
				pd=cs.getContentsByPage(channelId, pageNo, pageSize);
				if(null!=pd&&null!=pd.getList()&&pd.getList().size()>0)
				{
					list=pd.getList();
					pageContext.setAttribute("pd", pd,PageContext.REQUEST_SCOPE);
				}
			}else
			{
				//²»·ÖÒ³
				list=cs.getContentsByChannelId(channelId, top);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null!=list&&list.size()>0)
		{
			tem=list.get(index++);
			return EVAL_BODY_INCLUDE;
		}else
		{
			return SKIP_BODY;
		}
	}
	
	
	@Override
	public int doAfterBody() throws JspException {
		int temindex=index++;
		if(temindex<list.size())
		{
			tem=list.get(temindex);
			return EVAL_BODY_AGAIN;
		}else
		{
			return SKIP_BODY;
		}
	}
	@Override
	public int doEndTag() throws JspException {
		list=null;
		pd=null;
		index=0;
		top=0;
		return EVAL_PAGE;
		
	}


	public int getChannelId() {
		return channelId;
	}


	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}


	public String getByPage() {
		return byPage;
	}


	public void setByPage(String byPage) {
		this.byPage = byPage;
	}


	public int getTop() {
		return top;
	}


	public void setTop(int top) {
		this.top = top;
	}


	public int getPageNo() {
		return pageNo;
	}


	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public PageDiv<Contents> getPd() {
		return pd;
	}


	public void setPd(PageDiv<Contents> pd) {
		this.pd = pd;
	}


	public List<Contents> getList() {
		return list;
	}


	public void setList(List<Contents> list) {
		this.list = list;
	}


	public Contents getTem() {
		return tem;
	}


	public void setTem(Contents tem) {
		this.tem = tem;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}
	
	

}
