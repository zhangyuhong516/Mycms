<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cms" uri="http://www.cms/web/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>镇坪县城关小学_<cms:contentsInfo pname="title" cid="${contents.id}"/></title>
		<link rel="stylesheet" href="../../css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="../../css/bootstrap.min.css" />
		<script type="text/javascript" src="../../js/jquery-1.12.1.min.js" ></script>
		<script type="text/javascript" src="../../js/bootstrap.min.js" ></script> 
		<style type="text/css">
			#bs-example-navbar-collapse-1{ }
			#bs-example-navbar-collapse-1 ul{ margin-top: 30px; margin-right: 50px;}
			#bs-example-navbar-collapse-1 ul li a{font-family: "微软雅黑"; color: black; font-weight: 18px; font-weight: bold;}
			#bs-example-navbar-collapse-1 ul li a:hover{ text-decoration: underline;}
			
			.panel-title{ font-size: 16px; font-weight: bold;}
			.list-group-item{ margin-left: 10px;}
			.list-group-item a{ color: black; font-size: 14px; font-weight: bold;}
			
			.article_list{ padding: 0; margin-left: 10px;}
			.article_list{ list-style-type:circle;}
			.article_list li{line-height: 40px; border-bottom: 1px #ccc dashed;}
			.article_list li a{ color: black;}
			.article_list li a:hover{ text-decoration: underline;}
			
			 footer{ background: black; color: white; margin-top: 25px; text-align: center;}
		    footer ul{ list-style: none;  float: right; margin-right: 80px;}
		    footer ul li{ float: left;}
		    footer ul li a{ color: white; padding: 10px; line-height: 50px;}
		    footer ul li a:hover{ text-decoration: underline; color: white;}
		</style>
	</head>
	<body>
	<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
	        <div class="navbar-header" style="height: 100px; line-height: 100px;">
	             <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        
	            <a class="navbar-brand" href="/index.html">
	                <img src="../../img/logo2.png" width="306" height="64"></a>
	        </div>
        <div class="collapse navbar-collapse"  id="bs-example-navbar-collapse-1">
      <!--       <ul id="mainNav" class="nav navbar-nav navbar-right" >
                             <li role="presentation"><a href="#">首页</a></li> 
							  <li role="presentation"><a href="#">学校概况</a></li>
							  <li role="presentation"><a href="#">校园动态</a></li>
							  <li role="presentation"><a href="#">德育之窗</a></li>
							  <li role="presentation"><a href="#">教学教研</a></li>
							  <li role="presentation"><a href="#">师生家园</a></li>
							  <li role="presentation"><a href="#">特色强校</a></li>
							   <li role="presentation"><a href="#">资源下载</a></li>
							    <li role="presentation"><a href="#">联系我们</a></li>
            </ul> -->
            <%@include file="./nav.jsp" %>
        </div>
    </div>
</nav>

<!--图片轮播-->
<div class="container" style=" margin-top: 0;">
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
		  <!-- Indicators -->
		  <ol class="carousel-indicators">
		    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
		  </ol>

		  <!-- Wrapper for slides -->
		  <div class="carousel-inner" role="listbox">
			    <div class="item active">
			      <img src="../../img/ad06.jpg" >
			      <div class="carousel-caption">
			      </div>
			    </div>
			 <!--    <div class="item">
			      <img src="../../img/ad02.jpg" >
			      <div class="carousel-caption">
			      </div>
			    </div> -->
		  </div>
	</div>		
</div>
      <!--
      	作者：langyamoren@163.com
      	时间：2016-04-28
      	描述：转播完
      -->
      <div class="container" style="margin-top: 20px;">
      	<div class="row">
      
      		<div class="col-sm-9">
      			  
      			  <div class="panel panel-default" class="chan_list">
						  <div class="panel-heading">
						  
						    <h3 class="panel-title"><a href="<cms:rootpath/>">首页</a>&nbsp;&gt;&nbsp;
						    <a href="../<cms:channelInfo pname="path" cid="${parentChannel.id}"/>/index.html"><cms:channelInfo pname="name" cid="${parentChannel.id}"/></a>&nbsp;&gt;&nbsp;
						    <a href="./list_1.html"><cms:channelInfo pname="name" cid="${channel.id}"/></a>	</h3>
						  </div>
						
                          <div class="panel-body">
	<h1><cms:contentsInfo pname="title" cid="${contents.id}"/></h1>
     <h3><cms:contentsInfo pname="createtime" cid="${contents.id}"/></h3>
     <hr/>
     <p>
       <cms:contentsInfo pname="txt" cid="${contents.id}"/>
     </p>         
						  </div>

						
						</div>
      			
      		</div>
      				<div class="col-sm-3">
						<div class="panel panel-default" class="chan_list">
						  <div class="panel-heading">
						    <h3 class="panel-title"><cms:channelInfo pname="name" cid="${channel.id}"/></h3>
						  </div>
						<!--  <div class="panel-body">
						
						  </div>-->
						  <ul class="list-group">
						    <cms:contentsList channelId="${channel.id}" top="6">
						     
						     <li class="list-group-item">
                             <a href="./article_${channel.id}_<cms:property pname="id"/>.html"><cms:property pname="title"/></a>
                             </li>
						    </cms:contentsList>
						  </ul>
						</div>
      		</div>
      	</div>
      </div>
      
      <footer id="footer">
	<div class="container-fluid">
		<div  class="row">
				<div class="col-md-12">
				 <ul>      
				 	<li><a href="./html/aboutxx/53_8.html" style="border:none;">学校概况</a></li>      
				 	<li><a href="./html/edunews/list_1.html">校园动态</a></li>      
				 	<li><a href="./html/dangyuanfc/list_1.html">党群建设</a></li>      
				 	<li><a href="./html/changguiedu/list_1.html">教学教研</a></li>      
				 	<li><a href="./html/eduactive/list_1.html">德育之窗</a></li>      
				 	<li><a href="./html/fazhanguihua/list_1.html">校务公开</a></li>      
				 	<li><a href="./html/mingshi/list_1.html">师生家园</a></li>      
				 	<li><a href="./html/reddiantai/list_1.html">视频在线</a></li>      
				 	<li><a href="./html/coursedown/list_1.html">资源下载</a></li>      
				 	<li><a href="./html/jiazhangxx/list_1.html">家校互动</a></li>      
				 	<li><a href="./html/xywenghua/list_1.html">特色强校</a></li>      
				 	<li><a href="./html/shuanggaoshuangpu/list_1.html">学校创建</a></li>      
				 	<li><a href="./html/aboutxx/53_1.html">联系我们</a></li>  
				 </ul>
				 </div>
		</div>
		<div class="row clearfix">
			<div class="col-md-3">
				<p style="margin: 10px auto; font-size: 26px; font-weight: bold; font-family: '微软雅黑';">镇坪城关小学</p>
			</div>
			<div class="col-md-9">
				<p>Copyright(C)2014-2017 All Rights Reserved </p>
				<p>陕西省镇坪县城关小学 电话：0915-8822340 传真：0915-8822340 邮箱：39767182@qq.com</p>
			</div>
		</div>
	</div>
</footer>
	</body>
</html>
