<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312" import="java.util.*,cn.edu.lingnan.dao.*,cn.edu.lingnan.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>管理员界面</title>

  <link rel="stylesheet" type="text/css" href="../daohang/css/htmleaf-demo.css"><!--演示页面样式，使用时可以不引用-->
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
这是管理员才能访问的页面！
  <header class="coidea-header">
    <div class="coidea-links">
      <a class="coidea-icon-back" href="http://www.htmleaf.com/jQuery/Menu-Navigation/201812215464.html" title="返回下载页">C</a>
      <a class="coidea-icon-github" href="http://www.htmleaf.com/" title="jQuery之家">G</a>
    </div>
  </header>
  <!-- COIDEA:header END -->
  
  <!-- COIDEA:demo START -->
  <header style="background: url(../daohang/assets/img/timg.jpg) no-repeat center center fixed;">
    <ul class="navigation">
      
      <!-- navigation START -->

      <li data-width="420" data-height="420">
        <a href="../ok.jsp?uid=<%=uid %>">返回主页</a>
      </li>
      <li data-width="356" data-height="356">
        <a href="adminregister.jsp">注册管理员</a>
      </li>
      <li data-width="292" data-height="292">
        <a href="music/usermusictimes.jsp?uid=<%=uid %>">用户听歌信息表</a>
      </li>
      <li data-width="228" data-height="228">
        <a href="allMusic.jsp?uid=<%=uid %>">修改歌曲</a>
      </li>
      <li data-width="164" data-height="164">
        <a href="findAllUserServlet">修改用户</a>
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