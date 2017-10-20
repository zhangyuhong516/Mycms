<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>RedCMS后台登录</title>
		<script src="../js/jquery-1.7.1.min.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="../formValidator/style/validatorTidyMode.css" />
<script src="../formValidator/formValidator-4.0.1.js" type="text/javascript"></script>
<script src="../formValidator/formValidatorRegex.js" type="text/javascript"></script>
		<link rel="stylesheet" href="../css/bootstrap.min.css" />
		<style type="text/css">
			body{font-family: "微软雅黑";}
		</style>
		<script type="text/javascript">
		$(document).ready(function(){
			$.formValidator.initConfig({formID:"form1",autoTip:true,tidyMode:true,onError:function(msg){alert(msg)}});
			$("#email").formValidator({onShow:"请输入邮箱",onFocus:"邮箱至少6个字符,最多100个字符",onCorrect:"恭喜你,你输对了",defaultValue:"admin@qq.com"}).regexValidator({regExp:"^([\\w-.]+)@(([[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.)|(([\\w-]+.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(]?)$",onError:"你输入的邮箱格式不正确"});
			$("#passwd").formValidator({onShow:"请输入密码",onFocus:"密码不能为空",onCorrect:"密码合法"}).inputValidator({min:1,onError:"密码不能为空,请确认"});
			$("#randimg").formValidator({onShow:"请输入验证码",onFocus:"请输入验证码",onCorrect:"验证码正确"});
			/*$("#email").blur(function(){
				var uemail=$("#email").val();
				$.get("./login",{action:"checkEmail",email:uemail},
						function(data){
							if(2==data){
								alert("服务器不存在这个Email");
							}
				});
			});*/
		});
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-xs-12  col-sm-6 col-sm-offset-2 col-md-5 col-md-offset-3">
					<form id="form1" action="login" method="post">
					<input type="hidden" name="action" value="checkLogin"/>
					<h3 class="h3">RedCMS后台登录</h3>		
					<div class="form-group  has-feedback">
		           	   <label class="sr-only">用户名：</label>
		           	   <input type="email" required class="form-control" name="email" id="email" placeholder="请输入用户名" />
		               <span class="glyphicon glyphicon-user form-control-feedback"></span>
		           </div>
		            <div class="form-group has-feedback">
		           	    <label class="sr-only">密码：</label>
		           	    <input type="password" required class="form-control" name="passwd" id="passwd" placeholder="请输入密码" />
		               <span class="glyphicon glyphicon-lock form-control-feedback"></span>
		            </div>
					<div class="form-group">
					    <input type="text" class="col-xs-2 form-control" style="width: 120px;" name="randimg" id="randimg" placeholder="验证码"/>
					    <img src="../Kaptcha.jpg" class="col-xs-3" style="width: 120px;height: 34px;consor:pointer;"onclick="this.src='../Kaptcha.jpg?aa='+Math.random();"/>
					    <p class="help-block" class="col-xs-3" style="font-size:12px;line-height:34px;vertical-align:baseline;">看不清，请点击图片</p>
					</div>
					<button type="submit" class="btn btn-primary form-control">登录</button>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>
