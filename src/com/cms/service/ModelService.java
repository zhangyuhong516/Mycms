package com.cms.service;

import java.sql.SQLException;
import java.util.List;

import com.cms.pojo.Model;
import com.cms.pojo.ModelItem;

public interface ModelService {

	/**
	 * ����һ��ģ��
	 * @param model
	 * @throws SQLException
	 */
	public void addModel(Model model)throws SQLException;
	/**
	 * ��ѯ���ݿ������е�ģ��
	 * @return
	 * @throws SQLException
	 */
	public List<Model> getAllModel()throws SQLException;
	/**
	 * �����ݿ���һ��ģ��
	 * @return
	 * @throws SQLException
	 */
	public Model getModelById(int id)throws SQLException;
	/**
	 * �޸�ģ��
	 * @throws SQLException
	 */
	public void updateModel(Model model)throws SQLException;
	/**
	 * ����ģ��idȡģ�Ͷ�Ӧ�ֶ��б�
	 * @param mid ģ��ID
	 * @param vdata 0�����ֶ�1�������ֶ�
	 * @return
	 * @throws SQLException
	 */
	public List<ModelItem> getModelItem(int mid,int valid)throws SQLException;
	/**
	 * 
	 * @param mid model_item id
	 * @param vdata 0��1
	 * @throws SQLException
	 */
	public void setValidField(int mid,int vdata)throws SQLException;
	/**
	 * ����ģ���ֶ��б�
	 * @param mi
	 * @throws SQLException
	 */
	public void updateField(ModelItem mi)throws SQLException;
	/**
	 * �����ֶ��б�idȡ�ֶ��б�
	 * @param miid
	 * @return
	 * @throws SQLException
	 */
	public ModelItem getModelItemById(int miid)throws SQLException;
	
	

	
}

