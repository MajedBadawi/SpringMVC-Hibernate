package com.majedbadawi.springmvc_hibernate.dao;

import java.util.List;

import com.majedbadawi.springmvc_hibernate.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
