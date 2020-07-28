package com.dxc.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.dxc.pojos.Product;
import com.dxc.pojos.User;
import com.dxc.service.UserService;
@Controller
@RequestMapping("/views")
public class UserController {
UserService service=new UserService();
List<Product> list=new ArrayList<>();
	@RequestMapping("/loginuser")
	public String userlogin(@ModelAttribute User u,HttpSession session,Model m)
	{   
		
		session.setAttribute("uid", u.getUid());
	    boolean abc=service.logindetails(u); 
	    if(abc==true)
	    {
	    	String login="LOGIN SUCESSFULLY AS CUSTOMER";
	    	m.addAttribute("login1",login);
	    	return "usermenu";
	    }
	    else
	    {
	       String fail="INVALID CREDENTIALS";
	    	m.addAttribute("abc",fail);
	    }
	     
	     return "message";
	}

	@RequestMapping("/displaylist")
 	public String getAllproduct(Model model)
 	{
 		List<Product> list=service.getallproducts();
 		System.out.println(list);
 		model.addAttribute("list", list);
 		return "displaylist";
 	}
    @RequestMapping("/addcart")
    public String addcart(@RequestParam("pid") int pn,@RequestParam int pqun,HttpSession session, Model m)
    {
    	session.setAttribute("cqun", pqun);
    	session.setAttribute("pid", pn);
    	int uid=(int)session.getAttribute("uid");
    	System.out.println(uid);
    	String s=service.addtocart(pn,uid,pqun);
    	m.addAttribute("abc",s);
    	return "message";
    }
    @RequestMapping("/displaycart")
    public String displaycart(Model m,HttpSession session)
    {
    	int uid=(int)session.getAttribute("uid");
    	List<Product> listp=service.displaycart(uid);
    	m.addAttribute("listp",listp);
    	return "cartlist";
    	
    }
    @RequestMapping("/addbalance")
    public String addbalance(@RequestParam double balance,HttpSession session, Model m)
    {
    	int uid=(int)session.getAttribute("uid");
    	String s=service.addbal(balance,uid);
    	m.addAttribute("abc", s);
    	return "message";
    }
    @RequestMapping("/showbalance")
    public String showbal(HttpSession session,Model m)
    {
    	int uid=(int)session.getAttribute("uid");
    	double b=service.showbalance(uid);
    	m.addAttribute("b",b);
    	return "showbalance";
    	
    }
    @RequestMapping("/paybill")
    public String payBill(HttpSession session,Model m)
    {
        int cq=(int)session.getAttribute("cqun");
        int pn=(int)session.getAttribute("pid");
        int uid=(int)session.getAttribute("uid");
        String msg=(String) service.payBill(uid,cq,pn);
       
        m.addAttribute("abc",msg);
      
        return "message";
    }
}
