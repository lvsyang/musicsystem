<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="java.util.*,cn.edu.lingnan.dto.*,cn.edu.lingnan.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>�����û�</title>
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
			<h1>����Ա�޸��û� <span>���ڹ���Ա�޸��û��ı�</span></h1>
			<%
			//String uid=request.getParameter("uid");
			//UserDAO udao=new UserDAO();
			//User u1=new User();
			//u1=udao.findUser(uid);
					String uid=(String)session.getAttribute("uid");


			%>
			<div class="htmleaf-links">
				<a class="htmleaf-icon icon-htmleaf-home-outline" href="../ok.jsp?uid=<%=uid %>" title="ѡ���û�����" target="_blank"><span> ѡ���û�����</span></a>
				<a class="htmleaf-icon icon-htmleaf-arrow-forward-outline" href="admin.jsp?uid=<%=uid %>" title="���ع���Ա�û�����" target="_blank"><span> ѡ���û�����</span></a>
			</div>
		</header>
		<div class="container">
			<div class="row">
				<div class="col-md-12" style="padding:2em 0;">
				  <div class="table-responsive">
						<table class="table table-bordered table-striped" id="mytable">
						    <thead>
						      <tr><td>���id</td><td>����</td><td>����</td><td>Ȩ��</td><td>ban</td><td>������</td></tr>
						    </thead>
						    <tbody>
<%
Vector<User> v = new Vector<User>();
v = (Vector<User>)session.getAttribute("allUser");
Iterator<User> it =v.iterator();
User u =new User();
   while(it.hasNext()){
	   u=it.next();
%>


   <tr><td><%=u.getUid() %></td><td><%=u.getUname()%></td>
   <td><%=u.getUpassword()%></td><td><%=u.getSuperuser()%></td>
   <td><%=u.getBan()%></td>
   <td>
   
       <!--  <a href="updateUser.jsp?uid=<%=u.getUid() %>">����</a>
      
       <a href="javascript:if(confirm('ȷʵҪɾ�����û���?')){location='deleteUser?uid=<%=u.getUid() %>'}">ɾ��</a>
       <a href="banUser?uid=<%=u.getUid() %>">���</a>
       <a href="ubanUser?uid=<%=u.getUid() %>">���</a>
       -->
       
       <a href="updateUser.jsp?uid=<%=u.getUid() %>"><button class="btn btn-info" id="add"><i class="fa fa-plus"></i> ����</button></a>
       
       
       <a href="javascript:if(confirm('ȷʵҪɾ�����û���?')){location='deleteUser?uid=<%=u.getUid() %>'}"><button class="btn btn-info" id="add"><i class="fa fa-plus"></i> ɾ��</button></a>
       <a href="banUser?uid=<%=u.getUid() %>"><button class="btn btn-info" id="add"><i class="fa fa-plus"></i> ���</button></a>
       <a href="ubanUser?uid=<%=u.getUid() %>"><button class="btn btn-info" id="add"><i class="fa fa-plus"></i> ���</button></a>
          </td></tr>
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