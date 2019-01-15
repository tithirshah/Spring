package com.springassign.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springassign.controller.TransactionException;
import com.springassign.model.Admins;
import com.springassign.model.Customers;
import com.springassign.repo.AdminRepo;
import com.springassign.repo.CustomerRepo;

@Service
public class BankServiceImpl implements BankService{
	
	@Autowired
	CustomerRepo crepo;
	
	@Autowired
	AdminRepo arepo;
	
	
	public List<Customers> getCustomers()
	{
		List<Customers> customers=crepo.findAll();
		return customers;
	}
	
	
	public List<Admins> getAdmins()
	{
		List<Admins> admins=arepo.findAll();
		return admins;
	}


	public List<Customers> transferMoney(int n1, int n2, double amount) {
		// TODO Auto-generated method stub
		
		Optional<Customers> fcustomer=crepo.findById(n1);
		System.out.println("amount:"+amount);
		System.out.println("fcustomer:"+fcustomer.get().getBalance());
		Optional<Customers> tcustomer=crepo.findById(n2);
		System.out.println("tcustomer:"+tcustomer.get().getBalance());
		double txncharge=0.04;
		double debitamount=amount+amount*txncharge;
		System.out.println("debit:"+debitamount);
		if(fcustomer.get().getBalance()-debitamount<=1000)
		{
			System.out.println("not sufficent balance");
			throw new TransactionException("Not sufficent balance in account - Balance is "+fcustomer.get().getBalance()+"Minimum balace should be 1000");
		}
		else
		{
			tcustomer.get().setBalance(tcustomer.get().getBalance()+amount);
			System.out.println("new b tcustomer:"+tcustomer.get().getBalance());
			fcustomer.get().setBalance(fcustomer.get().getBalance()-debitamount);
			System.out.println("new f tcustomer:"+fcustomer.get().getBalance());
		}
		Customers c1=fcustomer.get();
		Customers c2=fcustomer.get();
		
		crepo.save(c1);
		crepo.save(c2);
		List<Customers> customers=crepo.findAll();
		return customers;
		
	}


	public List<Customers> saveCustomer(Customers c) {
		// TODO Auto-generated method stub
		crepo.save(c);
		List<Customers> customers=crepo.findAll();
		return customers;
	}


	public List<Admins> saveAdmin(Admins a) {
		// TODO Auto-generated method stub
		arepo.save(a);
		List<Admins> admins=arepo.findAll();
		return admins;
	}


	
	
	


	public boolean checkAmountAndNull(Customers c) {
		// TODO Auto-generated method stub
		if(c.getAccno()==0)
		{
			System.out.println("in if");
			throw new NullPointerException("Balance can't be null");
		}
		if(c.getBalance()==0.0)
		{
			System.out.println("in if");
			throw new NullPointerException("Balance can't be null");
		}
		if(c.getCname()==null || c.getCname()=="")
		{
			System.out.println("in if");
			throw new NullPointerException("Name can't be null");
		}
		if(c.getBalance()<1000)
		{
			throw new TransactionException("Minimum account balance should be 1000");
		}
		return true;
	}


	public boolean checkAdmin(Admins a) {
		// TODO Auto-generated method stub
		if(a.getAname()==null||a.getAname()=="")
			throw new NullPointerException("Name can't be null");
	
			return true;
	}
	
	
	
	

	
	
	

}
