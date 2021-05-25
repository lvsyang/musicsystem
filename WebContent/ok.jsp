<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312" import="java.util.*,cn.edu.lingnan.dao.*,cn.edu.lingnan.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>成功页面</title>



<link rel="shortcut icon" type="ok/image/png" href="favicon.png">
		<!---<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">--->
		<link rel="stylesheet" href="ok/css/bootstrap.css" type="text/css" />
		<link rel="stylesheet" href="ok/css/animate.css" type="text/css" />
		<link rel="stylesheet" href="ok/css/font-awesome.css" type="text/css" />
		<link rel="stylesheet" href="ok/css/style.css" type="text/css" />
</head>
<body>
<%
	String uid= request.getParameter("uid");

%>
				<div class="swiper-slide" style="background-image:url(ok/img/timg.png);">
					<a href="admin/admin.jsp?uid=<%=uid %>">
					<div class="caption scroll-animation" data-animation="pulse" data-animation-delay="0s">
					  <h1>管理员登录 <span></span></h1>
					</div></a>
					
					
			<div class="caption scroll-animation" data-animation="pulse" data-animation-delay="0s">
				  <h1>请选择登录类型<span></span></h1>
				</div>
					
					
				<a href="user/user.jsp?uid=<%=uid%>"><div class="caption scroll-animation" data-animation="pulse" data-animation-delay="0s">
				  <h1> &nbsp;用户登录 <span></span></h1>
				</div></a>

					
					
				</div>
				<script src="ok/js/lib/jquery.js"></script>
		<script src="ok/js/lib/bootstrap.min.js"></script>
		<script src="ok/js/lib/lightbox.min.js"></script>
		<script src="ok/js/lib/shuffle.js"></script>	
		<script src="ok/js/lib/swiper.min.js"></script>
		<script src="ok/js/lib/waypoints.min.js"></script>		
		<script src="ok/js/script.js"></script>

</body>
</html>