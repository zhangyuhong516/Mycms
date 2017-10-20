<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,com.cms.pojo.*" %>
    <%@taglib uri="http://www.cms/tags" prefix="cms"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<%@include file="header.jsp" %>
		<title>RedCMS后台管理系统-管理模型</title>
		<style type="text/css">
			body{font-family: "微软雅黑";}
		</style>
		
	</head>
	<body>
		<%@include file="top.jsp" %>
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-3">
					<%@include file="left.jsp" %>
				</div>
				<div class="col-sm-9">
					<div class="nav">
						<ol class="breadcrumb" id="aaa">
							<li><a href="#">首页</a></li>
							<li><a href="model">模型</a></li>
							<li class="action">增加内容</li>
						</ol>
					</div>
					 <div><!-- 内容区 -->

                       <!-- 增加模型的Panel -->
                       <div class="panel panel-default">
                       	<div class="panel-heading">
                       		<h3 class="panel-title">模型管理</h3>
                       	</div>
                       <table class="table table-hover table-striped table-responsive">
				       <tr>
				       	<th>序号</th>
				       	<th>模型名</th>
				       	<th>是否默认</th>
				       	<th>首页模板</th>
				       	<th>列表模板</th>
				       	<th>内容模板</th>
				       	<th>管理</th>
				       </tr>  
				       <%
				       List<Model> list=(List<Model>)request.getAttribute("modelList");
				       int index=1;
				       if(null!=list&&list.size()>0)
				       {
				    	   for(Model model:list)
				    	   {
				    	   %>
				    	<tr>
				       	<td><%=index++ %></td>
				       	<td><%=model.getName() %></td>
						<td><%=model.getIsdef()==1?"默认":"" %></td>
						<td><%=model.getIndex_tem()%></td>
						<td><%=model.getList_tem() %></td>
						<td><%=model.getContent_tem() %></td>
	    				<td>
           <a href="model?action=editModel&mid=<%=model.getId() %>" class="btn btn-primary btn-sm">修改</a>
           <a href="model?action=delModel&mid=<%=model.getId() %>" class="btn btn-danger btn-sm">删除</a>
           <a href="model?action=fieldList&mid=<%=model.getId() %>" class="btn btn-success btn-sm">字段列表</a>
				        </td>
				       </tr>
				    	   
				    	   <% 
				    	   }
				       }
				       %>
				      
       </table>	

  					 </div><!--panel-body  --><!-- 内容区结束 --> 
				</div>
			</div>
		</div>
	</div>
		<footer class="container">
			<hr />
			<p align="center">RmsCMD后台管理界面&nbsp;&nbsp;<b>微信/QQ1396766036</b></p>
		</footer>
		<cms:modalDialogTag/>
		
	</body>
</html>
