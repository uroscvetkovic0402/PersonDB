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
	<form action="person_create" method="post">
		Ime:<input type="text" name="firstName"/><p></p>
	
		Prezime:<input type="text" name="lastName"/><p></p>
	
		JMBG:<input type="text" name="socialNumber.socialNumber"/><p></p>
	
		POL:<select name="gender.gender">
				<option value="MUSKI">MUSKI</option>
				<option value="ZENSKI">ZENSKI</option>
			</select>
			
		<p></p>	
		DATUM RODJENJA:<input type="text" name="dateOfBirth.date"/>
         	 
		
	
		
		
		<input type="submit" value="test">
	</form>
	
	
</body>
</html>