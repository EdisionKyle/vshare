<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax异步传输</title>
<script type="text/javascript" src="../resource/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("#asyn").click(function(){
            var $a = $(this);
            $.ajax({
                url:"/smvc/center/ajax.do",
                type:'post',
                data:'name=admin&password=tpc04059988',
                dataType:'json', //text  |  json
                success:function(data,status){
                	//var d = eval("("+data+")");  对应  dataType:'text'
                	$("#content").empty();
					$.each(data, function(key, value) {
					//alert(key + ':' + value.activityId + ':' + value.activityName);
					$("#content").append(value.activityId + '-----' + value.activityName + '<br />' );
					});
                },
                error:function(xhr,textStatus,errorThrown){
                	alert(errorThrown);
                }
            });
        });
    });
</script>
</head>
<body>
<button id="asyn">异步传输</button>
<div id="content"></div>
<br />
<hr />
<a href="about.do"><span style="color: green; font-size:20px">关于我们</span></a><br />
<a href="toUpload.do"><span style="color: green; font-size:20px">上传附件</span></a><br />
<a href="showImg.do"><span style="color: green; font-size:20px">展示图片</span></a><br />
<a href="advice.do?uname=milesloner&passwd=lelife"><span style="color: green; font-size:20px">留言</span></a>
</body>
</html>