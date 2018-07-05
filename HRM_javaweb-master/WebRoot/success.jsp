<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>人力资源管理界面</title>
</head>
<body>
	${msg}
	<br>
	<a href="Searchall">查看公司人员名单</a>
	<br>
	<a href="log_in.jsp">返回登录界面</a>
</body>

</html>
