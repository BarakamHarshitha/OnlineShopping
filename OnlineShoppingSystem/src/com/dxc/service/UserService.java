package com.dxc.service;




import java.util.List;

import com.dxc.dao.UserDao;
import com.dxc.pojos.Product;
import com.dxc.pojos.User;

public class UserService {
	UserDao dao=new UserDao();
	public boolean logindetails(User u)
	{
		return dao.logindetails(u);
	}
public List<Product> getallproducts() {
		
		return dao.getallproducts();
	}



public String addtocart(int pn, int uid, int pqun) {
	// TODO Auto-generated method stub
	return dao.addtocart(pn,uid,pqun);
}
public String addbal(double balance,int uid)
{
	return dao.addbal(balance, uid);
}
public double showbalance(int uid) {
	// TODO Auto-generated method stub
	return dao.showbalance(uid);
}
public List<Product> displaycart(int uid) {
	// TODO Auto-generated method stub
	return dao.displaycart(uid);
}
public Object payBill(int uid, int cq, int pn) {
	// TODO Auto-generated method stub
	return dao.payBill(uid,cq,pn);
}

	
}
