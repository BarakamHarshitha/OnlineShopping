package com.dxc.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	private int uid;
	private String name;
	private double balance;
	@ManyToMany
	@JoinTable(name="Cart",
	joinColumns=@JoinColumn(name="customerid"),
	inverseJoinColumns=@JoinColumn(name="productid"))
	private List<Product> plist= new ArrayList<>();
	public User()
	{
		
	}
	public User(int uid, String name, double balance) {
		super();
		this.uid = uid;
		this.name = name;
		this.balance = balance;
		
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<Product> getPlist() {
		return plist;
	}
	public void setPlist(List<Product> plist) {
		this.plist = plist;
	}
	
    
}
