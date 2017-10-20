<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://www.cms/tags" prefix="cms"%>
     <%!
     String tblWidth="700";
     String tblAlign="center";
     String strOS=System.getProperty("os.name");
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
							<li><a href="#">栏目</a></li>
							<li><a href="#">内容</a></li>
						</ol>
					</div>
					<div>
				 	<table width="100%" align="center"   border="0" cellspacing="0" cellpadding="1">
					   <tr>
					     <td colspan="2" height="22" bgcolor="#E0E0E0"><div align="center"><strong>欢迎使用RedCMS系统</strong></div></td>
					   </tr>
				      <tr>
				     	<td height="23" width="20%" >&nbsp;服务器名称</td>
				      </tr>
					  <tr>
					     <td height="23" width="20%" >&nbsp;域名/IP </td>
					  </tr>
					  <tr>
					     <td height="23">&nbsp;服务器端口 </td>
					  </tr>
					  <tr>
					     <td height="23">&nbsp;客户端端口 </td>
					  </tr>
					  <tr>
					     <td height="23">&nbsp;客户端IP </td>
					  </tr>
					  <tr>
					     <td height="23">&nbsp;Web 服务器 </td>  
					  </tr>
  
					  <tr>
					     <td height="23">&nbsp;操作系统 </td>  
					  </tr>
					  <tr>
					     <td height="23">&nbsp;服务器时间 </td>
					  </tr>
					  <tr>
					     <td height="23" width="20%" >&nbsp;CPU 信息 </td>
					  </tr>
					  <tr>
					     <td height="23" width="20%" >&nbsp;磁盘分区 </td>
					  </tr>
					  <tr>
					     <td height="23" width="20%" >&nbsp;用户当前工作目录 </td>
					  </tr>
					  <tr>
					     <td height="23">&nbsp;本文件路径 </td>
					  </tr>
					</table>
					<br>
					<table width="" align="center"   border="0" cellspacing="0" cellpadding="1">
					  <tr>
					     <td colspan="2" height="22" bgcolor="#E0E0E0"><span> 相关信息</span></span> </td>
					  </tr>
					  <tr>
					     <td height="23" width="20%" ><span> 版本</span> </td>
					  </tr>
					  <tr>
					     <td height="23" width="20%" >&nbsp;Servlet 版本 </td>
					  </tr>
					  <tr>
					     <td height="23" width="20%" >&nbsp;JDK 安装路径 </td>
					  </tr>
					  <tr>
					     <td height="23" width="20%" >&nbsp;编码 </td>
					  </tr>
					  <tr>
					     <td height="23" width="20%" >&nbsp;JAVA类路径 </td>
					  </tr>
					</table>
					<br>
					<table width="" align="center"   border="0" cellspacing="0" cellpadding="1">
					  <tr>
					     <td colspan="2" height="22" bgcolor="#E0E0E0">&nbsp;服务器环境变量 &nbsp;</td>
					  </tr>
					  <tr>
					  </tr>
					</table>
  
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
