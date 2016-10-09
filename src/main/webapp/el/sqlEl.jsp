<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>El_SQL标签</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

	</head>
	<body>
	<sql:setDataSource var="jstl" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/jstl"
     user="root"  password="tianpc"/>

	<sql:query dataSource="${jstl}" var="cate">
	SELECT * from CATE;
	</sql:query>

	<table border="1" width="100%" cellpadding="0" style="border-collapse: collapse">
	<tr>
	<th>ID</th>
	<th>Name</th>
	</tr>
	<c:forEach var="row" items="${cate.rows}">
	<tr>
	<td><c:out value="${row.cid}"/></td>
	<td><c:out value="${row.cname}"/></td>
	</tr>
	</c:forEach>
	</table>
	</body>
</html>
