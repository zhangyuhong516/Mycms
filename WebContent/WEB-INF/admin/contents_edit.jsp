<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.cms.pojo.*,com.cms.utils.*" %>
<%@ taglib uri="http://www.cms/tags" prefix="cms" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<%@include file="header.jsp" %>
	<style type="text/css">
	    	body{ font-family: "微软雅黑";}
	    </style>
	    <title>RedCMS后台管理系统-修改内容</title>
	    <link rel="stylesheet" href="../kindeditor/themes/default/default.css" />
		<script charset="utf-8" src="../kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="../kindeditor/lang/zh-CN.js"></script>
<script type="text/javascript">




        KindEditor.ready(function(K) {
        	   //初始化编辑器
                window.editor = K.create('#txt',{
                    uploadJson : 'upload_pic',
                    //fileManagerJson : '../asp/file_manager_json.asp',
                    allowFileManager : false
            });
                window.editor2 = K.create('#discri',{
					resizeType : 1,
					allowPreviewEmoticons : false,
					allowImageUpload : false,
					items : [
						'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link']
				});
                
                
                K('#pic1').click(function() {
        			editor.loadPlugin('image', function() {
        				editor.plugin.imageDialog({
        					imageUrl : K('#url1').val(),
        					clickFn : function(url, title, width, height, border, align) 
        					{
        						K('#inpic1').val(url);
        					    K('#pic1').attr("src",url);
        						editor.hideDialog();
        					}
        				});
        			});
        		});
                
                K('#pic2').click(function() {
        			editor.loadPlugin('image', function() {
        				editor.plugin.imageDialog({
        					imageUrl : K('#url1').val(),
        					clickFn : function(url, title, width, height, border, align) {
        						K('#inpic2').val(url);
        					    K('#pic2').attr("src",url);
        						
        						editor.hideDialog();
        					}
        				});
        			});
        		});
                K('#pic3').click(function() {
        			editor.loadPlugin('image', function() {
        				editor.plugin.imageDialog({
        					imageUrl : K('#url1').val(),
        					clickFn : function(url, title, width, height, border, align) {
        						K('#inpic3').val(url);
        					    K('#pic3').attr("src",url);
        						
        						editor.hideDialog();
        					}
        				});
        			});
        		});
                
                
        });
        
     
</script>
	</head>
	<body>
		<%@include file="top.jsp" %>
		<!--中间区域-->
		<div class="container" >
			<div class="row">
				 <div class="col-xs-12 col-sm-3">
				 	 	   	<!--   侧边功能栏-->
				      	   <%@include file="left.jsp" %>
				 </div>
				 <div class="col-sm-9">
				 	 <!--路径导航-->
				 	 <div class="nav">
						  <ol class="breadcrumb" id="aaa">
							  <li><a href="#">首页</a></li>
							  <li><a href="contents">内容</a></li>
							  <li class="active">修改内容</li>
							</ol>
					</div>
				 	<div><!-- 内容区 -->
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">修改内容</h3>
  </div>
