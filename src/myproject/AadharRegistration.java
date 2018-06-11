package myproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/reg")
public class AadharRegistration extends HttpServlet {

	Connection connection;

	@Override
	public void init() {
		connection = new DatabaseConnection().createConnection();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession hs = request.getSession();
		String fno = request.getParameter("fno");

		if (fno.equals("1")) {
			String name = request.getParameter("name");
			String fname = request.getParameter("fname");
			String mname = request.getParameter("mname");
			hs.setAttribute("name", name);
			hs.setAttribute("fname", fname);
			hs.setAttribute("mname", mname);
			response.sendRedirect("./form2.html");
		}
		if (fno.equals("2")) {
			String contact = request.getParameter("contact");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			hs.setAttribute("contact", contact);
			hs.setAttribute("email", email);
			hs.setAttribute("address", address);
			response.sendRedirect("./form3.html");

		}
		if (fno.equals("3")) {
			String qual = request.getParameter("qual");
			String per = request.getParameter("per");

			String name = (String) hs.getAttribute("name");
			String fname = (String) hs.getAttribute("fname");
			String mname = (String) hs.getAttribute("mname");

			String contact = (String) hs.getAttribute("contact");
			String email = (String) hs.getAttribute("email");
			String address = (String) hs.getAttribute("address");

			try {
				PreparedStatement ps = connection.prepareStatement("insert into aadharreg values(?,?,?,?,?,?,?,?)");
				ps.setString(1, name);
				ps.setString(2, fname);
				ps.setString(3, mname);
				ps.setString(4, contact);
				ps.setString(5, email);
				ps.setString(6, address);
				ps.setString(7, qual);
				ps.setString(8, per);
				int i = ps.executeUpdate();
				if (i != 0) {
					out.println("sucessful");
				} else {
					out.println("fialure");
				}
			} catch (Exception e) {
				out.println("fail");
				System.out.println("Exception" + e);
				e.printStackTrace();
			}

		}

	}

}
