package com.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.CustomerDao;
import com.main.model.CustomerRegistration;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerDao customerDao;

	@Transactional
	public CustomerRegistration saveCustomer(CustomerRegistration customer) {
		
		return customerDao.saveCustomer(customer);		
	}

	@Transactional
	public List<CustomerRegistration> findAll(CustomerRegistration customer) {
		
		return customerDao.findAll(customer);
	}

	@Transactional
	public CustomerRegistration findByUserNameAndPassword(String userName, String password) {
		
		return customerDao.findByUserNameAndPassword(userName,password);
	}

	
	
	

}
