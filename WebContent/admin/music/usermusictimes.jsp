<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312" import="java.util.*,cn.edu.lingnan.dao.*,cn.edu.lingnan.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>个人页面</title>

	<link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../css/htmleaf-demo.css">
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
			<h1>查看用户听歌次数 <span>关于用户听音乐的表</span></h1>
			<%
			String uid1=request.getParameter("uid");
			//UserDAO udao=new UserDAO();
			//User u=new User();
			//u=udao.findUser(uid);
			%>
			<div class="htmleaf-links">
				<a class="htmleaf-icon icon-htmleaf-home-outline" href="../../ok.jsp?uid=<%=uid1 %>" title="选择用户界面" target="_blank"><span> jQuery之家</span></a>
				<a class="htmleaf-icon icon-htmleaf-arrow-forward-outline" href="../admin.jsp?uid=<%=uid1 %>" title="返回管理员用户界面" target="_blank"><span> 返回下载页</span></a>
			</div>
		</header>
		<div class="container">
			<div class="row">
				<div class="col-md-12" style="padding:2em 0;">
				  <div class="table-responsive">
						<table class="table table-bordered table-striped" id="mytable">
						    <thead>
<tr><td>用户id</td><td>类别id</td><td>听歌次数</td></tr>
						    </thead>
						    <tbody>
<%
	String uid=request.getParameter("uid");
	UserDAO udao=new UserDAO();
	User u=new User();
	u=udao.findUser(uid);
	
	
	IlikeDAO ldao=new IlikeDAO();
	Vector<ilike> v=new Vector<ilike>();
	v=ldao.findIlike();//
		for(ilike i:v){
%>


<tr><td><%=i.getUid()%></td><td><%=i.getKid()%></td><td><%=i.getPlaytimes()%></td>   

   </tr>
<%  
   }
%>



						   <!--     <tr>
						        <td>张三</td>
						        <td>25</td>
						        <td>zs@163.com</td>
								  <td>zs@163.com</td>
								  <td><button class="btn btn-info" id="add"><i class="fa fa-plus"></i> 添加新的表格行</button></td>
						      </tr>
						      <tr>
						        <td>李四</td>
						        <td>23</td>
						        <td>lisi@qq.com</td>
						      </tr>
						      <tr>
						        <td>王五</td>
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