package com.cms.pojo;

import java.io.Serializable;

public class ModelItem implements Serializable 
{
	private int id;
	private int model_id;
	private String fname;
	private String showlab;
	private int level;
	private String def_value;
	private int valid;
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
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getShowlab() {
		return showlab;
	}
	public void setShowlab(String showlab) {
		this.showlab = showlab;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getDef_value() {
		return def_value;
	}
	public void setDef_value(String def_value) {
		this.def_value = def_value;
	}
	public int getValid() {
		return valid;
	}
	public void setValid(int valid) {
		this.valid = valid;
	}
	
}
