package myproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class StudentRegistration
 */
@WebServlet("/StudentRegistration")
public class StudentRegistration extends GenericServlet {

	private Connection cn;

	public void init(ServletConfig config) throws ServletException {
		cn = new DatabaseConnection().createConnection();
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int studentid = Integer.parseInt(request.getParameter("sid"));
		String studentname = request.getParameter("sname");
		String email = request.getParameter("semail");
		try {
			PreparedStatement pst = cn.prepareStatement("insert into student values(?,?,?)");

			pst.setInt(1, studentid);
			pst.setString(2, studentname);
			pst.setString(3, email);
			int i = pst.executeUpdate();
			if (i != 0) {
				out.println(" student registration sucess");
			} else {
				out.println("student registration fail");
			}
		} catch (Exception e) {
			out.println(" Exception" + e);

		}

	}

	public void destroy() {
		try {
			cn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
