<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://localhost:8089/vshare/js/jquery-2.2.3.min.js"></script>
<title>JSON语法</title>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	var str = '{ "name": "cxh", "sex": "man" }';
	alert(str);
	var jon = JSON.parse(str);
	alert(jon);
	var strJon = JSON.stringify(jon);
	alert(strJon);
});

</script>
<!--
JSON：JavaScript 对象表示法（JavaScript Object Notation）。
JSON 是存储和交换文本信息的语法。类似 XML。
JSON 比 XML 更小、更快，更易解析。


JSON 指的是 JavaScript 对象表示法（JavaScript Object Notation）
JSON 是轻量级的文本数据交换格式
JSON 独立于语言
JSON 具有自我描述性，更易理解
JSON 使用 JavaScript 语法来描述数据对象，但是 JSON 仍然独立于语言和平台。JSON 解析器和 JSON 库支持许多不同的编程语言


类似 XML
    JSON 是纯文本
    JSON 具有“自我描述性”（人类可读）
    JSON 具有层级结构（值中存在值）
    JSON 可通过 JavaScript 进行解析
    JSON 数据可使用 AJAX 进行传输
相比 XML 的不同之处
    没有结束标签
    更短
    读写的速度更快
    能够使用内建的 JavaScript eval() 方法进行解析
    使用数组
    不使用保留字

JSON 语法是 JavaScript 对象表示法语法的子集。
    数据在名称/值对中
    数据由逗号分隔
    花括号保存对象
    方括号保存数组


JSON 文件
    JSON 文件的文件类型是 ".json"
    JSON 文本的 MIME 类型是 "application/json"  || MIME内容类型


-->
</body>
</html>