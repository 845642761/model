<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../common/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>${title}</title>
<meta charset="utf-8" />
<link href="${basePath}/static/css/formUI.css" rel="stylesheet" type="text/css" />
<link href="${basePath}/static/css/system/system.css" rel="stylesheet" type="text/css" />
<link href="${basePath}/static/js/jquery-ui-1.11.4/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${basePath}/static/js/jquery-ui-1.11.4/jquery-ui.structure.min.css" rel="stylesheet" type="text/css" />
<link href="${basePath}/static/js/jquery-ui-1.11.4/myUI.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- 头部 -->
<div class="top">
	<!-- 左边 -->
	<div class="top_left"></div>
	
	<!-- 右边 -->
	<div class="top_right"></div>
</div>

<!-- 标签 -->
<div class="nav">
	<ul>
		<c:forEach var="items" items="${menuOneLevel}">
			<li onclick="changeMenu('${items.strId}')">${items.strName}</li>
		</c:forEach>
	</ul>
</div>

<!-- main -->
<div class="main" id="main">
	<!-- 左边 -->
	<div class="main_left">
		<c:forEach var="items" items="${menuTwoLevel}">
			<ul id="${items.strPid}">
				<li><a class="left_a" href="${items.strPermission}" target="iframe">${items.strName}</a></li>
			</ul>
		</c:forEach>
	</div>
	<!-- 右边 -->
	<div class="main_right">
		<iframe name="iframe" id="iframe" src="" marginWidth="0" marginHeight="0" frameBorder="0" width="100%" height="100%" scrolling="no" onload="setHeight()"></iframe>
	</div>
</div>

<!-- 尾部 -->
<div class="bottom"></div>
</body>
<script type="text/javascript" src="${basePath}/static/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">

	/**
	 * @description: 初始化iframe高度
	 * @author: cheng_bo
	 * @date: 2015年7月6日 13:22:40
	 */
	function setHeight(){
		var iframe = document.getElementById("iframe");
		var con = iframe.contentWindow;
		if (con && con.document && con.document.body) {
		    var height = con.document.body.offsetHeight + 20;
		    iframe.height =  height;
		}
	}
	
	/**
	 * @description: 初始化iframe高度
	 * @author: cheng_bo
	 * @date: 2015年7月6日 13:26:39
	 */
	function refreshIframe(){
		var iframe = document.getElementById("iframe");
		iframe.contentWindow.refresh();
	}
	
	/**
	 * @description: 菜单切换
	 * @author: cheng_bo
	 * @date: 2015年8月26日 15:50:07
	 */
	function changeMenu(id){
		$(".main_left ul").each(function(){
			$(this).css('display','none');
		});
		$('#'+id).css('display','block');
	}
	
	
	/**
	 * @description: 弹框
	 * @author: cheng_bo
	 * @date: 2015年7月6日 15:03:47
	 */
	/* var dialog = $('<div>').dialog({
		width: 600,
		autoOpen: false
	});
	
	$.post('/user/updateUserInfo.do', function (res) {
		dialog.html(res);
		dialog.dialog('option', 'title', '信息修改');
		dialog.dialog('open');
	}); */
</script>
</html>
