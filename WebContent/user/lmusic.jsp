<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312" import="java.util.*,cn.edu.lingnan.dao.*,cn.edu.lingnan.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��ϲ��������</title>
<link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
	<style type="text/css">
		.box{
			width: 20px;
			height: 20px;
			padding: 2px;
			border:1px solid #ccc;
			border-radius: 2px;
		}
	</style>
</head>
<body>
	<div class="htmleaf-container">
		<header class="htmleaf-header">
			<h1>��ϲ�� <span>�����û���ϲ�����ָ赥�ı�</span></h1>
			<%
			String uid=request.getParameter("uid");
			%>
			<div class="htmleaf-links">
				<a class="htmleaf-icon icon-htmleaf-home-outline" href="../ok.jsp?uid=<%=uid %>" title="ѡ���û�����" target="_blank"><span> ѡ���û�����</span></a>
				<a class="htmleaf-icon icon-htmleaf-arrow-forward-outline" href="user.jsp?uid=<%=uid %>" title="�����û�����" target="_blank"><span>�����û�����</span></a>
			</div>
		</header>
		<div class="container">
			<div class="row">
				<div class="col-md-12" style="padding:2em 0;">
				  <div class="table-responsive">
						<table class="table table-bordered table-striped" id="mytable">
						    <thead>
<tr><td>������</td><td>���</td><td>����</td></tr>
						    </thead>
						    <tbody>
<%
//	String uid=request.getParameter("uid");
	UserDAO udao=new UserDAO();
	User u=new User();
	u=udao.findUser(uid);
	
	
	
	///����
	LmusicDAO ldao=new LmusicDAO();
	//Lmusic l=new Lmusic();
	Vector<Lmusic> v= new Vector<Lmusic>();
	v=ldao.findLmusic(uid);
	for(Lmusic l:v){
	
%>


<tr><td><%=l.getMname() %></td><td><%=l.getKid()%></td>
   <td>
       <a href="playmusic?uid=<%=u.getUid() %>&kid=<%=l.getKid() %>"><button class="btn btn-info" id="add"><i class="fa fa-plus"></i> ����</button></a>
       <a href="lmusicDislike?uid=<%=u.getUid() %>&mname=<%=l.getMname() %>"><button class="btn btn-info" id="add"><i class="fa fa-plus"></i> ��ϲ��</button></a>
       
   </td>
   </tr>
<%  
   }
%>


						    </tbody>
					</table>
				  </div>
			  </div>
			</div>
		</div>
</div>
	
	<script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
	<script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
	<script type="text/javascript" src="js/bootstable.js"></script>
	<script type="text/javascript">
		$('#mytable').SetEditable({
			$addButton: $('#add')
		});
	</script>
</body>
</html>