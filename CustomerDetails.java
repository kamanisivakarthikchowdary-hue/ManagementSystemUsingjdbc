package org.bank.dto;

public class CustomerDetails {
/*Customer_id, Customer_name, Customer_Mobile_Number, 
 * Customer_Aadhar_number, Customer_pan_Number, Customer_Email_id, 
 * Customer_address, Customer_Designation, Customer_Account_Number, Customer_pin,
 *  IFSC_Code, Branch, Type_Of_Account,
 *   Amount, Gender/*/
	
	private int customerid;
	private String customer_name;
	private long customer_mobile_number;
	private long customer_aadhar_number;
	private String customer_pan_number;
	private String  customer_email_id;
	private String customer_address;
	private String customer_designation;
	private long Customer_account_number;
	private int customer_pin;
	private String IFSC_Code;
	private String branch;
	private String type_Of_account;
	private double  amount;
	private String  gender;
	public CustomerDetails() {
		
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public long getCustomer_mobile_number() {
		return customer_mobile_number;
	}
	public void setCustomer_mobile_number(long customer_mobile_number) {
		this.customer_mobile_number = customer_mobile_number;
	}
	public long getCustomer_aadhar_number() {
		return customer_aadhar_number;
	}
	public void setCustomer_aadhar_number(long customer_aadhar_number) {
		this.customer_aadhar_number = customer_aadhar_number;
	}
	public String getCustomer_pan_number() {
		return customer_pan_number;
	}
	public void setCustomer_pan_number(String customer_pan_number) {
		this.customer_pan_number = customer_pan_number;
	}
	public String getCustomer_email_id() {
		return customer_email_id;
	}
	public void setCustomer_email_id(String customer_email_id) {
		this.customer_email_id = customer_email_id;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getCustomer_designation() {
		return customer_designation;
	}
	public void setCustomer_designation(String customer_designation) {
		this.customer_designation = customer_designation;
	}
	public long getCustomer_account_number() {
		return Customer_account_number;
	}
	public void setCustomer_account_number(long customer_account_number) {
		Customer_account_number = customer_account_number;
	}
	public int getCustomer_pin() {
		return customer_pin;
	}
	public void setCustomer_pin(int customer_pin) {
		this.customer_pin = customer_pin;
	}
	public String getIFSC_Code() {
		return IFSC_Code;
	}
	public void setIFSC_Code(String iFSC_Code) {
		IFSC_Code = iFSC_Code;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getType_Of_account() {
		return type_Of_account;
	}
	public void setType_Of_account(String type_Of_account) {
		this.type_Of_account = type_Of_account;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public CustomerDetails(int customerid, String customer_name, long customer_mobile_number,
			long customer_aadhar_number, String customer_pan_number, String customer_email_id, String customer_address,
			String customer_designation, long customer_account_number, int customer_pin, String iFSC_Code,
			String branch, String type_Of_account, double amount, String gender) {
		
		this.customerid = customerid;
		this.customer_name = customer_name;
		this.customer_mobile_number = customer_mobile_number;
		this.customer_aadhar_number = customer_aadhar_number;
		this.customer_pan_number = customer_pan_number;
		this.customer_email_id = customer_email_id;
		this.customer_address = customer_address;
		this.customer_designation = customer_designation;
		Customer_account_number = customer_account_number;
		this.customer_pin = customer_pin;
		IFSC_Code = iFSC_Code;
		this.branch = branch;
		this.type_Of_account = type_Of_account;
		this.amount = amount;
		this.gender = gender;
	}
}
	
