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
		<title>RedCMS后台管理系统-修改栏目</title>
		<link rel="stylesheet" href="../kindeditor/themes/default/default.css" />
		<script charset="utf-8" src="../kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="../kindeditor/lang/zh-CN.js"></script>
<script type="text/javascript">
        KindEditor.ready(function(K) {
        	   //初始化编辑器
                window.editor = K.create('#discri',{
                    uploadJson : 'upload_pic',
                    //fileManagerJson : '../asp/file_manager_json.asp',
                    allowFileManager : false
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
                
                
        });
        
     
</script>
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
							<li class="action">修改栏目</li>
						</ol>
					</div>
					 <div><!-- 内容区 -->

                       <!-- 增加栏目的Panel -->
                       <div class="panel panel-default">
                       	<div class="panel-heading">
                       		<h3 class="panel-title">修改栏目</h3>
                       	</div>
                       	<%
                       	Channel channel=(Channel)request.getAttribute("channel");
                       	if(null!=channel)
                       	{
                       	%>
                       	<div class="panel-body">
                       	<form action="channel" method="post">
                       	<input type="hidden" name="action" value="saveEdit"/>
                       	<input type="hidden" name="cid" value="<%=channel.getId()%>"/>
                       	<div class="form-group form-inline">
						    <label for="exampleInputName2" >栏目名称：</label>
						   
						      <input type="text" class="form-control" required="required" name="name" value="<%=channel.getName()%>"/>
						      <label for="exampleInputName2" >模型：</label>
						   
						      <select name="model_id" class="form-control">
						      	<%
						      	List<Model> mlist=(List<Model>)request.getAttribute("mlist");
						    		  if(null!=mlist&&mlist.size()>0)
						    		  {
						    			  for(Model mo:mlist)
						    			  {
						    				  if(mo.getId()==channel.getModel_id())
						    				  {
						    					  %>
								    			  <option value="<%=mo.getId() %>" selected="selected"><%=mo.getName() %></option>
								    			  <%    
						    				  }else
						    				  {
						    					  %>
								    			  <option value="<%=mo.getId() %>"><%=mo.getName() %></option>
								    			  <%  
						    				  }
						    				  
						    			  }
						    			  
						    		  }
						      	%>
						      </select>
						      <label for="exampleInputName2" >父栏目：</label>
						   
						      <select name="parent_id" class="form-control">
						      	<option value="-1">顶级栏目</option>
						      	<%
						      	List<Channel> clist=(List<Channel>)request.getAttribute("clist");
						    		  if(null!=clist&&clist.size()>0)
						    		  {
						    			  for(Channel cha:clist)
						    			  {
						    				  if(cha.getId()==channel.getParent_id())
						    				  {
						    					  %>
								    			  <option value="<%=cha.getId() %>" selected="selected"><%=cha.getName() %></option>
								    			  <%  
						    				  }else
						    				  {
						    					  %>
								    			  <option value="<%=cha.getId() %>"><%=cha.getName() %></option>
								    			  <%  
						    				  }
						    				 
						    			  }
						    			  
						    		  }
						      	%>
						      </select>
						</div>
						<div class="form-group form-inline">
						    <label for="exampleInputName2" >栏目路径：</label>
						   
						      <input type="text" class="form-control" required="required" name="path" value="<%=channel.getPath()%>" />
						      <label>排序：</label>
						   
						      <select name="level" class="form-control">
						      	<%
						      	for(int i=99;i>0;i--)
						      	{
						      		if(i==channel.getLevel())
						      		{
						      			out.println("<option value='"+i+"' selected='selected'>"+i+"</option>");
						      		}else
						      		{
						      			out.println("<option value='"+i+"'>"+i+"</option>");
						      		}
						      		
						      		
						      		
						      	}
						      	%>
						      </select>
						      
						      <input type="hidden" id="inpic1" name="pic1">
						      <input type="hidden" id="inpic2" name="pic2">
						      <% 
						      if(null!=channel.getPic1()&&!"".equals(channel.getPic1()))
						      {
						    	  %>
						    	  <img alt="点击，上传图片" id="pic1" width="80" height="36" src="<%=channel.getPic1() %>"  style="cursor:pointer"/>
						    	  <%
						      }else
						      {
						    	  %>
						    	  <img alt="点击，上传图片" id="pic1" width="80" height="36" src="../img/upload-pic.png"  style="cursor:pointer"/>
						    	  <% 
						      }
						      %>
						      <% 
						      if(null!=channel.getPic2()&&!"".equals(channel.getPic2()))
						      {
						    	  %>
						    	  <img alt="点击，上传图片" id="pic2" width="80" height="36" src="<%=channel.getPic2() %>"  style="cursor:pointer"/>
						    	  <%
						      }else
						      {
						    	  %>
						    	  <img alt="点击，上传图片" id="pic2" width="80" height="36" src="../img/upload-pic.png"  style="cursor:pointer"/>
						    	  <% 
						      }
						      %>
						      
						     
						</div>
						<div class="form-group ">
						    <label>栏目描述：</label>
						   <textarea class="form-control" id="discri" name="discri" rows="3"><%=channel.getDiscri() %></textarea>
						      
						</div>
						<div class="form-group form-inline">
						    
						      <label for="exampleInputName2" >首页模板：</label>
						   
						      <cms:tempFiles temType="index" defval="<%=channel.getIndex_tem() %>"/>
						      <label for="exampleInputName2" >列表模板：</label>
						   
						      <cms:tempFiles temType="list" defval="<%=channel.getList_tem()%>"/>
						      <label for="exampleInputName2" >内容模板：</label>
						   
						      <cms:tempFiles temType="content" defval="<%=channel.getContent_tem()%>"/>
						      
						</div>
						<div class="form-group">
						<label>外链</label>
						<input type="text" name="links" style="width:80%;" class="form-control" value="<%=channel.getLinks()%>"/>
						</div>
						<div class="form-group form-inline">
						    <label for="exampleInputName2" >Meta Key：</label>
						   
						      <input type="text" class="form-control" id="" placeholder="" value="<%=channel.getMeta_key()%>"/>
						    <label for="exampleInputName2" >Meta Title：</label>
						   
						      <input type="text" class="form-control" id="" placeholder="" value="<%=channel.getMeta_title()%>"/>
						    <label for="exampleInputName2" >Meta Des：</label>
						   
						      <input type="text" class="form-control" id="" placeholder="" value="<%=channel.getMeta_des()%>"/>
						      
						</div>
						<div class="form-group " style="text-align: center;">
						   <button type="submit" class=" form-control btn btn-primary">修改栏目</button>
						</div>
                       	</form>
                       	</div><!--panel-body 结束 -->
                       	<%
                       	}
                       	%>
                       	
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
