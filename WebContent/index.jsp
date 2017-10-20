<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cms" uri="http://www.cms/web/tags" %>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
		<link rel="stylesheet" href="css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前端首页</title>
</head>
<body>
<cms:rootpath/>
<hr/>
<a href="<cms:rootpath/>">首页</a>
<hr/>
<cms:channelInfo pname="name" cid="2"/>____<cms:channelInfo pname="path" cid="2"/>
<hr/>
<%-- <ul>
<cms:channelList parentId="4">
  <li><cms:property pname="id"/>____<cms:property pname="name"/>____<cms:property pname="path"/></li>
</cms:channelList>
</ul>
<hr/>
<ul>
<cms:channelList isParent="true" parentId="4">
  <li><cms:property pname="id"/>____<cms:property pname="name"/>____<cms:property pname="path"/></li>
</cms:channelList>
</ul> --%>
<hr/>
<h1>标题:<cms:contentsInfo pname="title" cid="37"/></h1>
<h3>日期:<cms:contentsInfo pname="createtime"  cid="37"/></h3>
<p>
  <cms:contentsInfo pname="txt" cid="37"/>
</p>
<hr/>
<ul>
<%
 int pageNo=null!=request.getParameter("pageNo")?Integer.parseInt(request.getParameter("pageNo")):1;
 

%>
<cms:contentsList byPage="true" channelId="7" pageNo="<%=pageNo%>" pageSize="3">
   <li><cms:property pname="id"/>____<cms:property pname="title"/>-<cms:property pname="createtime"/></li>
</cms:contentsList>

</ul>
<cms:showPage url="http://localhost/Mycms/index.jsp"/>
</body>
</html>