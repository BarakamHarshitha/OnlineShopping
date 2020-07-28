package com.dxc.service;

import java.util.List;

import com.dxc.dao.AdminDao;
import com.dxc.pojos.Admin;
import com.dxc.pojos.Product;
import com.dxc.pojos.User;

public class AdminService {
	AdminDao dao=new AdminDao();
	public boolean logindetails(Admin a)
	{
		return dao.logindetails(a);
	}
	public void addproduct(Product p) {
		// TODO Auto-generated method stub
		 dao.addproduct(p);
	}
	public List<Product> getallproducts() {
		
		return dao.getallproducts();
	}
	public boolean findproduct(int pid) {
		// TODO Auto-generated method stub
		return dao.findproduct(pid);
	}
	public List<Product> getproduct(int pid)
	{
		return dao.getproduct(pid);
	}
	public void removeuser(int uid) {
		 dao.removeuser(uid);
		
	}
	public void adduser(User u) {
		dao.adduser(u);
		
	}
	public void removeproduct(int pid) {
		// TODO Auto-generated method stub
		dao.removeproduct(pid);
	}
}
