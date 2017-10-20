package com.cms.pojo;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable 
{
	/**
	 * 管理员信息
	 */
	private static final long serialVersionUID = -5669271408398780142L;
	private int id;
	private String email;
	private String name;
	private String passwd;
	private String lastip;
	private Date  lasttime;
	private int activation;
	private String purview;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getLastip() {
		return lastip;
	}
	public void setLastip(String lastip) {
		this.lastip = lastip;
	}
	public Date getLasttime() {
		return lasttime;
	}
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	public int getActivation() {
		return activation;
	}
	public void setActivation(int activation) {
		this.activation = activation;
	}
	public String getPurview() {
		return purview;
	}
	public void setPurview(String purview) {
		this.purview = purview;
	}
	

}
