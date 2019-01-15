package com.springassign.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Customers {
	
	@Id
	private int accno;
	@NotNull
	private String cname;
	@NotNull
	private double balance;
	
	public Customers()
	{
		
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customers(int accno, String cname, double balance) {
		super();
		this.accno = accno;
		this.cname = cname;
		this.balance = balance;
	}
	
}
