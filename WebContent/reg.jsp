<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.PreparedStatement" %>



<%  
 String id=request.getParameter("id");
String name=request.getParameter("name");
String email=request.getParameter("email");
String address=request.getParameter("address");
String qual=request.getParameter("qual");


Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","ankit123");
PreparedStatement ps=cn.prepareStatement("insert into student1 values(?,?,?,?,?)");
 ps.setString(1,id);
 ps.setString(2,name);
 ps.setString(3,email);
 ps.setString(4,address);
 ps.setString(5,qual);
   int i=ps.executeUpdate();

   if(i!=0)
	   out.println("Registration Success :)");
	   else
		   out.println("Registration Failure :)");
		   



%>