<div class="panel-body">
<%
	Contents contents=(Contents)request.getAttribute("contents");
   Channel channel=(Channel)request.getAttribute("channel");
   Model model=(Model)request.getAttribute("model");
   Map<String,ModelItem> items=(Map<String,ModelItem>)request.getAttribute("validItems");
   if(null!=contents)
   {
%>
	<form action="contents" method="post">
	<input type="hidden" name="action" value="saveEdit"/>
	<input type="hidden" name="id" value="<%=contents.getId()%>"/>
	<input type="hidden" name="admin_id" value="${sessionScope.loged.id}"/>
		<div class="form-group form-inline">
			<label>标题:</label>
			<input type="text" value="<%=contents.getTitle()%>" name="title" style="width: 50%;" placeholder="请输入标题" required="required"  class="form-control"/>
		     <cms:channelSelect fieldName="channel_id" defValue="<%=contents.getChannel_id() %>"/>
		    <%
		      if(null!=items.get("titlecolor")&&items.get("titlecolor").getValid()==0)
		      {
		    %>
		    <label><%=items.get("titlecolor").getShowlab() %>：</label>
		    <input type="color" name="titlecolor" class="form-control" value="<%=contents.getTitlecolor() %>"/>
		    <%
		      }
		    %>
		</div>
		
		<div  class="form-group form-inline">
		    <%
			  if(null!=items.get("tags"))
			  {
			%>
			<label><%=items.get("tags").getShowlab() %>：</label>
			<input type="text" name="tags" value="<%=contents.getTags() %>" placeholder="多个标签用逗号分隔"  class="form-control"/>
			<%
			}
			%>
			<%
			  if(null!=items.get("origin"))
			  {
			%>
			<label><%=items.get("origin").getShowlab()%>：</label>
			<input type="text" name="origin" style="width: 10%;" value="<%=contents.getOrigin()%>"  class="form-control"/>
			<%
			  }
			%>
			<%
			  if(null!=items.get("origin_url"))
			  {
			%>
			<label><%=items.get("origin_url").getShowlab() %>：</label>
			<input type="text" name="origin_url" value="<%=contents.getOrigin_url()%>"  class="form-control"/>
			<%} %>
		</div>
		
		
		<div  class="form-group form-inline">
		<% 
		   if(null!=items.get("content_tem"))
			  {
			   %>
			<label><%=items.get("content_tem").getShowlab()%>：</label>
			<cms:tempFiles temType="content" defval="<%=contents.getContent_tem()%>"/>
			<%}else
			{
				%>
				<input type="hidden" name="content_tem" value="<%=contents.getContent_tem()%>"/>
				<%
				}%>
			<% 
		   if(null!=items.get("level"))
			  {
			   %>
			<label><%=items.get("level").getShowlab()%>：</label>
			<select name="level" class="form-control">
				<%
				 
				for(int i=99;i>0;i--)
					{
					   
					   if(i==contents.getLevel())
						out.println("<option value='"+i+"' selected='selected'>"+i+"</option>");
					   else
                       out.println("<option value='"+i+"'>"+i+"</option>");
					}%>
			</select>
			<%
			  }
			%>
			<% 
		   if(null!=items.get("isrecom"))
			  {
			   %>
			<label><%=items.get("isrecom").getShowlab()%>：</label>
			<%
			if(contents.getIsrecom()==1)
			%>
			<input type="checkbox" checked="checked" name="isrecom" value="1"  class="form-control"/>
			<%
			  }else
			  {
				  %>
			<input type="checkbox" name="isrecom" value="1"  class="form-control"/>	  
				  <% 
			  }
			%>
			
			<% 
		   if(null!=items.get("pic1"))
			  {
			   String pic1path=(null!=contents.getPic1()&&!"".equals(contents.getPic1()))?CutContextPath.cutContext(contents.getPic1()):"../img/upload-pic.png";
			   %>
			 <input type="hidden" value="<%=contents.getPic1()%>" id="inpic1" name="pic1"/>
		     <img title="点击，上传图片" id="pic1" width="60" height="36" src="<%=pic1path %>" style="cursor:pointor;"/>
		    <%}%>
		    
		    <% 
		   if(null!=items.get("pic2"))
			  {
			   String pic2path=(null!=contents.getPic2()&&!"".equals(contents.getPic2()))?CutContextPath.cutContext(contents.getPic2()):"../img/upload-pic.png";
			   %>
			 <input type="hidden" value="<%=contents.getPic2()%>" id="inpic2" name="pic2"/>
		     <img title="点击，上传图片" id="pic2" width="60" height="36" src="<%=pic2path %>" style="cursor:pointor;"/>
		    <%}%>
		       <% 
		   if(null!=items.get("pic3"))
			  {
			   String pic3path=(null!=contents.getPic3()&&!"".equals(contents.getPic3()))?CutContextPath.cutContext(contents.getPic3()):"../img/upload-pic.png";
			   %>
			 <input type="hidden" value="<%=contents.getPic3()%>" id="inpic3" name="pic3"/>
		     <img title="点击，上传图片" id="pic3" width="60" height="36" src="<%=pic3path %>" style="cursor:pointor;"/>
		    <%}%>
		</div>
         <% 
		   if(null!=items.get("discri"))
			  {
			   %>
		<div class="form-group">
		<textarea rows="3" cols="30" style="width: 90%;" id="discri" name="discri" placeholder="填写内容描述"><%=contents.getDiscri()%></textarea>
		
		</div>
		<%
			  }
		%>
		<div class="form-group">
		<textarea rows="5" cols="30" id="txt" style="width: 90%;" name="txt"><%=contents.getTxt() %></textarea>
		</div>
		
		<%if(null!=items.get("links"))
			{%>
		<div class="form-group form-inline">
		<label><%=items.get("links").getShowlab()%>：</label>
		<input type="text" name="links" style="width:70%;" value="<%=contents.getLinks() %>" placeholder="请输入要直接跳转的地址" />
		</div>
		<% 
			}
		%>
		<div class="form-group form-inline">
		<%if(null!=items.get("extstr1"))
			{%>
		<label><%=items.get("extstr1").getShowlab() %>：</label>
		<input type="text" name="extstr1" value="<%=contents.getExtstr1()%>" style="width: 10%;" class="form-control" />
		<%} %>
		
		<%if(null!=items.get("extstr2"))
			{%>
		<label><%=items.get("extstr2").getShowlab() %>：</label>
		<input type="text" name="extstr2"  value="<%=contents.getExtstr2()%>"   style="width: 10%;" class="form-control"/>
		<%} %>
		
		<%if(null!=items.get("extint1"))
			{%>
		<label><%=items.get("extint1").getShowlab() %>:</label>
		<input type="number" value="<%=contents.getExtint1()%>"  name="extint1" style="width: 7%;"  class="form-control"/>
		<%} %>
		
		<%if(null!=items.get("extint2"))
			{%>
		<label><%=items.get("extint2").getShowlab() %>:</label>
		<input type="number" name="extint2" value="<%=contents.getExtint2()%>" style="width: 7%;"  class="form-control"/>
		<%} %>
		</div>
		
		<div style="text-align: center; margin: 10px 0;">
			<button type="submit" class="form-control btn btn-success ">修改内容</button>
		</div>
	</form>
	<%
   }
	%>
</div>
</div>

				 	</div><!-- 内容区结束 -->  	
				 	
				 </div>
				
			</div>
			
		</div>
		
		<footer class="container">
			<hr />
			<p align="center">RedCMS后台管理界面&nbsp;&nbsp;<b>微信/QQ:9703239</b></p>
		</footer>
       <cms:modalDialogTag/>
	</body>
</html>
