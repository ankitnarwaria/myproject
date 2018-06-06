package myproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "ankit123");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
