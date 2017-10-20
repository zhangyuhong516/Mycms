<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*,com.cms.pojo.*" %>
    <%@taglib uri="http://www.cms/tags" prefix="cms"%>
  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<%@include file="header.jsp" %>
		<style type="text/css">
			body{font-family: "微软雅黑";}
		</style>
		<title>RedCMS后台管理系统-管理栏目</title>
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
							<li><a href="#">栏目</a></li>
							<li class="action">栏目管理</li>
						</ol>
					</div>
					 <div><!-- 内容区 -->

                       <!-- 增加栏目的Panel -->
                       <div class="panel panel-default">
                       	<div class="panel-heading">
                       		<h3 class="panel-title">栏目管理</h3>
                       	</div>
                       	<table class="table table-striped table-bordered table-hover table-responsive">
  							<tr align='center'>
  								<th class="info" align='center'>序号</th>
  								<th class="info" align='center'>栏目名称</th>
  								<th class="info" align='center'>模型</th>
  								<th class="info" align='center'>排序</th>
  								<th class="info" align='center'>管理</th>
  							</tr>
  							
  							<cms:allChannelList/>
						</table>
                       </div>

  					</div><!-- 内容区结束 --> 
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
