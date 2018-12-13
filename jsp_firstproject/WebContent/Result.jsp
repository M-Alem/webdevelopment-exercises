<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.ap.jdbc.JDBConnection" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<jsp:useBean id="student" class ="edu.ap.student.Student" scope="session"/>
<jsp:setProperty property='*' name='student'/>
<%
	JDBConnection connection = null;
	ArrayList<String> students = null;
	
	try{
		//extract values from POST
		String firstName = student.getFirstName();
		String lastName = student.getLastName();
		int grade = student.getGrade();
		
		connection = JDBConnection.getJDBConnection();
		connection.openConnection("Students", "root", "root");
		//String instertSQL = "INSERT INTO STUDENTS(firstname, lastname, grade)" +
				//"VALUES('" + firstName + "','" + lastName+ "','" + grade
	}
	catch(Exception e){
		System.out.println(e);
	}
	finally{
		connection.closeConnection();
	}
%>



<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultpage</title>
</head>
<body>
<h2>Without Bean</h2>
First name : <%= request.getParameter("firstName") %>
Last name: <%= request.getParameter("lastName") %>
grade: <%= request.getParameter("grade") %>

</br>

<h2>With Bean</h2>
First name : <%= student.getFirstName() %>
Last name: <%= student.getLastName() %>
grade: <%= student.getGrade() %>
</body>
</html>