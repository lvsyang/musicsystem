<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="java.util.*,cn.edu.lingnan.dao.*,cn.edu.lingnan.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>�����û�����</title>
</head>
<body>
<form action="userUpdateServlet">
<%
Integer superuser1=(Integer)session.getAttribute("superuser");
    String uid=request.getParameter("uid");
    User u =new User();
    UserDAO udao=new UserDAO();
    u=udao.findUser(uid);
%>
    <tr>
        <td><input type="hidden" name="uid" value=<%=u.getUid() %>></td>
     ������<td><input type="text" name="uname" value=<%=u.getUname() %>></td>
      ���룺<td><input type="text" name="upassword" value=<%=u.getUpassword() %>></td>
      �û�Ȩ�ޣ��޷��޸�<td><input type="hidden" name="superuser" value=<%=superuser1 %>></td>
        <td><input type="submit" name="ȷ��" value=<%="ȷ���޸�" %>></td>
    </tr>
<%
 	   
%>
</form>
</body>
</html>