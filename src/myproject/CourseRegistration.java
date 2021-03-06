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
 * Servlet implementation class CourseRegistration
 */
@WebServlet("/CourseRegistration")
public class CourseRegistration extends GenericServlet {
	private Connection cn;

	public void init(ServletConfig config) throws ServletException {

		cn = new DatabaseConnection().createConnection();
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int courseid = Integer.parseInt(request.getParameter("cid"));
		String coursename = request.getParameter("cname");
		String fees = request.getParameter("fees");
		try {
			PreparedStatement pst = cn.prepareStatement("insert into course_reg values(?,?,?)");

			pst.setInt(1, courseid);
			pst.setString(2, coursename);
			pst.setString(3, fees);
			int i = pst.executeUpdate();
			if (i != 0) {
				out.println(" student registration sucess");
			}

			else {
				out.println("student registration fail");
			}

		} catch (Exception e) {
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
