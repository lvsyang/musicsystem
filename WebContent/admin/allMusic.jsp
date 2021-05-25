<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312" import="java.util.*,cn.edu.lingnan.dao.*,cn.edu.lingnan.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>���ֹ���ҳ��</title>

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
			<h1>�������� <span>�����û�����������������</span></h1>
			<%
			String uid=request.getParameter("uid");
			//UserDAO udao=new UserDAO();
			//User u=new User();
			//u=udao.findUser(uid);
			%>
			<div class="htmleaf-links">
				<a class="htmleaf-icon icon-htmleaf-home-outline" href="../ok.jsp?uid=<%=uid %>" title="ѡ���û�����" target="_blank"><span> jQuery֮��</span></a>
				<a class="htmleaf-icon icon-htmleaf-arrow-forward-outline" href="admin.jsp?uid=<%=uid %>" title="���ع���Ա�û�����" target="_blank"><span> ��������ҳ</span></a>
			</div>
		</header>
		<div class="container">
			<div class="row">
				<div class="col-md-12" style="padding:2em 0;">
				  <div class="table-responsive">
						<table class="table table-bordered table-striped" id="mytable">
						    <thead>
<tr><td>������</td><td>����id</td><td>���</td><td>past</td><td>����</td></tr>
						    </thead>
						    <tbody>
<%
	//String uid=request.getParameter("uid");
	UserDAO udao=new UserDAO();
	User u=new User();
	u=udao.findUser(uid);


	LmusicDAO ldao=new LmusicDAO();
	Vector<Music> v=new Vector<Music>();
	v=ldao.findLmusic();//�����������ֵ�DAO��������������һ������
		for(Music m:v){
%>


<tr><td><%=m.getMname() %></td><td><%=m.getMid()%></td><td><%=m.getKname()%></td>
<td><%=m.getPastm()%></td>

   <td>

       
       <a href="music/updatemusic.jsp?mid=<%=m.getMid() %>"><button class="btn btn-info" id="add"><i class="fa fa-plus"></i> ���¸���</button></a>
       <a href="deleteMusic?mid=<%=m.getMid() %>"><button class="btn btn-info" id="add"><i class="fa fa-plus"></i> ɾ������</button></a>
       <a href="banMusic?mid=<%=m.getMid() %>"><button class="btn btn-info" id="add"><i class="fa fa-plus"></i> �¼ܸ���</button></a>
       <a href="ubanMusic?mid=<%=m.getMid() %>"><button class="btn btn-info" id="add"><i class="fa fa-plus"></i> �ϼܸ���</button></a>
       
       
        <!--  <a href="playmusics?uid=<%=u.getUid() %>&kid=<%=m.getKid() %>">����</a>
       <a href="lmusicadd?uid=<%=u.getUid() %>&mname=<%=m.getMname() %> &kid=<%=m.getKid() %>">ϲ��</a>-->
       
       
       
   </td></tr>
<%  
   }
%>



						   <!--     <tr>
						        <td>����</td>
						        <td>25</td>
						        <td>zs@163.com</td>
								  <td>zs@163.com</td>
								  <td><button class="btn btn-info" id="add"><i class="fa fa-plus"></i> ����µı����</button></td>
						      </tr>
						      <tr>
						        <td>����</td>
						        <td>23</td>
						        <td>lisi@qq.com</td>
						      </tr>
						      <tr>
						        <td>����</td>
						        <td>24</td>
						        <td>ww@126.com</td>
						      </tr>-->
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