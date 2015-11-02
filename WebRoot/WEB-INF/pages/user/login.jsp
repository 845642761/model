<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../common/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>${title}</title>
<meta charset="utf-8" />
<link href="${basePath}/static/css/formUI.css" rel="stylesheet" type="text/css" />
<link href="${basePath}/static/css/user/login.css" rel="stylesheet" type="text/css" />
</head>
<body class="login_bg">
	<div class="login_wrapper">
		<div class="login_box">
			<!-- 左边 -->
			<form action="/user/ssoLogin.do" class="loginForm" id="form">
				<input type="text" name="strLoginId" placeholder="请输入登录邮箱地址" class="required"/>
				<input type="password" name="strPassword" placeholder="请输入6-16位密码，字母区分大小写" class="required" minlength="6" maxlength="16"/>
				<label class="fl">
					<input type="checkbox" name="rememberMe" onclick="this.value=this.checked?1:0" />&nbsp;记住我
				</label>
				<label class="fl">
					<a target="_blank" style="margin-left: 155px;">忘记密码？</a>
				</label>
				<input type="submit" class="submit" value="登 &nbsp; &nbsp;录" />
			</form>
			
			<!-- 右边 -->
			<div class="login_right">
				<div>还没有memory帐号？</div>
				<a href="/user/regist.do" class="registor_now">立即注册</a>
			</div>
		</div>
	</div>
</body>
<jsp:include page="../../common/js_plugin.jsp" />
<script type="text/javascript">
	/**
	 * 登录
	 * @author: cheng_bo
	 * @date: 2015年7月28日 14:20:07
	 */
	var form=$('#form');

	/**
	 * 添加验证
	 */
	var validate=form.validate({
		submitHandler:function(){
			$.ajax({
				type : 'POST',
				url :'/user/ssoLogin.do',
				data : form.serialize(),
				success:function(data) { 
					if(data.code == 0){
						window.location.href='/system/main.do';
					}else{
						alert(data.info);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {    
					alert("异常！");  
					return;
				}    
			});
		}
	});
</script>
</html>