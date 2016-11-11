<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>jstl核心标签</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

	</head>
	<body>
		<%
			List<String> list = new ArrayList<String>();
			list.add("first");
			list.add("second");
			list.add("");
			List<String> list2 = new ArrayList<String>();
			list2.add("aaaaaa");
			list2.add("bbbbbb");
			Map<String, List<String>> map = new HashMap<String, List<String>>();
			map.put("a", list);
			map.put("b", list2);
		%>
		<c:set value="<%=list %>" var="lists"/>
		<c:forEach items="${lists}" var="slist">
			<c:if test="${slist != null && !empty slist}">
			<c:out value="${slist}"></c:out><br />
			</c:if>
		</c:forEach>
		<hr />
		<c:forEach items="${lists}" var="slist">
			<c:if test="${!empty slist}">
			<c:out value="${slist}"></c:out><br />
			</c:if>
		</c:forEach>
		<hr />
		<c:set value="<span style='color:green; font-size:20px'>Hello </span>" var="str" scope="page"></c:set>
		${str}<br />
		是否将代码交给xml解析器解释  :<c:out value="${str}" escapeXml="true"></c:out><br />
		<c:out value="${str}" escapeXml="false"></c:out>
		<c:remove var="str"/>
		${str}<br />
		<hr />
		捕捉页面中其他标签的异常<br />
		<c:catch var="CatchNullPointerException">
			<% String str = null; str.trim(); %>
		</c:catch>
		<c:if test="${CatchNullPointerException != null}">  
            Exception is : ${CatchNullPointerException}<br />
        </c:if>
        <hr />
        <c:set var="salary" value="${2000*2}"/>
		Your salary is : <c:out value="${salary}"/><br />
		<c:choose>
		    <c:when test="${salary <= 0}">
		       Salary is very low to survive.
		    </c:when>
		    <c:when test="${salary > 2000}">
		        Salary is very good.
		    </c:when>
		    <c:otherwise>
		        No comment sir...
		    </c:otherwise>
		</c:choose>
		<c:import var="data" url="./baseEl.jsp"/><!-- 存在var属性，没有展示页面内容 -->
		<hr />
		<c:forTokens items="Zara,nuha,roshy" delims="," var="name">
	    <c:out value="${name}"/><br/>
		</c:forTokens>
		<hr />
		<c:url value="./baseEl.jsp" var="baseurl">
		    <c:param name="trackingId" value="1234"/>
		    <c:param name="reportType" value="summary"/>
		</c:url><!-- URL标记提供的唯一的真正的优势是正确的URL编码，包括子param标签指定的任何参数。  -->
		${baseurl }<br /><br />
		<!-- c:import url="${baseurl}"/ -->
		<!-- 重定向到http://www.qq.com  c:redirect url="http://www.qq.com"/  -->
	</body>
</html>