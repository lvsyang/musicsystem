<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK" import="java.util.*,cn.edu.lingnan.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>ע��</title>
<script language="javascript">
function check() {
	
	var regm1 = /^[a-zA-Z_]+[a-zA-Z0-9_]+$/;
	
	
	if(form.userid.value=="") {
		alert("�û�id��Ϊ��");
		form.userid.focus();
		return false;
	}
	
	
	
	if(form.username.value=="") {
		alert("������Ϊ��");
		form.username.focus();
		return false;
	}
	if(!form.username.value.match(regm1)) {
		alert("������ʽ����ȷ");
		form.username.focus();
		return false;		
	}
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
<body>
<form name="form" method="post" action="registerServlet">
  <table width="450"  height="150">
  
  <tr>
   <td width="42%" align="right">�û�id</td>
   <td width="%8"></td>
   <td width="%50">
    <input type="text" name="userid" id="userid">
    <font color="red">*</font>
   </td>
  </tr>
  
  <tr>
   <td width="42%" align="right">�û���</td>
   <td width="%8"></td>
   <td width="%50">
    <input type="text" name="username" id="username">
    <font color="red">*</font>
   </td>
  </tr>
  
  
  
  
  <tr>
   <td class="item" align="right">����</td>
   <td></td>
   <td>
    <input type="password" name="password" id="password">
    <font color="red">*</font>
   </td>
  </tr>
  <tr>
   <td class="item" align="right">����ȷ��</td>
   <td></td>
   <td>
    <input type="password" name="password2" id="password2">
    <font color="red">*</font>
   </td>
  </tr>
  <tr>
    <td class="item" align="right">Ȩ��</td>
    <td></td>
    <td>
     <select name="superuser">
     <option value="2" selectd>��ͨ�û�
     <!-- <option value="1">һ�����Ա -->  
     </select>
     <font color="red">*</font>
    </td>
   </tr>
   <tr>
    <td colspan="3" align="center">
     <input type="submit" value="ע��" onClick="return check();" />
     <input type="Reset" value="ȡ��" />
    </td>
    <h1 align="center">��ӭ������ͨ�û�ע�����</h1>
         <p align="right"><font color="red">(����Աע�����ޣ���ǰ������Ա��¼ע��)</font></p>
   </tr>  
  </table>
 </form>
</body>
</html>