<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.cms.pojo.*"%>
<%@taglib uri="http://www.cms/tags" prefix="cms"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="header.jsp"%>
<title>RedCMS后台管理系统-模型字段管理</title>
<style type="text/css">
body {
	font-family: "微软雅黑";
}
</style>

</head>
<body>
	<%@include file="top.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-3">
				<%@include file="left.jsp"%>
			</div>
			<div class="col-sm-9">
				<div class="nav">
					<ol class="breadcrumb" id="aaa">
						<li><a href="#">首页</a></li>
						<li><a href="model">模型</a></li>
						<li class="action">模型字段管理</li>
					</ol>
				</div>
				<div>
					<!-- 内容区 -->
				<%
				Model model=(Model)request.getAttribute("model");
				%>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title"><mark><%=model.getName() %></mark>内容字段列表</h3>
						</div>

						<table class="table table-striped table-hover">
							<tr>
								<th colspan="2">字段</th>
								<th>显示名称</th>
								<th>默认值</th>
								<th>管理</th>
							</tr>
							<%
							List<ModelItem> list0=(List<ModelItem>)request.getAttribute("list0");
							if(null!=list0&&list0.size()>0)
							{
								for(ModelItem mi:list0)
								{
									%>
								<form method="post" action="model">
								<input type="hidden" name="action" value="updateField"/>
								<input type="hidden" name="id" value="<%=mi.getId()%>"/>
								<input type="hidden" name="mid" value="<%=mi.getModel_id()%>"/>
								
								<tr>
								<td><input type="checkbox" name="miid" value="<%=mi.getId()%>"/></td>
								<td><%=mi.getFname() %></td>
								<td><input type="text" name="showlab" value="<%=mi.getShowlab()%>"/></td>
								<td><input type="text" name="def_value" value="<%=mi.getDef_value() %>" /></td>
								<td>
									<button type="submit" class="btn btn-info btn-sm">更新</button>
									<a href="model?action=deleteField&id=<%=mi.getId()%>&mid=<%=mi.getModel_id()%>" class="btn btn-danger btn-sm">删除</a>
								</td>
							    </tr>
							    </form>
									<%
								}
							}
							%>
							


						</table>
						<table class="table table-striped table-hover">
							<tr>
								<th colspan="5">已删字段</th>

							</tr>
							<%
							List<ModelItem> list1=(List<ModelItem>)request.getAttribute("list1");
							if(null!=list1&&list1.size()>0)
							{
								for(ModelItem mi:list1)
								{
									%>
								<form method="post" action="model">
								<input type="hidden" name="action" value="restoreField"/>
								<input type="hidden" name="mid" value="<%=mi.getModel_id()%>"/>
								<input type="hidden" name="id" value="<%=mi.getId()%>"/>
								
								
								<tr>
								<td><input type="checkbox" name="XX" value="<%=mi.getId()%>"/></td>
								<td><%=mi.getFname() %></td>
								<td><%=mi.getShowlab()%></td>
								<td><%=mi.getDef_value()%></td>
								<td>
									<button type="submit" class="btn btn-primary">恢复</button>
								</td>
							    </tr>
							    </form>
									<%
								}
							}
							%>
						</table>
						<!--panel-body  -->
					</div>

				</div>
			</div>
		</div>
	</div>
	<footer class="container">
		<hr />
		<p align="center">
			RmsCMD后台管理界面&nbsp;&nbsp;<b>微信/QQ1396766036</b>
		</p>
	</footer>
	<cms:modalDialogTag />

</body>
</html>
