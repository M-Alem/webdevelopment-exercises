<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>jsp test</title>
</head>
<body>
Kies een lector:

<form method='POST'>
	<input type="checkbox" name="lector" value="Olga Coutrin"> Olga Coutrin
	<input type="checkbox" name="lector" value="Philippe Possemiers"> Philippe Possemiers
	<input type="checkbox" name="lector" value="Kelly Casal"> Kelly Casal
	
	<input type="submit" value="Submit">
</form>
<br>


<%
	out.println("Uw gekozen lectoren:");
	String[] lectors = request.getParameterValues("lector");
	if(lectors != null){
		for(String lector : lectors){
			out.println("<li>" + lector + "</li>");
		}
	}
	
	//extra: refresh knop
%>
</body>
</html>