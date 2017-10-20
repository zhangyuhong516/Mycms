package com.cms.pojo;

import java.io.Serializable;

public class Model implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1545008553826720064L;
	private int id;
	private String name;
    private String descri;
	private String index_tem;
	private String list_tem;
	private String content_tem;
	private int isdef;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescri() {
		return descri;
	}
	public void setDescri(String descri) {
		this.descri = descri;
	}
	public String getIndex_tem() {
		return index_tem;
	}
	public void setIndex_tem(String index_tem) {
		this.index_tem = index_tem;
	}
	public String getList_tem() {
		return list_tem;
	}
	public void setList_tem(String list_tem) {
		this.list_tem = list_tem;
	}
	public String getContent_tem() {
		return content_tem;
	}
	public void setContent_tem(String content_tem) {
		this.content_tem = content_tem;
	}
	public int getIsdef() {
		return isdef;
	}
	public void setIsdef(int isdef) {
		this.isdef = isdef;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
