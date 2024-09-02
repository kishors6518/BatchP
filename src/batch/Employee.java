package batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Employee {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// Load the Driver

		Class.forName("com.mysql.cj.jdbc.Driver");

		// Establish the connection

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");

		// Create statement
		String query = "insert into employee values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, 8);
		ps.setString(2, "Tushar");
		ps.setLong(3, 9856238956l);
		ps.setDouble(4, 50000.50);
		ps.setString(5, "Nagpur");

		ps.addBatch();

		ps.setInt(1, 9);
		ps.setString(2, "Ram");
		ps.setLong(3, 9856274588l);
		ps.setDouble(4, 50500.50);
		ps.setString(5, "Panchincholi");

		ps.addBatch();

		ps.executeBatch();
		ps.close();
		con.close();

	}

}
