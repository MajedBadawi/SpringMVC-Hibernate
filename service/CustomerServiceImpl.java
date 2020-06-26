package com.majedbadawi.springmvc_hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majedbadawi.springmvc_hibernate.dao.CustomerDAO;
import com.majedbadawi.springmvc_hibernate.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	//inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers(){
		List<Customer> customers = customerDAO.getCustomers();
		return customers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}
}
