<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312" import="java.util.*,cn.edu.lingnan.dao.*,cn.edu.lingnan.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>����ҳ��</title>

	<link rel="stylesheet" type="text/css" href="../personpage/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="../personpage/css/default.css">
	<link href="http://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
	<link rel="stylesheet" type="text/css" href="../personpage/css/styles.css">

</head>
<body>
<%
	String uid=request.getParameter("uid");
	UserDAO udao=new UserDAO();
	User u=new User();
	u=udao.findUser(uid);
	
%>
	<div class="htmleaf-container">
		<header class="htmleaf-header">
			<h1>����ҳ�� <span>�޸ġ����š����֡���ϲ��</span></h1>
			<div class="htmleaf-links">
				<a class="htmleaf-icon icon-htmleaf-home-outline" href="../ok.jsp?uid=<%=uid %>" title="����ҳ��" target="_blank"><span> ����ҳ��</span></a>
				<a class="htmleaf-icon icon-htmleaf-arrow-forward-outline" href="user.jsp?uid=<%=uid %>" title="��������ҳ" target="_blank"><span> ��������ҳ</span></a>
			</div>
		</header>
		<div class="profile-card-wrap">
			<input id="check" type="checkbox" class="check"><label for="check" class="toggle"> + </label>
			<div class="content" data-text="��ӭ��:<%=u.getUname()%>  ��������ҳ������">
				<div class="title">@<%=u.getUname()%></div>
				<p>
				
id��<label><%=u.getUid()%></label>
</br>
������<label><%=u.getUname()%></label>
</br>
���룺<label><%=u.getUpassword()%></label><br/>
				
				</p>
			</div>
			<div class="link-info">
				<div class="social">
					<a class="link fb" href="changeuser.jsp?uid=<%=u.getUid() %>" target="_blank"><i class="fa fa-user"></i></a>
					<a class="link tw" href="deleteUser?uid=<%=u.getUid() %>" target="_blank"><i class="fa fa-ban"></i></a>
					<a class="link gp" href="lmusic.jsp?uid=<%=u.getUid()%>" target="_blank"><i class="fa fa-heart"></i></a>
					<a class="link pi" href="allmusic.jsp?uid=<%=u.getUid()%>" target="_blank"><i class="fa fa-music"></i></a>
					<!--<a class="link li" href="#" target="_blank"><i class="fa fa-weixin"></i></a>
					<a class="link yt" href="#" target="_blank"><i class="fa fa-qq"></i></a>-->
					
				</div>
				<div class="photo"></div>
			</div>
		</div>

	</div>
	

</body>
</html>