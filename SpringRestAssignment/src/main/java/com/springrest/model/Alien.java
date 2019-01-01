package com.springrest.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
	
	@Id
	private int aid;
	private String aname;
	private int age;
	public Alien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alien(int aid, String aname, int age) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", age=" + age + "]";
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
