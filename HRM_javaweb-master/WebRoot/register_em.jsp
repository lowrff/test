<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>员工注册界面</title>
</head>
<script type="text/javascript">
	function beforeSubmit(form) {
		if (form.name.value == '') {
			alert('用户名不能为空！');
			form.name.focus();
			return false;
		}
		if (form.pwd.value == '') {
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
			alert('你两次输入的密码不一致，请重新输入！');
			form.pwd2.focus();
			return false;
		}
		if (form.sex.value == '') {
			alert('性别不能为空！');
			form.sex.focus();
			return false;
		}
		if (form.position.value == '') {
			alert('职位不能为空！');
			form.position.focus();
			return false;
		}
		if (form.salary.value == '') {
			alert('薪资不能为空！');
			form.salary.focus();
			return false;
		}
		if (form.home.value == '') {
			alert('地址不能为空！');
			form.home.focus();
			return false;
		}

		return true;
	}
</script>
<body>
	<h2>员工注册(带*号为必填项)</h2>
	<form action="Register_Employee_Servlet" method="post"
		onSubmit="return beforeSubmit(this);" style="padding-top:-700px;">
		用户名*：<input type="text" name="name" value=""><br> 密 码*：<input
			type="password" name="pwd" value=""><br> 重复密码*：<input
			type="password" name="pwd2" value=""><br> 性别*:<input
			type="radio" name="sex" value="男" checked>男 <input
			type="radio" name="sex" value="女">女 <br> 职位*：<br>
		<textarea name="position" row="1" cols="10"></textarea>
		<br> 薪资*：<br>
		<!-- 薪资只能输入数字 -->
		<input name="salary" onkeyup="if(isNaN(value))execCommand('undo')"
			onafterpaste="if(isNaN(value))execCommand('undo')"> <br>
		地址*:<br>
		<textarea name="home" row="1" cols="30"></textarea>
		<br> 备注:<br>
		<textarea name="info" row="5" cols="30"></textarea>
		<br> <input type="reset" value="重置"><input type="submit"
			value="注册">
	</form>
	<a href="log_in.jsp">返回登录界面</a>
</body>
</html>
