<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>成功页面</title>
</head>
<body>
<%
	String uid= request.getParameter("uid");
%>
 恭喜你，成功了
   </br>
   <a href="admin/admin.html">前往管理员页面</a>
   </br>
   <a href="user/user.jsp?uid=<%=uid%>">前往个人页面</a>

</body>
</html>