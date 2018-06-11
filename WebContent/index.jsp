<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>first jsp</title>
</head>
<body>

<% Class.forName("com.mysql.jdbc.Driver").newInstance();
 Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","ankit123");
 PreparedStatement ps=cn.prepareStatement("select * from qualification");
 ResultSet rs=ps.executeQuery();

 
 
%>
<form action="./reg.jsp">
ID: <input type="text" name="id"/><br>
NAME: <input type="text" name="name"/><br>
EMAIL: <input type="text" name="email"/><br>
ADDRESS: <input type="text" name="address"/>
<br>
QUAL: 

      <select name="qual">
      <% while(rs.next()){    %>
      <option value=" <%=rs.getString(2)%>"> <%=rs.getString(2) %> </option>
    <% }%>
      </select>
    
  <input type="submit" value="reister">
</form>


</body>
</html>