package com.dxc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Product;
import com.dxc.pojos.User;
import com.dxc.service.AdminService;

@Controller
@RequestMapping("/views")
public class AdminController {
	AdminService service=new AdminService();
	
	
	@RequestMapping("/login")
	public String adminlogin(@ModelAttribute Admin a,Model m)
	{   
		//int aid=a.getAid();
		//String aname=a.getAname();
		
	    boolean abc=service.logindetails(a); 
	    if(abc==true)
	    {
	    	String login="LOGIN SUCESSFULLY AS ADMIN";
	    	m.addAttribute("login",login);
	    	return "adminmenu";
	    }
	    else
	    {
	   
	    	String fail="INVALID CREDENTIALS";
	    	m.addAttribute("abc",fail);
	    }
	     
	     return "message";
	}

         @RequestMapping("/add")
		public String add(@ModelAttribute Product p, Model m)
		{
			service.addproduct(p);
			String msg;
			msg="product added !";
			m.addAttribute("abc", msg);
			return "message";
		} 
         
         @RequestMapping("/displayall")
     	public String getAllproduct(Model model)
     	{
     		List<Product> list=service.getallproducts();
     		System.out.println(list);
     		model.addAttribute("list", list);
     		return "displayall";
     	}
         @RequestMapping("/find")
     	public String find(@RequestParam("pid") int pid, Model m, HttpSession session)
     	{
     		boolean status=true;
     		
     		session.setAttribute("pid", pid);
     		
     		status=service.findproduct(pid);
     		String msg;
     		
     	    if(status==true)
     		{
     			msg="product found !";
     			m.addAttribute("abc", msg);
     			return "message";
     		}
     		else 
     		{
     			msg="product not found !";
     			m.addAttribute("abc", msg);
     			return "message";
     		}
     	}
         @RequestMapping("/getproduct")
      	public String getproduct(@RequestParam("pid") int pid, Model m)
      	{
        	 String msg="";
        	 msg="product not found";
        	 m.addAttribute("abc", msg);
        	 
        	 
        	 List<Product> list=service.getproduct(pid);
        	 
      		
      		for(Product p:list)
      		{
      			if(p.getPid()==pid)
      			{
      				m.addAttribute("list", list);
      				return "showproduct";
      			}
      		}
      		return "message";
      		
      	}
         
         @RequestMapping("/adduser")
 		public String add(@ModelAttribute User u, Model m)
 		{
 			service.adduser(u);
 			String msg;
 			msg="user added !";
 			m.addAttribute("abc", msg);
 			return "message";
 		} 
         @RequestMapping("/remove")
     	public String removeuser(@RequestParam int uid, Model m)
     	{
     		service.removeuser(uid);
     		String msg="user removed !";
     		m.addAttribute("abc", msg);
     		return "message";
     	}
         @RequestMapping("/delete")
      	public String remove(@RequestParam int pid , Model m)
      	{
      		service.removeproduct(pid);
      		String msg="product removed !";
      		m.addAttribute("abc", msg);
      		return "message";
      	}

}
