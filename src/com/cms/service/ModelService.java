package com.cms.service;

import java.sql.SQLException;
import java.util.List;

import com.cms.pojo.Model;
import com.cms.pojo.ModelItem;

public interface ModelService {

	/**
	 * 增加一个模型
	 * @param model
	 * @throws SQLException
	 */
	public void addModel(Model model)throws SQLException;
	/**
	 * 查询数据库中所有的模型
	 * @return
	 * @throws SQLException
	 */
	public List<Model> getAllModel()throws SQLException;
	/**
	 * 从数据库找一个模型
	 * @return
	 * @throws SQLException
	 */
	public Model getModelById(int id)throws SQLException;
	/**
	 * 修改模型
	 * @throws SQLException
	 */
	public void updateModel(Model model)throws SQLException;
	/**
	 * 根据模型id取模型对应字段列表
	 * @param mid 模型ID
	 * @param vdata 0可用字段1不可用字段
	 * @return
	 * @throws SQLException
	 */
	public List<ModelItem> getModelItem(int mid,int valid)throws SQLException;
	/**
	 * 
	 * @param mid model_item id
	 * @param vdata 0或1
	 * @throws SQLException
	 */
	public void setValidField(int mid,int vdata)throws SQLException;
	/**
	 * 更新模型字段列表
	 * @param mi
	 * @throws SQLException
	 */
	public void updateField(ModelItem mi)throws SQLException;
	/**
	 * 根据字段列表id取字段列表
	 * @param miid
	 * @return
	 * @throws SQLException
	 */
	public ModelItem getModelItemById(int miid)throws SQLException;
	
	

	
}

