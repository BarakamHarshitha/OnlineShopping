package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.dxc.pojos.Product;
import com.dxc.pojos.User;

public class UserDao {
private static SessionFactory sessionFactory;
User user=new User();
Product product=new Product();	
	static
	{
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	
	public boolean logindetails(User u) 
	{
		Session session=sessionFactory.openSession();
		
		//session.beginTransaction();
		//session.save(a);
		//session.getTransaction().commit();
		
		Query query=session.createQuery("from User");
		 List<User> list= query.getResultList();
			for(User l:list)
			{
			   if(u.getUid()==l.getUid() && u.getName().equals(l.getName()))
				{
					return true;
				}
				
			}
			
				return  false;
	}

	 public List<Product> getallproducts() 
	{
		Session session=sessionFactory.openSession();
		Query query1=session.createQuery("from Product");
		return query1.getResultList();
	}
	 public String addtocart(int pn,int uid,int pqun)
	 {
		 Session session=sessionFactory.openSession();
		 session.beginTransaction();
		 user=session.get(User.class, uid);
		 product.getUlist().add(user);
		 Product p=(Product)session.get(Product.class, pn);
	     boolean b=user.getPlist().add(p);
	     int qun=pqun;
	    
	     System.out.println(qun);
	     Query query=session.createQuery("from Product where pid=:pn");
	     query.setParameter("pn", pn);
	     List<Product> p1=query.getResultList();
	     Product pro= p1.get(0);
	     qun=pro.getPqun()-qun;
	     Query query1=session.createQuery("update Product set pqun=:qun where pid=:pn");
	     query1.setParameter("qun", qun);
	     query1.setParameter("pn", pn);
		 query1.executeUpdate();
		 session.getTransaction().commit();
		 session.close();
		 return "product added to cart..........";
	 }
	 public List<Product> displaycart(int uid)
	 {
		 List<Product> list= new ArrayList<>();
		 Session session=sessionFactory.openSession();
		
		 user=session.get(User.class,uid);
		 if(user!=null)
		 {
			 list=user.getPlist();
			 System.out.println(list);
		 }
		 session.close();
		 return list;
		 
	 }
	 public String addbal(double balance,int uid)
	 {

		 Session session=sessionFactory.openSession();
		 session.beginTransaction();
		 Query query1=session.createQuery("update User set balance=:balance+balance where uid=:uid");
		 query1.setParameter("balance",balance);
	     query1.setParameter("uid", uid);
	     query1.executeUpdate();
		 session.getTransaction().commit();
		 session.close();
		 return "sucessfully added";
	 }
	 public double showbalance(int uid)
	 {
		 Session session=sessionFactory.openSession();
		 session.beginTransaction();
		 Query query1=session.createQuery("from User where uid=:uid");
		 query1.setParameter("uid",uid);
		 List<User> l=query1.getResultList();
		 User u1=l.get(0);
		 double d=u1.getBalance();
		 session.getTransaction().commit();
		 session.close();
		 return d;
		 
		 
	 }
	 public String payBill(int uid,int cq,int pn)
	    {
	        double total=0;
	        double cbal;
	        List<Product> list=new ArrayList<>();
	        Session session=sessionFactory.openSession();
	        session.beginTransaction();
	        user=session.get(User.class,uid);
	       
	        if(user!=null)
	        {
	            list=user.getPlist();
	        }

	        int a=list.get(0).getPid();

	           
	            
	            if(a==pn)
	            {
	                
	                double cash=list.get(0).getCost();
	                System.out.println(cash);
	                double disc=list.get(0).getPdis();
	                cash=cash-disc;
	                cash=cash*cq;
	                total=total+cash;
	                System.out.println(cash);
	                System.out.println(total);
	            }
	        
	        cbal=user.getBalance();
	        System.out.println(cbal);
	        cbal=cbal-total;
	        System.out.println(cbal);
	        user.setBalance(cbal);
	    
	        System.out.println(total);
	        list.clear();
	        session.getTransaction().commit();
	        session.close();
	        return "Billpaid";
	        
	        
	    }

	
}
