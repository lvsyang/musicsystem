<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="aa" uri="/WEB-INF/tlds/myTags.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/tlds/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<aa:hello/>
	<br>
	<c:set var="a" value="aaa"/>
	<c:out value="${a}"/>
	<c:remove var="a"/>
	<c:out value="${a}"/>
	<c:catch var="b">
		<%=9/0 %>
	</c:catch>
	<c:out value="${b}"/>
	<br>
	<%
		String[] str = new String[5];
		str[0] = "aaaaa" ;
		str[1] = "bbbbb" ;
		str[2] = "ccccc" ;
		str[3] = "ddddd" ;
		str[4] = "eeeee" ;
		request.setAttribute("st", str);	
	%>
	<c:out value="${st[3]}"/>
	<c:if test="${st[2]=='ccccc'}">
		cccccccc
	</c:if>
	<c:forEach var="c" items="${st}">
	
	</c:forEach>
</body>
</html>