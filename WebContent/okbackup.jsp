<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�ɹ�ҳ��</title>
</head>
<body>
<%
	String uid= request.getParameter("uid");
%>
 ��ϲ�㣬�ɹ���
   </br>
   <a href="admin/admin.html">ǰ������Աҳ��</a>
   </br>
   <a href="user/user.jsp?uid=<%=uid%>">ǰ������ҳ��</a>

</body>
</html>