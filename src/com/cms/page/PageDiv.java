package com.cms.page;

import java.util.List;

public class PageDiv<T> {
	private int pageNo;
	private int pageSize;
	private int totalPage;
	private int totalCount;
	private int indexCount=7;
	private int start;
	private int end;
	 private List<T> list;
	 public PageDiv(){}
	 public PageDiv(int pageNo,int pageSize,int totalCount,List<T> list)
	 {
		 this.pageNo=pageNo;
		 this.pageSize=pageSize;
		 this.totalCount=totalCount;
		 this.totalPage=(totalCount+pageSize-1)/pageSize;
		 this.list=list;
		 if(pageNo-indexCount/2<1)
			 start=1;
		 else
			 start=pageNo-indexCount/2;
		 if(pageNo+indexCount/2>totalPage)
			 end=totalPage;
		 else
			 end=pageNo+indexCount/2;
	 }
	 public int getPrevious()
	 {
		 int re=0;
		 if(this.pageNo-1>0)
			 re=this.pageNo-1;
		 else
			 re=1;
		 return re;
	 }
	public int getNext()
	{
		int re=0;
		if(this.pageNo+1<this.totalPage)
			re=this.pageNo+1;
		else
			re=this.totalPage;
		return re;
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
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getIndexCount() {
		return indexCount;
	}
	public void setIndexCount(int indexCount) {
		this.indexCount = indexCount;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
