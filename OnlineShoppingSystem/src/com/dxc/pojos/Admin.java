package com.dxc.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Admin {
	@Id
	private int aid;
	private String aname;
	
	public Admin()
	{
		
	}
	public Admin(int aid, String aname) {
		super();
		this.aid = aid;
		this.aname = aname;
		
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
	
	

}
