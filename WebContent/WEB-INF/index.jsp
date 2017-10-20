<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="cms" uri="http://www.cms/web/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>镇坪县城关小学</title>
		<link rel="stylesheet" href="css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery-1.12.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script> 
		<style type="text/css">
			body{ font-family: "微软雅黑"; font-size: 14px;}
			nav{ margin-bottom: 10px;}
			#bs-example-navbar-collapse-1{}
			#bs-example-navbar-collapse-1 ul{ margin-top: 30px; margin-right: 50px;}
			#bs-example-navbar-collapse-1 ul li a{font-family: "微软雅黑"; color: black; font-weight: 18px; font-weight: bold;}
			#bs-example-navbar-collapse-1 ul li a:hover{ text-decoration: underline;}
			
			
			#zpnav li a { font-weight: bold;}
			#noticelist{ padding-bottom: 0;}
			#noticelist ul{ padding:0; list-style-type:circle; margin-left:10px;}
			#noticelist ul li a{ line-height:28px; color: #0F0F0F;}
			
			#shcoolabout{ border: 1px cadetblue solid; border-radius:5px;}
			#shcoolabout p{ font-size: 14px; line-height:30px; overflow: hidden;}
			
			.artlist{ margin: 0 auto; background: #eaeaea; border-radius:5px; padding: 8px; margin-bottom:20px; }
			.artlist:hover .icontit{ background: white; color: orangered;} 
			.artlist h4{ font-weight: bold; margin-left:10px; }
			.artlist ul{ padding:0; margin-left:28px;list-style-type:circle;}
			.artlist ul li a{ line-height: 29px; color: #000000;}
			
			.artlist .icontit{margin-left: 3px; border: 1px orangered solid; margin-top:10px;vertical-align:top;font-size:16px;color:white; padding:10px; text-align: center;  background: orangered;}
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
	                <img src="./img/logo2.png" width="306" height="64"></a>
	        </div>
        <div class="collapse navbar-collapse"  id="bs-example-navbar-collapse-1">
         <%@include file="./template/nav.jsp" %>
        </div>
    </div>
</nav>
<hr />
<!--图片轮播-->
<div class="container">
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
		  <!-- Indicators -->
		  <ol class="carousel-indicators">
		    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
		  </ol>

		  <!-- Wrapper for slides -->
		  <%int index=1;  %>
		    <div class="carousel-inner" role="listbox">
		     <cms:contentsList channelId="2" top="3">
		        <%
		           if(index++==1)
		           {
		        %>
		        <div class="item active">
		        <%
		           }else
		           {
		        	   %>
		        	   <div class="item">
		        	   <%
		           }
		        %>
			       <img src="<cms:property pname="pic1"/>"/>
			      <div class="carousel-caption">
			      </div>
			    </div>
			 </cms:contentsList>
		  </div>

  <!-- Controls -->
<!--  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>-->
	</div>		
</div>
      <!--
      	作者：langyamoren@163.com
      	时间：2016-04-28
      	描述：转播完
      -->
<!--公告和学校简介-->
<div class="container" style="margin-top:20px;">
	<div class="row">
		<div class="col-md-3">
			    <div class="panel panel-default">
					  <div class="panel-heading">
					    <h3 class="panel-title">校园公告<span class="pull-right"><a href="./html/<cms:channelInfo pname="path" cid="6"/>/list_1.html">more>></a></span></h3>
					  </div>
						<div id="noticelist" class="panel-body">
						  <ul class="list-group">
						  <cms:contentsList channelId="6" top="5">
						  <li><a href="./html/<cms:channelInfo pname="path" cid="6"/>/article_6_<cms:property pname="id"/>.html"><cms:property pname="title"/></a></li>
						  </cms:contentsList>
						  <!--   
						    <li><a href="#">五一放假通知</a></li>
						    <li><a href="#">假期安全告知。。</a></li>
						    <li><a href="#">小升初注意事项发布</a></li>
						    <li><a href="#">小升初注意事项发布小升初</a></li> -->
						  </ul>
						</div>

				</div><!--end panel-->
		</div><!--end col-md3-->
		<div id="shcoolabout" class="col-md-9" style="background: url(img/aboutschool.jpg) no-repeat;">
			<!--学校概况-->
			 
			 <p style="display: inline-block; margin-top: 50px;">
			 <img src="img/info01.jpg" class="img-responsive img-thumbnail pull-left" style="margin-right:10px;"/>
			 	秦巴山间，南江河畔，坐落着镇坪县城关小学，
	     	学校北与县文化广场隔街相望，南与碧波荡漾
	     	的南江河和景观桥交相辉映。学校始建于1956年，
	     	是一所环境优雅、文化浓郁、内涵丰富，部室齐全、
	     	布局合理，具有现代化办学水平的县直小学.
	     	
	     	现有在编教职工44人（其中：中学高级教师1人，小学高级教师16人，小学一级教师26人；大专以上学历38人），有省、市优秀教育工作者7人
	     	<a class="btn btn-primary btn-xs pull-right" href="html/schoolinfo/article_3_1.html" role="button">详细信息>></a>
	     	
	     	</p>
	     	
		</div><!--col-md-9-->
		<!--广告语-->
		<div class="container" style="margin-bottom: 20px;">
			<img src="img/adtak.jpg" class="img-responsive" />
		</div>
		<!--栏目列表-->
		<div class="container">
			<div class="row" id="channelList">
				
					<div class="col-sm-6 col-md-4">
								<div class="artlist">
										   <div class="glyphicon glyphicon-leaf icontit" >
								  	       </div>
								  	   	   <div class="artlist" style="display:inline-block; vertical-align: top;">
								  	   	   	<h4><cms:channelInfo pname="name" cid="8"/></h4>
								  	   	   	<ul>
						<cms:contentsList channelId="8" top="5">
						  <li><a href="./html/<cms:channelInfo pname="path" cid="8"/>/article_8_<cms:property pname="id"/>.html"><cms:property pname="title"/></a></li>
						  </cms:contentsList>
												
												     
								  	   	   	</ul>
								  	   	   	<p> 	<a href="./html/<cms:channelInfo pname="path" cid="8"/>/list_1.html" class="btn btn-xs btn-info pull-right">more>></a></p></p>
								  	   	   </div>
								</div>
				</div>
				<div class="col-sm-6 col-md-4">
								<div class="artlist">
										 <span class="glyphicon glyphicon-eye-open icontit" >
								  	       </span>
								  	   	   <div class="artlist" style="display:inline-block;">
						<h4><cms:channelInfo pname="name" cid="7"/></h4>
								  	   	   	<ul>
						<cms:contentsList channelId="7" top="5">
						  <li><a href="./html/<cms:channelInfo pname="path" cid="7"/>/article_7_<cms:property pname="id"/>.html"><cms:property pname="title"/></a></li>
						  </cms:contentsList>
												     
								  	   	   	</ul>
								  	   	   	<p>	<a href="./html/<cms:channelInfo pname="path" cid="7"/>/list_1.html" class="btn btn-xs btn-info pull-right">more>></a></p></p>
								  	   	   </div>
								</div>
				</div>
				<div class="col-sm-6 col-md-4">
					           	<div class="artlist">
										 <span class="glyphicon glyphicon-tasks icontit" >
								  	       </span>
								  	   	   <div class="artlist" style="display:inline-block;">
								  	     	   	   	<h4><cms:channelInfo pname="name" cid="10"/></h4>
								  	   	   	<ul>
						<cms:contentsList channelId="10" top="5">
						  <li><a href="./html/<cms:channelInfo pname="path" cid="10"/>/article_10_<cms:property pname="id"/>.html"><cms:property pname="title"/></a></li>
						  </cms:contentsList>
												     
								  	   	   	</ul>
								  	   	   	<p> 	<a href="./html/<cms:channelInfo pname="path" cid="10"/>/list_1.html" class="btn btn-xs btn-info pull-right">more>></a></p></p>
								  	   	   </div>
								</div>
				</div>
				<div class="col-sm-6 col-md-4">
								<div class="artlist">
										 <span class="glyphicon glyphicon-tree-deciduous icontit" >
								  	       </span>
								  	   	   <div class="artlist" style="display:inline-block;">
								  	   	  	   	   	<h4><cms:channelInfo pname="name" cid="11"/></h4>
								  	   	   	<ul>
						<cms:contentsList channelId="11" top="5">
						  <li><a href="./html/<cms:channelInfo pname="path" cid="11"/>/article_11_<cms:property pname="id"/>.html"><cms:property pname="title"/></a></li>
						  </cms:contentsList>
												     
								  	   	   	</ul>
								  	   	   	<p>	<a href="./html/<cms:channelInfo pname="path" cid="11"/>/list_1.html" class="btn btn-xs btn-info pull-right">more>></a></p></p>
								  	   	   </div>
								</div>
				</div>
				<div class="col-sm-6 col-md-4">
								<div class="artlist">
										<span class="glyphicon glyphicon-equalizer icontit" >
								  	       </span>
								  	   	   <div class="artlist" style="display:inline-block;">
								  	   	   	  	   	   	<h4><cms:channelInfo pname="name" cid="12"/></h4>
								  	   	   	<ul>
						<cms:contentsList channelId="12" top="5">
						  <li><a href="./html/<cms:channelInfo pname="path" cid="12"/>/article_12_<cms:property pname="id"/>.html"><cms:property pname="title"/></a></li>
						  </cms:contentsList>
												     
								  	   	   	</ul>
								  	   	   	<p> 	<a href="./html/<cms:channelInfo pname="path" cid="12"/>/list_1.html" class="btn btn-xs btn-info pull-right">more>></a></p></p>
								  	   	   </div>
								</div>
				</div>
				<div class="col-sm-6 col-md-4">
					           	<div class="artlist">
										  <span class="glyphicon glyphicon-education icontit" >
								  	       </span>
								  	   	   <div class="artlist" style="display:inline-block;">
								  	   	   	  	   	   	<h4><cms:channelInfo pname="name" cid="14"/></h4>
								  	   	   	<ul>
						<cms:contentsList channelId="14" top="5">
						  <li><a href="./html/<cms:channelInfo pname="path" cid="14"/>/article_14_<cms:property pname="id"/>.html"><cms:property pname="title"/></a></li>
						  </cms:contentsList>
												     
								  	   	   	</ul>
								  	   	   	<p> 
								  	   	 
								  	   	   	<a href="./html/<cms:channelInfo pname="path" cid="14"/>/list_1.html" class="btn btn-xs btn-info pull-right">more>></a></p>
								  	   	   </div>
								</div>
				</div>
					
		
				
			</div>
		</div>
		<!--footer-->
		
<footer id="footer">
	<div class="container">
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
