<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>
</head>
<body>
<h2>Spring MVC 用户数据展示</h2>
List集合展示<br />
<ol>
<li>姓名  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 爱好</li>
<c:forEach var="user" items="${users}">
<li>${user.uname} &nbsp;&nbsp; ${user.hobby}</li>
</c:forEach>
</ol>
<br />
<hr />
Map集合展示<br />
性别：${info.sex}<br />
地址：${requestScope.info.address}<br />${1+2}
<br />
<hr />
<a href="about.do"><span style="color: green; font-size:20px">关于我们</span></a><br />
<a href="toUpload.do"><span style="color: green; font-size:20px">上传附件</span></a><br />
<a href="showImg.do"><span style="color: green; font-size:20px">展示图片</span></a><br />
<a href="advice.do?uname=milesloner&passwd=lelife"><span style="color: green; font-size:20px">留言</span></a>
</body>
</html>
<!--
没有指定哪一个范围的username，所以它会依序从Page、Request、Session、Application范围查找


如果我们需要指定变量的寻找范围，可以在EL表达式中指定搜寻范围：
${pageScope.logininfo.username}
${requestScope.logininfo.username}
${sessionScope.logininfo.username}
${applicationScope.logininfo.username}

在Spring 中，所有逻辑处理单元返回的结果数据，都将作为Attribute 被放
置到HttpServletRequest 对象中返回（具体实现可参见Spring 源码中
org.springframework.web.servlet.view.InternalResourceView.
exposeModelAsRequestAttributes方法的实现代码），也就是说Spring
MVC 中，结果数据对象默认都是requestScope。因此，在Spring MVC 中，
以下寻址方法应慎用：
${sessionScope.logininfo.username}
${applicationScope.logininfo.username}

如果EL表达式无法解析：– <%@ page isELIgnored="false" %>
-->