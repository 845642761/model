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
			<form class="loginForm" id="form" method="post">
				<input type="text" name="strLoginId" placeholder="请输入登录帐号" class="required"/>
				<input type="password" name="strPassword" placeholder="请输入密码" class="required" minlength="6" maxlength="16"/>
				<label class="fl">
					<input id="yhxy" type="checkbox" onclick="this.value=this.checked?1:0" />
					<a target="_blank" class="fr">《memory用户协议》</a>
				</label>
				<input type="submit" class="submit required" value="注&nbsp; &nbsp; 册" />
			</form>
			
			<!-- 右边 -->
			<div class="login_right">
				<div>已有memory帐号？</div>
				<a href="/user/login.do" class="registor_now">立即登录</a>
			</div>
		</div>
	</div>
</body>
<jsp:include page="../../common/js_plugin.jsp" />
<script type="text/javascript">
	var form=$('#form');
	/**
	 * 添加验证
	 */
	var validate=form.validate({
		submitHandler:function(){
			if(!$('#yhxy').is(':checked')){
				alert("请同意用户协议！");
				return false;
			}
			if(loginIdIsExit()){
				$.ajax({
					type : 'POST',
					url :'/user/save.do',
					data : form.serialize(),
					success:function(data) { 
						if(data.code==0){
							alert('注册成功！');
							window.location.href='login.do';
							return true;
						}else{
							alert(data.info);
							return false;
						}
					},
					error : function() {    
						alert("异常！");  
						return false;
					}    
				});
			}else{
				return false;
			}
		}
	});
	
	/**
	 * 用户帐号是否已存在
	 * @author cheng_bo
	 * @date 2015年6月1日 11:04:29
	 */
	function loginIdIsExit(){
		var strLoginId=$('.userName').val();
		$.ajax({
			type : 'POST',
			url :'/user/loginIdIsExit.do',
			dataType : 'json',
			data : 'strLoginId='+strLoginId,
			success:function(data) {
				if(data.code==0){
					return true;
				}else{
					userName.attr('class','has-error');
					return false;
				}
			},
			error : function() {    
				alert("异常！");
				return false;
			}    
		});
		return true;
	}
</script>
</html>