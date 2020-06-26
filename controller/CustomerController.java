package com.majedbadawi.springmvc_hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.majedbadawi.springmvc_hibernate.entity.Customer;
import com.majedbadawi.springmvc_hibernate.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	//inject customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@GetMapping("/showAddCustomerForm")
	public String showAddCustomerForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		System.out.println("saving customer: "+customer);
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showUpdateCustomerForm")
	public String showUpdateCustomerForm(@RequestParam("customerId") int id, Model model) {
		//get customer from the service
		Customer customer = customerService.getCustomer(id);
		//set customer as model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		//send it to the form
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id, Model model) {
		//delete customer
		customerService.deleteCustomer(id);
		//redirect to list
		return "redirect:/customer/list";
	}
}
