package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTestConnection {

	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return MySQLConnUtils.getMySQLConnection();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Get connection...");

		Connection conn = MySQLTestConnection.getMyConnection();

		System.out.println("Opened connection: " + conn);

		Statement statement = conn.createStatement();

		String sql = "Select Emp.Emp_Id, Emp.First_Name, Emp.Last_Name, Emp.Dept_Id From Employee Emp;";

		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			int empID = result.getInt(1);
			String empFirstName = result.getString(2);
			String empLastName = result.getString("Last_Name");

			System.out.println("______________________________________");
			System.out.println("Emp ID: " + empID);
			System.out.println("Emp FirstName: " + empFirstName);
			System.out.println("Emp LastName: " + empLastName);
		}

		conn.close();
		System.out.println("______________Closed Connection_____________");

	}

}
