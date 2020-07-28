package com.dxc.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Product;
import com.dxc.pojos.User;
import com.mysql.jdbc.Connection;

public class AdminDao
{
private static SessionFactory sessionFactory;
	
	static
	{
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	
	public boolean logindetails(Admin a) 
	{
		Session session=sessionFactory.openSession();
	
		
		Query query=session.createQuery("from Admin");
		 List<Admin> list= query.getResultList();
			for(Admin l:list)
			{
			   if(a.getAid()==l.getAid() && a.getAname().equals(l.getAname()))
				{
					return true;
				}
				
			}
			
				return  false;
	}

	public void addproduct(Product p) 
	{
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(p);
		
		session.getTransaction().commit();
	}

	public List<Product> getallproducts() 
	{
		Session session=sessionFactory.openSession();
		Query query1=session.createQuery("from Product");
		return query1.getResultList();
	}
    public List<Product> getproduct(int pid)
    {
    	List<Product> list=new ArrayList<>();
    	if(findproduct(pid))
    	{
    		Session session=sessionFactory.openSession();
    		session.beginTransaction();
		Query query=session.createQuery("from Product where pid=:pid");
		query.setParameter("pid", pid);
		List<Product> p1=query.getResultList();
    	session.getTransaction().commit();
    	return p1;	
    	}
    	return list;
    }
	public boolean findproduct(int pid) {
		Product p=null;
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where pid=:pid");
		query.setParameter("pid", pid);
		List<Product> p1=query.getResultList();
		try {
			p=p1.get(0);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void removeuser(int i)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("delete from User where uid=:i");
		query.setParameter("i", i);
		query.executeUpdate();
		session.getTransaction().commit();
	}

	public void adduser(User u) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		
	}

	public void removeproduct(int id) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("delete from Product where pid=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		session.getTransaction().commit();
	}

	
	
}
