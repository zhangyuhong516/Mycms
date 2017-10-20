<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.cms/tags" prefix="cms"%>
    <%String[] indexs=(String[])request.getAttribute("indexs");
    String[] lists=(String[])request.getAttribute("lists");
    String[] contents=(String[])request.getAttribute("contents");
    
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<%@include file="header.jsp" %>
		<title>RedCMS后台管理系统</title>
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
							<li><a href="#">模型</a></li>
							<li class="action">增加内容</li>
						</ol>
					</div>
					 <div><!-- 内容区 -->

                       <!-- 增加模型的Panel -->
                       <div class="panel panel-default">
                       	<div class="panel-heading">
                       		<h3 class="panel-title">增加模型</h3>
                       	</div>
                       	<div class="panel-body">
                       	<form action="model" method="post">
                       	 <input type="hidden" name="action" value="saveAdd">
                       		<div class="form-inline form-group">
                       			<label>模型的名字：</label>
                       			 <input type="text" class="form-control" name="name"/>
                       			<label>是否默认：</label>
                       			 <input type="checkbox" class="form-control" name="isdef" value="1"/>
                       		</div>
                       		<div class="form-group">
                       			<label>模型描述：</label>
                       			 <textarea rows="3" cols="30" class="form-control" name="descri"></textarea>	
                       		</div>
                       		<div class="form-inline form-group">
                       			<label>首页模板：</label>
                       			<select class="form-control" name="index_tem">
                       			<%if(null!=indexs&&indexs.length>0)
                       			{
                       				for(String tem:indexs)
                       				{
                       					%>
                       					<option value="<%=tem %>"><%=tem %></option>
                       					<%
                       				}
                       			}
                       			
                       			%>
                       			</select>
                       			<label>列表模板：</label>
                       			<select class="form-control" name="list_tem">
                       			<%if(null!=lists&&lists.length>0)
                       			{
                       				for(String tem:lists)
                       				{
                       					%>
                       					<option value="<%=tem %>"><%=tem %></option>
                       					<%
                       				}
                       			}
                       			
                       			%>
                       			</select>
                       			<label>内容模板：</label>
                       			<select class="form-control" name="content_tem">
                       			<%if(null!=contents&&contents.length>0)
                       			{
                       				for(String tem:contents)
                       				{
                       					%>
                       					<option value="<%=tem %>"><%=tem %></option>
                       					<%
                       				}
                       			}
                       			
                       			%>
                       			</select>
                       		</div>
                       		<div class="form-group" style="text-align: center;">
                       			<button type="submit" class="btn btn-primary">增加新模型</button>
                       		</div>
                       		</form>
                       	</div>
                       </div>

  					</div><!--panel-body  --><!-- 内容区结束 --> 
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
