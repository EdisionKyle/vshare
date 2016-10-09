<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>原生AJAX请求</title>
</head>
<body>
	<button id="sendBtn" onclick="loadXMLDoc()">AJAX请求</button><br />
	<div id="panelId"></div>

	<script type="text/javascript">
		function loadXMLDoc() {
			var xmlhttp;
			if (window.XMLHttpRequest) {
				xmlhttp = new XMLHttpRequest();
			} else {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("panelId").innerHTML=xmlhttp.responseText;
				}
			}
			xmlhttp.open("GET", "http://localhost:8089/vshare/front/ajax?t=" + Math.random(), true);
			xmlhttp.send();
		}
	</script>
<!--
如果需要像 HTML 表单那样 POST 数据，请使用 setRequestHeader() 来添加 HTTP 头。然后在 send() 方法中规定您希望发送的数据：
xmlhttp.open("POST","ajax_test.asp",true);
xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
xmlhttp.send("fname=Bill&lname=Gates");

onreadystatechange 	存储函数（或函数名），每当 readyState 属性改变时，就会调用该函数。
readyState

存有 XMLHttpRequest 的状态。从 0 到 4 发生变化。
    0: 请求未初始化
    1: 服务器连接已建立
    2: 请求已接收
    3: 请求处理中
    4: 请求已完成，且响应已就绪

status 	
200: "OK"
404: 未找到页面
-->
</body>
</html>