<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="java.util.*,cn.edu.lingnan.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>ע�����</title>
<script language="javascript">
function check() {
	
	var regm1 = /^[a-zA-Z_]+[a-zA-Z0-9_]+$/;
	
	
	if(form.userid.value=="") {
		alert("�û�id��Ϊ��");
		form.userid.focus();
		return false;
	}
	
	
	
	if(form.username.value=="") {
		alert("�û�����Ϊ��");
		form.username.focus();
		return false;
	}
	/*if(!form.username.value.match(regm1)) {
		alert("�û�����ʽ����ȷ");
		form.username.focus();
		return false;		
	}*/
	if(form.password.value=="") {
		alert("���벻Ϊ��");
		form.password.focus();
		return false;	
	}
	if(form.password2.value=="") {
		alert("ȷ�����벻Ϊ��");
		form.password2.focus();
		return false;	
	}
	if(form.password.value!=form.password2.value) {
		alert("���벻��ͬ");
		form.password2.value="";
		form.password2.focus();
		return false;
	}
}
</script>
</head>
<title>��ͨ�û�ע��</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>
        <link rel="stylesheet" href="adminregister/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="adminregister/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>
        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="logo span4">
                        <h1><a href="">��֮�� <span class="red">.</span></a></h1>
                    </div>
                    <div class="links span8">
                        <a class="home" href="" rel="tooltip" data-placement="bottom" data-original-title="Home"></a>
                        <a class="blog" href="" rel="tooltip" data-placement="bottom" data-original-title="Blog"></a>
                    </div>
                </div>
            </div>
        </div>

        <div class="register-container container">
            <div class="row">
                <div class="iphone span5">
                    <img src="adminregister/img/iphone.png" alt="">
                </div>
                <div class="register span6">
                    <form name="form"  method="post" action="registerServlet">
                        <h2>��ӭ������ͨ�û�ע����� <span class="red"><strong></strong></span></h2>
                        <label for="firstname">�û�id</label>
                        <input type="text" id="userid" name="userid" placeholder="��������û�id"><font color="red">*</font>
                        <label for="lastname">�û���</label>
                        <input type="text" id="username" name="username" placeholder="��������û���"><font color="red">*</font>
                        <label for="password">����</label>
                        <input type="password" id="password" name="password" placeholder="��������û�����"><font color="red">*</font>
                        <label for="email">����ȷ��</label>
                        <input type="password" id="password2" name="password2" placeholder="ȷ������ȷ�ϵ�����"><font color="red">*</font>
   <br/>
    <tr>
    <td class="item" align="right">Ȩ��</td><br/>
    <td></td>
    <td>
     <select name="superuser">
     <option value="2" selectd>��ͨ�û�
     <option value="1">һ�����Ա 
     </select>
     <font color="red">*</font>
    </td>
   </tr>
                        <td colspan="3" align="center">
                        <input type="submit" value="ע��" onClick="return check();" />
                        <input type="Reset" value="ȡ��" />
                        </td>
                        
                        
                    </form>
                </div>
            </div>
        </div>

        <!-- Javascript -->
        <script src="adminregister/js/jquery-1.8.2.min.js"></script>
        <script src="adminregister/bootstrap/js/bootstrap.min.js"></script>
        <script src="adminregister/js/jquery.backstretch.min.js"></script>
        <script src="adminregister/js/scripts.js"></script>
</body>
</html>