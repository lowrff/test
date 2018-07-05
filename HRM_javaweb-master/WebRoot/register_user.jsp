<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>管理员注册界面</title>
</head>
<script type="text/javascript">
	function beforeSubmit(form) {
		if (form.name.value == '') {
			alert('用户名不能为空！');
			form.name.focus();
			return false;
		}
		if (form.pwd.value == '' || form.pwd2.value == '') {
			alert('密码不能为空！');
			form.pwd.focus();
			return false;
		}
		if (form.pwd.value.length < 6) {
			alert('密码至少为6位，请重新输入！');
			form.pwd.focus();
			return false;
		}
		if (form.pwd.value != form.pwd2.value) {
			alert('两次输入的密码不一致，请重新输入！');
			form.pwd2.focus();
			return false;
		}
		return true;
	}
</script>
<body>
	<h2>管理员注册(带*号为必填项)</h2>
	<form action="Register_User_Servlet" method="post"
		onSubmit="return beforeSubmit(this);" style="padding-top:-700px;">
		用户名*：<input type="text" name="name" value=""><br> 密 码*：<input
			type="password" name="pwd" value=""><br> 重复密码*：<input
			type="password" name="pwd2" value=""><br> 备注:<br>
		<textarea name="info" row="5" cols="30"></textarea>
		<br> <input type="reset" value="重置"><input type="submit"
			value="注册">
	</form>
	<a href="log_in.jsp">返回登录界面</a>
</body>
</html>
