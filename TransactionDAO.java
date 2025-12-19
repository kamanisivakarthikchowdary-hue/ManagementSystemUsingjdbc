package org.bank.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import org.bank.dto.TransactionDetails;

public class TransactionDAO {
private static final String insert_transaction_details="insert into transaction_details(Transaction_type,Transaction_Date,"
		+ "Transaction_Time,Transaction_Amount,Balance,Account_Number) values(?,?,?,?,?,?)";

/*****-------------- transaction insert-----------------**************************/
public boolean insertTransactionDetails(TransactionDetails transactionDetails) {
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/a15_bank_management_system?user=root& password=root");
	PreparedStatement preparedStatement=connection.prepareStatement(insert_transaction_details);
	preparedStatement.setString(1,transactionDetails.getTransactiontype());
	preparedStatement.setDate(2,Date.valueOf(transactionDetails.getTransactionDate()));
	preparedStatement.setTime(3,Time.valueOf(transactionDetails.getTransactionTime()));
	preparedStatement.setDouble(4, transactionDetails.getTransactionAmount());
	
	preparedStatement.setDouble(5, transactionDetails.getBalance());
	preparedStatement.setLong(6, transactionDetails.getAccountNumber());
	int result=preparedStatement.executeUpdate();
	if(result!=0) {
		return true;
	}else {
		return false;
	}
	
} catch (ClassNotFoundException |SQLException e) {
	
	e.printStackTrace();
	return false;
	}

}
}
