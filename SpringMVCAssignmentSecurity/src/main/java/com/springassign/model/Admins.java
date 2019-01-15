package com.springassign.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Admins {
	
	@Id
	private int aid;
	@NotNull
	private String aname;
	
	public Admins()
	{
		
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Admins(int aid, String aname) {
		super();
		this.aid = aid;
		this.aname = aname;
	}

}
