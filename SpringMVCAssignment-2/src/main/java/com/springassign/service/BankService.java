package com.springassign.service;

import java.util.List;

import com.springassign.model.Admins;
import com.springassign.model.Customers;

public interface BankService {
	
	public List<Customers> getCustomers();
	public List<Admins> getAdmins();
	public List<Customers> transferMoney(int n1, int n2 , double n3);
	public List<Customers> saveCustomer(Customers c);
	public List<Admins> saveAdmin(Admins a);
	public boolean checkAmountAndNull(Customers c);
	

}
