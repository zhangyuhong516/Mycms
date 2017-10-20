package com.cms.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;

import com.cms.partupload.PartException;
import com.cms.partupload.PartUtil;
import com.cms.servlet.ServletBase;
@MultipartConfig
@WebServlet("/admin/upload_pic")
public class UploadPictureServlet extends ServletBase {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out=resp.getWriter();
		Part part=req.getPart("imgFile");
		String realPath=this.getServletContext().getRealPath("uppics");
		System.out.println(realPath);
		PartUtil pu=new PartUtil(part,"image/jpeg,image/gif,image/bmp,image/png",".jpg,.bmp,.gif,.png",realPath,1024*1024*2);
		try {
			pu.upload();
		} catch (PartException e) {
			out.println(getError("上传文件失败"+e));
			e.printStackTrace();
		}
		
		JSONObject obj=new JSONObject();
		obj.put("error",0);
		obj.put("url", req.getContextPath()+"/uppics/"+pu.getNewName());
		out.println(obj.toJSONString());
		out.close();

	}
	private String getError(String message)
	{
		JSONObject obj=new JSONObject();
		obj.put("error",1);
		obj.put("message",message);
		return obj.toJSONString();
	}

}
