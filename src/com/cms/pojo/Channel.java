package com.cms.pojo;

import java.io.Serializable;
import java.util.Date;

public class Channel implements Serializable {
	private int id;
	private int model_id;
	private int parent_id;
	private String name;
	private String path;
	private int level=99;
	private String pic1;
	private String pic2;
	private String links;
	private Date createtime;
	private String index_tem;
	private String list_tem;
	private String content_tem;
	private String discri;
	private String discri_pics;
	private String meta_title;
	private String meta_key;
	private String meta_des;
	private String modelName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getModel_id() {
		return model_id;
	}
	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getPic1() {
		return pic1;
	}
	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}
	public String getPic2() {
		return pic2;
	}
	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}
	public String getLinks() {
		return links;
	}
	public void setLinks(String links) {
		this.links = links;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
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
	public String getDiscri() {
		return discri;
	}
	public void setDiscri(String discri) {
		this.discri = discri;
	}
	public String getDiscri_pics() {
		return discri_pics;
	}
	public void setDiscri_pics(String discri_pics) {
		this.discri_pics = discri_pics;
	}
	public String getMeta_title() {
		return meta_title;
	}
	public void setMeta_title(String meta_title) {
		this.meta_title = meta_title;
	}
	public String getMeta_key() {
		return meta_key;
	}
	public void setMeta_key(String meta_key) {
		this.meta_key = meta_key;
	}
	public String getMeta_des() {
		return meta_des;
	}
	public void setMeta_des(String meta_des) {
		this.meta_des = meta_des;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	
}
