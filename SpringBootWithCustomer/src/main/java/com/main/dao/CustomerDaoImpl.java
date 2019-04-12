package com.main.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.model.CustomerRegistration;
import com.main.repository.CustomerRepository;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	@Autowired
	CustomerRepository customerRepository;
	
	
	@Override
	public CustomerRegistration saveCustomer(CustomerRegistration customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<CustomerRegistration> findAll(CustomerRegistration customer) {
		
		return  (List<CustomerRegistration>) customerRepository.findAll();
	}

	@Override
	public CustomerRegistration findByUserNameAndPassword(String userName, String password) {
		
		return customerRepository.findByUserNameAndPassword(userName,password);
	}
	
	
	

}
