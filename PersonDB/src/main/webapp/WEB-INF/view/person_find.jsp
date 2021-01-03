<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty msg }">
		<h1>${msg}</h1>
	</c:if>
	<form action="find_by_socialNumber" method="post">
		<input type="text" placeholder="JMBG" name="socialNumber"/>
		
		<input type="submit" value="TRAZI"/>
	</form>
</body>
</html>