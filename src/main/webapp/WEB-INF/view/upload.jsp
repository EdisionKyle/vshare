<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>
</head>
<body>
<h2>Spring MVC文件上传</h2>
<form action="upload.do" method="post" enctype="multipart/form-data">  
<input type="file" name="file" />
<input type="submit" value="Submit" />
</form>
<br />
<a href="about.do"><span style="color: green; font-size:20px">关于我们</span></a><br />
<a href="advice.do?uname=milesloner&passwd=lelife"><span style="color: green; font-size:20px">留言</span></a>
</body>
</html>