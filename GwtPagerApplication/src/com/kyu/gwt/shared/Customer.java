package com.kyu.gwt.shared;

import java.util.ArrayList;

public class Customer {
	private String CustomerID;
	private String CustomerName;
	private String CustomerSurname;
	private String CustomerMail;
	private String CustomerBranch;
	
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerSurname() {
		return CustomerSurname;
	}
	public void setCustomerSurname(String customerSurname) {
		CustomerSurname = customerSurname;
	}
	public String getCustomerMail() {
		return CustomerMail;
	}
	public void setCustomerMail(String customerMail) {
		CustomerMail = customerMail;
	}
	public String getCustomerBranch() {
		return CustomerBranch;
	}
	public void setCustomerBranch(String customerBranch) {
		CustomerBranch = customerBranch;
	}
	public ArrayList<Customer> addCustomerList(){
		Customer customer;
		ArrayList<Customer> Customer_temp=new ArrayList<Customer>();
		for(int i=1;i<6;i++){
			customer = new Customer();
			customer.setCustomerID("100"+(i));
			customer.setCustomerName("Name"+i);
			customer.setCustomerSurname("Surname"+i);
			customer.setCustomerMail("N"+i+"S"+i+"@gmail.com");
			Customer_temp.add(customer);
		}
		return Customer_temp;
	}
	
}
