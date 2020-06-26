package com.majedbadawi.springmvc_hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.majedbadawi.springmvc_hibernate.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//inject hibernate's session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		//get current session
		Session session = sessionFactory.getCurrentSession();
		//create query
		Query<Customer> query = session.createQuery("from Customer order by first_name", Customer.class);
		//execute query and get list
		List<Customer> customers = query.getResultList();
		//return results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		//get current session
		Session session = sessionFactory.getCurrentSession();
		//save the customer
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		//get current session
		Session session = sessionFactory.getCurrentSession();
		//get the customer with id
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		//get current session
		Session session = sessionFactory.getCurrentSession();
		//get the customer with id
		Customer customer = session.get(Customer.class, id);
		//delete customer with id
		session.delete(customer);
	}

}
