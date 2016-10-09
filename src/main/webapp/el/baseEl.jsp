<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>El基础</title>
		<meta http-equiv="content-type" content="text/html;charset=UTF-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	<!--
	(1)核心标签库 (Core tag library)
	(2)I18N 格式标签库 (I18N-capable formatting tag library)
	(3)SQL 标签库 (SQL tag library)
	(4)XML 标签库 (XML tag library)
	(5)函数标签库 (Functions tag library)
	-->
	</head>

	<body>
		<span style="color: red">initParam取得设定web站点的环境参数(Context) </span>
		<br />
		${initParam.contextConfigLocation}
		<br />
		<span style="color: red">取得请求的参数字符串</span>
		<br />
		${pageContext.request.queryString}
		<br />
		<span style="color: red">取得请求的URL，但不包括请求之参数字符串</span>
		<br />
		${pageContext.request.requestURL}
		<br />
		<span style="color: red">服务的web application 的名称</span>
		<br />
		${pageContext.request.contextPath}
		<br />
		<span style="color: red">取得HTTP 的方法(GET、POST)</span>
		<br />
		${pageContext.request.method}
		<br />
		<span style="color: red">取得使用的协议(HTTP/1.1、HTTP/1.0)</span>
		<br />
		${pageContext.request.protocol}
		<br />
		<span style="color: red">取得用户名称</span>
		<br />
		${pageContext.request.remoteUser}
		<br />
		<span style="color: red">取得用户的IP 地址</span>
		<br />
		${pageContext.request.remoteAddr }
		<br />
		<br />
		<span style="color: red">取得session 的ID</span>
		<br />
		${pageContext.session.id}
		<br />
		<span style="color: red">取得主机端的服务信息</span>
		<br />
		${pageContext.servletContext.serverInfo}

		<br />
		<span style="color: red">jstl:</span>
		<br />
		<c:out value="/${pageContext.servletContext.serverInfo}" />
		<br />
		Expression Language
	</body>
</html>
