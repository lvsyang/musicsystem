<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312" import="java.util.*,cn.edu.lingnan.dao.*,cn.edu.lingnan.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>����Ա����</title>

  <link rel="stylesheet" type="text/css" href="../daohang/css/htmleaf-demo.css"><!--��ʾҳ����ʽ��ʹ��ʱ���Բ�����-->
  <link rel="stylesheet" type="text/css" href="../daohangassets/css/base.css" />
  <link rel="stylesheet" type="text/css" href="../daohang/assets/css/demo.css" />

</head>
<body>
			<%
			String uid=request.getParameter("uid");
			UserDAO udao=new UserDAO();
			User u=new User();
			u=udao.findUser(uid);
			%>
���ǹ���Ա���ܷ��ʵ�ҳ�棡
  <header class="coidea-header">
    <div class="coidea-links">
      <a class="coidea-icon-back" href="http://www.htmleaf.com/jQuery/Menu-Navigation/201812215464.html" title="��������ҳ">C</a>
      <a class="coidea-icon-github" href="http://www.htmleaf.com/" title="jQuery֮��">G</a>
    </div>
  </header>
  <!-- COIDEA:header END -->
  
  <!-- COIDEA:demo START -->
  <header style="background: url(../daohang/assets/img/timg.jpg) no-repeat center center fixed;">
    <ul class="navigation">
      
      <!-- navigation START -->

      <li data-width="420" data-height="420">
        <a href="../ok.jsp?uid=<%=uid %>">������ҳ</a>
      </li>
      <li data-width="356" data-height="356">
        <a href="adminregister.jsp">ע�����Ա</a>
      </li>
      <li data-width="292" data-height="292">
        <a href="music/usermusictimes.jsp?uid=<%=uid %>">�û�������Ϣ��</a>
      </li>
      <li data-width="228" data-height="228">
        <a href="allMusic.jsp?uid=<%=uid %>">�޸ĸ���</a>
      </li>
      <li data-width="164" data-height="164">
        <a href="findAllUserServlet">�޸��û�</a>
      </li>
      <!-- navigation END -->
      
      <!-- navigation:background-helper START -->
      <div class="header-transparent"></div>
      <!-- navigation:background-helper END -->
      
      <!-- navigation:trigger START -->
      <div id="menu-trigger">
        <div id="hamburger">
          <span></span>
          <span></span>
          <span></span>
        </div>
        <div id="close">
          <span></span>
          <span></span>
        </div>
      </div>
      <!-- navigation:trigger END -->
      
    </ul>
  </header>    
  <!-- COIDEA:demo END -->
	
	<script src="../daohang/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.0.1/TweenMax.min.js"></script>
	<script src="../daohang/assets/js/demo.js"></script>
</body>
</html>