<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="java.util.*,cn.edu.lingnan.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>注册</title>
<script language="javascript">
function check() {
	
	var regm1 = /^[a-zA-Z_]+[a-zA-Z0-9_]+$/;
	
	
	if(form.userid.value=="") {
		alert("用户id不为空");
		form.userid.focus();
		return false;
	}
	
	
	
	if(form.username.value=="") {
		alert("姓名不为空");
		form.username.focus();
		return false;
	}
	if(!form.username.value.match(regm1)) {
		alert("姓名格式不正确");
		form.username.focus();
		return false;		
	}
	if(form.password.value=="") {
		alert("密码不为空");
		form.password.focus();
		return false;	
	}
	if(form.password2.value=="") {
		alert("确认密码不为空");
		form.password2.focus();
		return false;	
	}
	if(form.password.value!=form.password2.value) {
		alert("密码不相同");
		form.password2.value="";
		form.password2.focus();
		return false;
	}
}
</script>
</head>
<body>
<form name="form" method="post" action="registerServlet">
  <table width="450"  height="150">
  
  <tr>
   <td width="42%" align="right">用户id</td>
   <td width="%8"></td>
   <td width="%50">
    <input type="text" name="userid" id="userid">
    <font color="red">*</font>
   </td>
  </tr>
  
  <tr>
   <td width="42%" align="right">用户名</td>
   <td width="%8"></td>
   <td width="%50">
    <input type="text" name="username" id="username">
    <font color="red">*</font>
   </td>
  </tr>
  
  
  
  
  <tr>
   <td class="item" align="right">密码</td>
   <td></td>
   <td>
    <input type="password" name="password" id="password">
    <font color="red">*</font>
   </td>
  </tr>
  <tr>
   <td class="item" align="right">密码确认</td>
   <td></td>
   <td>
    <input type="password" name="password2" id="password2">
    <font color="red">*</font>
   </td>
  </tr>
  <tr>
    <td class="item" align="right">权限</td>
    <td></td>
    <td>
     <select name="superuser">
     <option value="2" selectd>普通用户
     <!-- <option value="1">一般管理员 -->  
     </select>
     <font color="red">*</font>
    </td>
   </tr>
   <tr>
    <td colspan="3" align="center">
     <input type="submit" value="注册" onClick="return check();" />
     <input type="Reset" value="取消" />
    </td>
    <h1 align="center">欢迎来到普通用户注册界面</h1>
         <p align="right"><font color="red">(管理员注册受限，请前往管理员登录注册)</font></p>
   </tr>  
  </table>
 </form>
</body>
</html>