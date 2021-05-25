<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="5; url=index.html;charset=GBK">
<title>Insert title here</title>
</head>


<script type="text/javascript">
var time =5;  
function number(){  
      window.setTimeout("number()",1000);  
      if(time >= 0){  
         var obj = document.getElementById("number");  
         obj.innerHTML = "";  
         obj.innerHTML = "系统还有"+time+"秒为您跳转到首页";  
         time--;  
      }  
}     
</script>



<body onload="number()">
<div id="number">
aaa
</div>
</body>
</html>
