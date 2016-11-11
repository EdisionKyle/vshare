<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.weijia.cn/mytag" prefix="mytag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自定义标签</title>
<style type="text/css">
span {font-size: 18px; color: black; font-weight: bold;}
</style>
</head>
<body>
	<span>客户机的IP地址是：</span>
	<mytag:viewIP />
	<br />
	<span>自定义标签输出日期：</span>
	<mytag:date/>
</body>
</html>