<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入jquery  -->
<script type="text/javascript"
	src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
<!-- 引入bootstrap样式-->
<link
	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>测试ajax请求</title>
</head>
<body>
	<button type="button" class="btn btn-default" id="click_btn">点击我</button>
	<script type="text/javascript">
		$(function(){
			$("#click_btn").click(function(){
 				ajaxTest();
			});
			
			
			function ajaxTest(){
				$.ajax({
					url:"${APP_PATH}/ajaxTest",
					type:"POST",
					dataType:"text",
					success:function(result){
						console.log("返回结果:");
						alert("返回內容:"+result);
					},
					error:function(result){
						alert("出錯了:"+result);
					}
				});
			}
			
		});
	
	</script>
</body>
</html>