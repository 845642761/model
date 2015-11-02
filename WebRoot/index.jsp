<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>${title}</title>
<meta charset="utf-8" />
</head>
<body>
</body>
<script type="text/javascript">
	window.location.href='/user/login.do';
</script>
</html>
