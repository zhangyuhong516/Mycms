package com.cms.service.imp;


import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cms.dao.core.ConnectionManager;
import com.cms.pojo.Model;
import com.cms.pojo.ModelItem;
import com.cms.service.ModelService;
import com.cms.service.ServiceBase;

public class ModelServiceImp extends ServiceBase implements ModelService {

	@Override
	public void addModel(Model model) throws SQLException {
		Connection con=ConnectionManager.getInstance().getConnection();
		
		
		
			String sql="insert into  model(name,descri,index_tem,list_tem,content_tem,isdef) values(?,?, ?, ?, ?, ?)";
			Object[] param=new Object[]{model.getName(),model.getDescri(),model.getIndex_tem(),model.getList_tem(),model.getContent_tem(),model.getIsdef()};
			run.update(con, sql,param);
			BigInteger longLastid=(BigInteger)run.query(con, "select LAST_INSERT_ID()", new ArrayHandler())[0];
			int lastId=longLastid.intValue();
			String sql2="insert into model_item(model_id,fname,showlab,level,def_value,valid) values(?,?,?,?,?,?)";
			Object params[][]=new Object[][]{
				{lastId,"tags","��ǩ",99,"",0},
				{lastId,"origin","��Դ",99,"ԭ��",0},
				{lastId,"origin_url","��ԴURL",99,"",0},
				{lastId,"discri","����",99,"",0},
				{lastId,"level","����",99,"",0},
				{lastId,"titlecolor","������ɫ",99,"",0},
				{lastId,"links","����",99,"",0},
				{lastId,"content_tem","����ģ��",99,"",0},
				{lastId,"isrecom","�Ƿ��Ƽ�",99,"",0},
				{lastId,"pic1","ͼ1",99,"",0},
				{lastId,"pic2","ͼ2",99,"",0},
				{lastId,"pic3","ͼ3",99,"",0},
				{lastId,"extstr1","��չ�ַ���1",99,"",0},
				{lastId,"extstr2","��չ�ַ���1",99,"",0},
				{lastId,"extint1","��չ����1",99,"",0},
				{lastId,"extint2","��չ����2",99,"",0},
				{lastId,"mutifiles","�Ƿ�฽���ϴ�",99,"",0},
				{lastId,"nutipics","�Ƿ��ͼƬ�ϴ�",99,"",0}
			};
			run.batch(con, sql2, params);
			
		
	
	}

	@Override
	public List<Model> getAllModel() throws SQLException {
		String sql="select * from model";
		List<Model> list=null;
		list=run.query(ConnectionManager.getInstance().getConnection(), sql, new BeanListHandler<Model>(Model.class));
		return list;
		
	}
	@Override
	public Model getModelById(int id) throws SQLException 
	{
		String sql="select * from model where id=?";
		Model model=null;
		model=run.query(ConnectionManager.getInstance().getConnection(), sql,new BeanHandler<Model>(Model.class),id);
		return model;
	}


	@Override
	public void updateModel(Model model) throws SQLException {
		String sql="update model set name=?,descri=?,index_tem=?,list_tem=?,content_tem=?,isdef=?";
		Object[] param=new Object[]{model.getName(),model.getDescri(),model.getIndex_tem(),model.getList_tem(),model.getContent_tem(),model.getIsdef(),model.getId()};
		run.update(ConnectionManager.getInstance().getConnection(), sql, param);
		
	}

	@Override
	public List<ModelItem> getModelItem(int mid,int valid)throws SQLException{
		String sql="select * from model_item where model_id=? and valid=?";
		List<ModelItem> list=null;
		list=run.query(ConnectionManager.getInstance().getConnection(),sql,new BeanListHandler<ModelItem>(ModelItem.class),mid,valid);
		return list;
	}

	@Override
	public void setValidField(int mid, int vdata) throws SQLException {
		String sql="update model_item set valid=? where id=?";
		run.update(ConnectionManager.getInstance().getConnection(),sql,vdata,mid);	
	}

	@Override
	public void updateField(ModelItem mi) throws SQLException {
		String sql="update model_item set showlab=?,level=?,def_value=? where id=?";
		Object[] param=new Object[]{mi.getShowlab(),mi.getLevel(),mi.getDef_value()};
		run.update(ConnectionManager.getInstance().getConnection(),sql, param);
		
	}

	@Override
	public ModelItem getModelItemById(int miid) throws SQLException {
		String sql="select * form model_item where id=?";
		ModelItem mi=null;
		mi=run.query(ConnectionManager.getInstance().getConnection(),sql, new BeanHandler<ModelItem>(ModelItem.class),miid);
		return mi;
		
	}

	
}
