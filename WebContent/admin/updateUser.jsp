<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="java.util.*,cn.edu.lingnan.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>更改用户资料</title>
</head>
<body>
<form action="updateUserServlet">
<%
    String uid=request.getParameter("uid");
    Vector<User> v =new Vector<User>();
    v=(Vector<User>)session.getAttribute("allUser");
    Iterator<User> it =v.iterator();
    User u =new User();
    while(it.hasNext()){
 	   u=it.next();
 	   if(u.getUid().equals(uid)){
%>
    <tr>
        <td><input type="hidden" name="uid" value=<%=u.getUid() %>></td>
        姓名：<td><input type="text" name="uname" value=<%=u.getUname() %>></td>
        密码：<td><input type="text" name="upassword" value=<%=u.getUpassword() %>></td>
       用户权限： <td><input type="text" name="superuser" value=<%=u.getSuperuser() %>></td>
        <td><input type="submit" name="确认" value=<%="确认修改" %>></td>
    </tr>
<%
 	   }}
%>
</form>
</body>
</html>