package com.cms.servlet.admin;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.pojo.Model;
import com.cms.pojo.ModelItem;
import com.cms.servlet.ServletBase;
import com.cms.utils.TemplateFileFilter;
@WebServlet("/admin/model")
public class ModelServlet extends ServletBase 
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<Model> molist=null;
	try {
		molist=modelService.getAllModel();
		
	} catch (SQLException e) {
		req.setAttribute("msg", "查询模型出错");
		e.printStackTrace();
	}
	req.setAttribute("modelList", molist);
	this.forward(req, resp, "admin/model_list.jsp");
		
	}
	public void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc=req.getServletContext();
		String realpath=sc.getRealPath("WEB-INF/template");
		String indexs[]=TemplateFileFilter.getTemplateFiles(realpath, "index");
		String lists[]=TemplateFileFilter.getTemplateFiles(realpath, "list");
		String contents[]=TemplateFileFilter.getTemplateFiles(realpath, "content");
		req.setAttribute("indexs", indexs);
		req.setAttribute("lists", lists);
		req.setAttribute("contents", contents);
		this.forward(req, resp, "admin/model_add.jsp");
	}
   public void saveAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Model model=new Model();
		this.getBean(req, model);
		
		try {
			modelService.addModel(model);
			req.setAttribute("msg", "增加模型成功");
			System.out.println("增加模型成功");
		} catch (SQLException e) {
			System.out.println("增加模型出错");
			req.setAttribute("msg", "增加模型出错");
			e.printStackTrace();
		}
		this.toAdd(req, resp);
	}
   public void editModel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc=req.getServletContext();
		String realpath=sc.getRealPath("WEB-INF/template");
		String indexs[]=TemplateFileFilter.getTemplateFiles(realpath, "index");
		String lists[]=TemplateFileFilter.getTemplateFiles(realpath, "list");
		String contents[]=TemplateFileFilter.getTemplateFiles(realpath, "content");
		req.setAttribute("indexs", indexs);
		req.setAttribute("lists", lists);
		req.setAttribute("contents", contents);
		int mid=this.getInt(req, "mid");
		Model model=null;
		if(mid>0)
		{
			try {
				model=modelService.getModelById(mid);
				req.setAttribute("model", model);
			} catch (SQLException e) {
				req.setAttribute("msg", "查询模型出错");
				e.printStackTrace();
			}
			
		}
		System.out.println(model);
		if(null!=model)
		{
			this.forward(req, resp, "admin/model_edit.jsp");
		}else
		{
			this.execute(req,resp);
		}
		
	}
   public void saveEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mid=this.getInt(req, "id");
		if(mid>0)
		{
			Model model=null;
			try {
				model=modelService.getModelById(mid);
			} catch (SQLException e) {
				req.setAttribute("msg", "修改模型失败1");
				e.printStackTrace();
			}
			if(null!=model)
			{
				this.getBean(req, model);
				
				try {
					modelService.updateModel(model);
					req.setAttribute("msg", "修改模型成功");
					
				} catch (SQLException e) {
					
					req.setAttribute("msg", "增加模型出错2");
					e.printStackTrace();
				}
				
			}
			this.execute(req, resp);
		}

		
	}
   public void fieldList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer reqid=(Integer) req.getAttribute("mid");
		int mid=this.getInt(req, "mid");
		if(mid<=0&&null!=reqid)
		{
			mid=reqid;
		}
	   
	   if(mid>0)
		{
			Model model=null;
			try {
				model=modelService.getModelById(mid);
				if(null!=model)
				{
					List<ModelItem> list0=modelService.getModelItem(mid, 0);
					List<ModelItem> list1=modelService.getModelItem(mid, 1);
					req.setAttribute("model", model);
					req.setAttribute("list0", list0);
					req.setAttribute("list1", list1);
					this.forward(req, resp, "admin/model_field.jsp");
				}else
				{
					this.execute(req, resp);
				}
			} catch (SQLException e) {
				req.setAttribute("msg", "查询字段列表出错");
				e.printStackTrace();
			}
			
		}else
		{
			this.execute(req, resp);
		}
	}
   
   public void  deleteField(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=this.getInt(req, "id");
		int mid=this.getInt(req, "mid");
		if(id>0)
		{
			try {
				modelService.setValidField(id, 1);
				req.setAttribute("msg", "删除字段成功");
			} catch (SQLException e) {
				req.setAttribute("msg", "删除字段失败");
				e.printStackTrace();
			}
		}
		this.fieldList(req, resp);
	}
   public void  updateField(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=this.getInt(req, "id");
		int mid=this.getInt(req, "mid");
		req.setAttribute("mid", mid);
		try {
			if(id>0)
			{
				ModelItem mi=null;
				mi=modelService.getModelItemById(id);
				this.getBean(req, mi);
				modelService.updateField(mi);
				req.setAttribute("msg", "更新字段列表成功");
			}
		} catch (SQLException e) {
			req.setAttribute("msg", "更新字段列表失败");
			e.printStackTrace();
		}
		this.fieldList(req, resp);
	}
   public void  restoreField(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=this.getInt(req, "id");
		int mid=this.getInt(req, "mid");
		req.setAttribute("mid", mid);
		if(id>0)
		{
			try {
				modelService.setValidField(id, 0);
				req.setAttribute("msg", "恢复字段成功");
			} catch (SQLException e) {
				req.setAttribute("msg", "恢复字段失败");
				e.printStackTrace();
			}
		}
		this.fieldList(req, resp);
	}
   
 
   
	
	
}
