package com.cms.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.cms.dao.core.ConnectionManager;
import com.cms.pojo.ModelItem;

public class ServiceBase 
{
	protected ConnectionManager cm=ConnectionManager.getInstance();
	protected QueryRunner run=new QueryRunner();
	
	
}
