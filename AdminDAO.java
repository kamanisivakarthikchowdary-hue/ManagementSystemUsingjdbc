package org.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
	private static final String admin_login = "select * from admin_details where admin_Emailid=? and "
			+ "Admin_password=?";

	public boolean selectAminDetailsByUsingEmailidAndPassword(String emailid, String password) {
		/*
		 * private static final String-
		 * admin_login="select * from admin_details where admin_Emailid=? and " +
		 * "Admin_password=?";
		 */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/a15_bank_management_system?user=root&password=root");
			PreparedStatement preparedstatement = connection.prepareStatement(admin_login);
			preparedstatement.setString(1, emailid);
			preparedstatement.setString(2, password);
			ResultSet resultSet = preparedstatement.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}

		} catch (ClassNotFoundException |SQLException e) {
			
			e.printStackTrace();
			return false;
		} 

	}
}
