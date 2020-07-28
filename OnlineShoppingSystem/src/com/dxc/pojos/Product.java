package com.dxc.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	private int pid;
	private String pname;
	private double cost;
	private int pdis;
	private int pqun;
	@ManyToMany(mappedBy = "plist",fetch = FetchType.EAGER)
	private List<User> ulist=new ArrayList<>();
	public Product()
	{
		
	}
	public Product(int pid, String pname, double cost, int pdis, int pqun, List<User> list) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.cost = cost;
		this.pdis = pdis;
		this.pqun = pqun;
	
		
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getPdis() {
		return pdis;
	}
	public void setPdis(int pdis) {
		this.pdis = pdis;
	}
	public int getPqun() {
		return pqun;
	}
	public void setPqun(int pqun) {
		this.pqun = pqun;
	}
	
	
	public List<User> getUlist() {
		return ulist;
	}
	public void setUlist(List<User> ulist) {
		this.ulist = ulist;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", cost=" + cost + ", pdis=" + pdis + ", pqun=" + pqun
				+ "]";
	}
	
	
	
	

}
