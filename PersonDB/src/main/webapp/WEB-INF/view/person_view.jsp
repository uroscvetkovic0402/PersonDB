<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Podaci o licu</title>
</head>
<body>
	<table>
		
		<tr>
			<td>IME:</td>				<td>${person.firstName}	</td>
		</tr>	
		<tr>	
			<td>PREZIME:</td>			<td>${person.lastName}</td>
		</tr>
		<tr>	
			<td>JMBG:</td>				<td>${person.socialNumber.socialNumber}</td>
		</tr>
		<tr>
			<td>POL:</td>				<td>${person.gender.gender}</td>
		</tr>
		<tr>	
			<td>DATUM RODJENJA:</td>	<td> <fmt:formatDate value="${person.dateOfBirth.date}" type="date" pattern="dd-MMM-yyyy"/></td>
		</tr>
		
	
	</table>
	
	
</body>
</html>