package com.springassign.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springassign.model.Admins;
import com.springassign.model.Customers;
import com.springassign.repo.AdminRepo;
import com.springassign.repo.CustomerRepo;
import com.springassign.service.BankServiceImpl;


@Controller
public class BankController {
	
	@Autowired
	CustomerRepo crepo;
	
	@Autowired
	AdminRepo arepo;
	
	@Autowired
	BankServiceImpl bservice;
	

	@GetMapping("/accounts")
	
	public ModelAndView getAccounts(ModelAndView mv)
	{
		//List<Customers> customers=crepo.findAll();
		List<Customers> customers=bservice.getCustomers();
		mv.addObject("customers",customers);
		mv.setViewName("DisplayAccounts");
		return mv;
	}
	
	
	
	@GetMapping("/admins")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView getAdmins(ModelAndView mv)
	{

		List<Admins> admins=bservice.getAdmins();
		mv.addObject("admins",admins);
		mv.setViewName("DisplayAdmins");
		
		return mv;
	}
	
	@GetMapping("sendMoneyForm")
	public ModelAndView sendMoneyForm(ModelAndView mv)
	{
		mv.setViewName("TransferMoney");
		return mv;
	}
	
	@GetMapping("/sendMoney")
	public ModelAndView sendMoney(@RequestParam("accfrom") int n1,@RequestParam("accto") int n2,@RequestParam("amount") double amount)
	{
		
		ModelAndView mv=new ModelAndView();
		System.out.println("Customer controller");
		
		List<Customers> customers = new ArrayList<Customers>();
		customers=bservice.transferMoney(n1,n2,amount);
		

		mv.addObject("customers",customers);
		mv.setViewName("DisplayAccounts");
		return mv;
	}
	
	@RequestMapping("addCustomer")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView addCustomer(ModelAndView mv)
	{
		
		Customers customer=new Customers();
		mv.addObject("customer",customer);
		
		mv.setViewName("AddCustomerForm");
		
		return mv;
		
		
		
		
		
	}
	
	

	
	@RequestMapping("addAdmin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView addAdmin(ModelAndView mv)
	{

		
		Admins admin=new Admins();
		mv.addObject("admin",admin);
		
		mv.setViewName("AddAdminForm");
		return mv;

	}
	
	@PostMapping("/saveCustomer")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView saveCustomer(@ModelAttribute("customer") Customers c, ModelAndView mv)
	{
		
		boolean b=bservice.checkAmountAndNull(c);
		System.out.println("Name:"+c.getCname());
		
		if(b)
		{
		List<Customers> customers=bservice.saveCustomer(c);
		mv.addObject("customers",customers);
		mv.setViewName("DisplayAccounts");
		}
		return mv;
	}
	
	@PostMapping("/saveAdmin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView saveAdmin(@ModelAttribute("admin") Admins a,ModelAndView mv)
	{
		
		boolean b=bservice.checkAdmin(a);
		if(b)
		{
		System.out.println("Name:"+a.getAname());
		List<Admins> admins=bservice.saveAdmin(a);
		mv.addObject("admins",admins);
		mv.setViewName("DisplayAdmins");
		}
		return mv;
	}
	
	
	
	

}
