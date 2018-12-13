<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="edu.ap.jdbc.JDBConnection" %>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean id="student" class="edu.ap.student.Student" scope="session"/>
<jsp:setProperty property="*" name="student"/>
<% 
JDBConnection connection = null;
ArrayList<String> students = null;

try {
	// extract values from POST
	String firstName = student.getFirstName();
	String lastName = student.getLastName();
	int grade = student.getGrade();
	
	// open connection and insert values
	connection = JDBConnection.getJDBConnection();
	connection.openConnection("Students", "root", "root");
	
	String insertSQL = "INSERT INTO STUDENTS(firstname, lastname, grade) " +
		"VALUES('" + firstName + "','" + lastName + "'," + grade + ");";
	System.out.println(insertSQL);
	connection.executeInsert(insertSQL);
	
	// list all students
	String selectSQL = "SELECT * FROM STUDENTS ORDER BY lastname;";
	students = connection.selectAll(selectSQL);
}
catch(Exception e) {
	System.out.println(e);
}
finally {
	connection.closeConnection();
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
</head>
<body>
<br/><br/>
<h2>Grade List</h2>
<table>
<tr>
	<td><b>First name</b></td>
	<td><b>Last name</b></td>
	<td><b>Grade</b></td>
</tr>
<%
	/*for(String s: students) {
		String[] fields = s.split(";");

		out.println("<tr><td>" + fields[0] + "</td>" + "<td>" + fields[1] + "</td>" + "<td>" + fields[2] + "</td></tr>");
	}*/

%>
</table>
</body>
</html>
