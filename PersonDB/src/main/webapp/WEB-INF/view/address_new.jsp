<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="address_create" method="post">
		
		Drzava:<input type="text" name="address.state.state"><p></p>
		Grad:<input type="text" name="address.city.city"><p></p>
		Ulica:<input type="text" name="address.street"><p></p>
		Broj zgrade/kuce:<input type="text" name="address.buildingNumber"><p></p>
		Broj stana:<input type="text" name="address.apartmentNumber"><p></p>
		
		<input type="submit" value="SACUVAJ"/>
	</form>
</body>
</html>