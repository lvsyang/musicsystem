<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="java.util.*,cn.edu.lingnan.dao.*,cn.edu.lingnan.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>���ĸ�����Ϣ</title>
</head>
<body>
<form action="musicUpdateServlet">
<%
   /* Integer superuser1=(Integer)session.getAttribute("superuser");
    String uid=request.getParameter("uid");
    User u =new User();
    UserDAO udao=new UserDAO();
    u=udao.findUser(uid);*/
    
    
    String mid=request.getParameter("mid");
    LmusicDAO ldao=new LmusicDAO();
    Music m=new Music();
    m=ldao.findMusic(mid);
    
    
%>
    <tr>
     ����id:<td><input type="text" name="mid" value=<%=m.getMid() %>></td>
     ��������<td><input type="text" name="mname" value=<%=m.getMname() %>></td>
      ���<!--  <td><input type="text" name="kid" value=<%=m.getKid() %>></td>-->
      
      
     <td>
     <select name="kid">
     <option value="k01" selectd>hiphop
     <option value="k02">�պ�
     <option value="k03">�ڵ�
     <option value="k04">�۰�
     <option value="k05">ŷ��
     <option value="k06">˵��
     </select>
     <font color="red">*</font>
    </td>
        <td><input type="submit" name="ȷ��" value=<%="ȷ���޸�" %>></td>
    </tr>
<%
 	   
%>
</form>
</body>
</html>