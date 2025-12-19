package org.bank.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TransactionDetails {
	
	/*Transaction_id, Transaction_type, Transaction_Date, 
	 * Transaction_Time, Transaction_Amount, Balance, 
	 * Account_Number*/
	private int Transactionid;
	private String Transactiontype;
	private LocalDate TransactionDate;
	private LocalTime TransactionTime;
	private double TransactionAmount;
	private double Balance;
	private long AccountNumber;
	
	
	
	public TransactionDetails() {
		
	}


	public TransactionDetails(int transactionid, String transactiontype, LocalDate transactionDate,
			LocalTime transactionTime, double transactionAmount, double balance, long accountNumber) {
	
		Transactionid = transactionid;
		Transactiontype = transactiontype;
		TransactionDate = transactionDate;
		TransactionTime = transactionTime;
		TransactionAmount = transactionAmount;
		Balance = balance;
		AccountNumber = accountNumber;
	}
	
	
	public int getTransactionid() {
		return Transactionid;
	}
	public void setTransactionid(int transactionid) {
		Transactionid = transactionid;
	}
	
	public String getTransactiontype() {
		return Transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		Transactiontype = transactiontype;
	}
	public LocalDate getTransactionDate() {
		return TransactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		TransactionDate = transactionDate;
	}
	public LocalTime getTransactionTime() {
		return TransactionTime;
	}
	public void setTransactionTime(LocalTime transactionTime) {
		TransactionTime = transactionTime;
	}
	public double getTransactionAmount() {
		return TransactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		TransactionAmount = transactionAmount;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	public long getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		AccountNumber = accountNumber;
	}
	@Override
	public String toString() {
		return "TransactionDetails [Transactionid=" + Transactionid + ", Transactiontype=" + Transactiontype
				+ ", TransactionDate=" + TransactionDate + ", TransactionTime=" + TransactionTime
				+ ", TransactionAmount=" + TransactionAmount + ", Balance=" + Balance + ", AccountNumber="
				+ AccountNumber + "]";
	}

}
