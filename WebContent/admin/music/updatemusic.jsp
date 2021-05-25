<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="java.util.*,cn.edu.lingnan.dao.*,cn.edu.lingnan.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>更改歌曲信息</title>
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
     歌曲id:<td><input type="text" name="mid" value=<%=m.getMid() %>></td>
     歌曲名：<td><input type="text" name="mname" value=<%=m.getMname() %>></td>
      类别：<!--  <td><input type="text" name="kid" value=<%=m.getKid() %>></td>-->
      
      
     <td>
     <select name="kid">
     <option value="k01" selectd>hiphop
     <option value="k02">日韩
     <option value="k03">内地
     <option value="k04">港澳
     <option value="k05">欧美
     <option value="k06">说唱
     </select>
     <font color="red">*</font>
    </td>
        <td><input type="submit" name="确认" value=<%="确认修改" %>></td>
    </tr>
<%
 	   
%>
</form>
</body>
</html>