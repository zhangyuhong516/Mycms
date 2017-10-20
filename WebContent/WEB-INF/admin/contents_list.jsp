<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.cms.pojo.*,com.cms.page.*" %>
<%@ taglib uri="http://www.cms/tags" prefix="cms" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<%@include file="header.jsp" %>
		
	<style type="text/css">
	    	body{ font-family: "微软雅黑";}
	    </style>
	    <title>RedCMS后台管理系统-内容管理</title>
	   <script type="text/javascript">
	   $(function(){
		     $("#aaaa").change(function(){
		    	 var channelId=$(this).val();
		    	 var url="contents?action=toAdd&channelId="+channelId;
		    	 window.location=url;
		     }); 	
		     $("#bbbb").change(function(){
		    	 var channelId=$(this).val();
		    	 var url="contents?channelId="+channelId;
		    	 window.location=url;
		     }); 
		     $("#allsel").click(function(){
		    	   if($(this).attr("checked"))
					  {
					   $(".allcid").attr("checked","checked");   
					  }else
					  {
						  $(".allcid").removeAttr("checked");
					  }
		     });
		    
		     	 /*批量删除*/
		     
	 $("#deleteall").click(function(){
		 var ids=$(".allcid:checked");
		 var url="contents?action=deleteAll";
		 var cid="";
		 ids.each(function(i){
			cid=cid+"&cid="+ids[i].value;
		 });
		 window.location=url+cid;
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
							  <li><a href="#">内容</a></li>
							  <li class="active">内容管理</li>
							</ol>
					</div>
				 	<div><!-- 内容区 -->
                    <div id="cont_header">
                                   选择要显示的栏目：
 <cms:channelSelect idName="bbbb"/>
                    发布内容：
 <cms:channelSelect idName="aaaa"/>
                    </div><!-- end cont_header -->
                     <table class="table table-striped table-hover table-condensed table-responsive">
                       <tr>
                         <th><input type="checkbox" id="allsel" name="allsel"/>&nbsp;序号</th>
                         <th>类别</th>
                         <th>标题</th>
                         <th>管理</th>
                       </tr>
                       <%
                       int channelId=(Integer)request.getAttribute("channelId");
                       PageDiv<Contents> pd=(PageDiv<Contents>)request.getAttribute("pd");
                       if(null!=pd&&null!=pd.getList()&&pd.getList().size()>0)
                       {
                    	   int index=1;
                    	   for(Contents cont:pd.getList())
                    	   {
                       %>
                       <tr>
                         <td><input type="checkbox" class="allcid" name="cid" value="<%=cont.getId()%>"/>&nbsp;<%=index++ %></td>
                         <td><%=cont.getChannelName() %></td>
                      <%-- <td><a href="../web/showContents?id=<%=cont.getId()%>"><%=cont.getTitle() %></a></td> --%>
                      
                         <td>
                         <a href="contents?action=editContents&id=<%=cont.getId()%>" class="btn btn-xs btn-primary">修改</a>
                         <a href="contents?action=deleteCont&id=<%=cont.getId()%>" class="btn btn-xs btn-danger">删除</a>
                         <a href="contents?action=pubContentHtml2&id=<%=cont.getId() %>" class="btn btn-xs btn-success">发布</a>
                         </td>
                       </tr>
                       <%
                            }
                       }
                       %>
                        
                        <tr>
                         <td><button type="button" id="deleteall" class="btn btn-sm btn-danger">全删</button></td>
                         <td colspan="3">
                        <div style="float:left;width:30%;">当前<%=pd.getPageNo() %>/<b><%=pd.getTotalPage() %></b>页&nbsp;&nbsp;&nbsp;总共<%=pd.getTotalCount() %>条</div> 
  <ul class="pagination pull-right">
    <li>
      <a href="contents?pageNo=<%=pd.getPrevious()%>&channelId=<%=channelId %>" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <%
      for(int i=pd.getStart();i<=pd.getEnd();i++)
      {
    	  %>
    	  <li><a href="contents?pageNo=<%=i%>&channelId=<%=channelId %>"><%=i%></a></li>
    	  <%
      }
    %>
    <li>
      <a href="contents?pageNo=<%=pd.getNext()%>&channelId=<%=channelId %>" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>

                          </td>
                       </tr>
                     </table>

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
