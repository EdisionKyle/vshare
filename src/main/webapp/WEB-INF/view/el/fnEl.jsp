<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>jstl函数</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

	</head>
	<body>
		fn:contains 函数
		<br />
		${fn:contains("Tomcat","cat")} --- ${fn:contains("Tomcat","CAT")}
		<hr />
		fn:containsIgnoreCase 函数
		<br />
		${fn: containsIgnoreCase ("Tomcat","CAT")} --- ${fn:
		containsIgnoreCase ("Tomcat","Mike")}
		<hr />
		fn:startsWith 函数
		<br />
		${fn: startsWith ("Tomcat","Tom")} --- ${fn: startsWith
		("Tomcat","cat")}
		<hr />
		fn:endsWith 函数
		<br />
		${fn: endsWith ("Tomcat","Tom")} --- ${fn: endsWith ("Tomcat","cat")}
		<hr />
		fn:indexOf 函数
		<br />
		1 ${fn: indexOf ("Tomcat","cat")}
		<br />
		2 ${fn: indexOf ("2211221","21")}
		<br />
		3 ${fn: indexOf ("Tomcat","Mike")}
		<br />
		<hr />
		fn:replace 函数
		<br />
		1 ${ fn: replace("TomcAt","cAt","cat")}
		<br />
		2 ${ fn: replace("2008/1/9","/","-")}
		<br />
		<hr />
		fn:split 函数
		<br />
		<c:set value='${fn:split("www.baidu.com",".")}' var="strs" />
		<c:forEach var="token" items="${strs}">
			${token}<br />
		</c:forEach>
		<hr />
		fn:join 函数
		<br />
		<%
			String strs[] = { "www", "baidu", "org" };
		%>
		<c:set value="<%=strs%>" var="strs" />
		${fn:join(strs,".")}
		<hr />
		1.${fn:escapeXml("<b> 表示粗体字 </b>") }
		<br />
		2.
		<c:out value="<b> 表示粗体字 </b>" escapeXml="true"></c:out>
		<br />
		3.${"<b> 表示粗体字 </b>"}
		<br />
		<hr />
		<%
			int[] array = { 1, 2, 3, 4 };
			ArrayList list = new ArrayList();
			list.add("one");
			list.add("two");
			list.add("three");
		%>
		<c:set value="<%=array%>" var="array"></c:set>
		<c:set value="<%=list%>" var="list"></c:set>
		数组长度： ${fn:length(array)}
		<br />
		集合长度： ${fn:length(list)}
		<br />
		字符串长度： ${fn:length("Tomcat")}
		<br />
	</body>
</html>
<!--
Functions 标签库概览

l  fn:contains 函数 ： 用于判断在源字符串中是否包含目标字符串。

l  fn:containsIgnoreCase 函数 ： 用于判断在源字符串中是否包含目标字符串 ， 并且在判断时忽略大小写。

l  fn:startsWith 函数 ： 用于判断源字符串是否以指定的目标字符串开头。

l  fn: endsWith 函数：用于判断源字符串是否以指定的目标字符串结尾。

l  fn:indexOf 函数：用于在源字符串中查找目标字符串，并返回源字符串中最先与目标字符串匹配的第一个字符的索引。

l  fn:replace 函数：用于把源字符串中的一部分替换为另外的字符串，并返回替换后的字符串。

l  fn:substring 函数：用于获取源字符串中的特定子字符串。

l  fn:substringBefore 函数：用于获取源字符串中指定子字符串之前的子字符串。

l  fn: substringAfter 函数：用于获取源字符串中指定子字符串之后的子字符串

l  fn:split 函数：用于将源字符串拆分为一个字符串数组。

l  fn:join 函数：用于将源字符串数组中的所有字符串连接为一个字符串。

l  fn:toLowerCase 函数：用于将源字符串中的所有字符改为小写。

l  fn: toUpperCase 函数：用于将源字符串中的所有字符改为大写。

l  fn:trim 函数：用于将源字符串中的开头和末尾的空格删除。

l  fn:escapeXml 函数：用于将源字符串中的字符“ < ”、“ > ”、“ ” ”和“ & ”等转换为转义字符。

l  fn:length 函数：用于返回字符串中的字符的个数，或者集合和数组的元素的个数
-->