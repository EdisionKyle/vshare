<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>
<link rel="shortcut icon" href="http://localhost:8080/smvc/resource/favicon.ico">
</head>
<body>
<h2>Spring MVC学习从这里开始</h2>
用户登录：<br />
<form action="login.do" method="post">
	用户名：<input type="text" name="uname" /><br />
	密码：<input type="password" name="hobby"/><br />
	<input type="submit" value="登录" />
	<span style="color: red">${msg }</span>
</form>
<br />
<a href="about.do"><span style="color: green; font-size:20px">关于我们</span></a><br />
<a href="toUpload.do"><span style="color: green; font-size:20px">上传附件</span></a><br />
<a href="showImg.do"><span style="color: green; font-size:20px">展示图片</span></a><br />
<a href="advice.do?uname=milesloner&passwd=lelife"><span style="color: green; font-size:20px">留言</span></a>
</body>
</html>