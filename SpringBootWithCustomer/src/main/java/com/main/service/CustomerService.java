package com.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.main.model.CustomerRegistration;

@Service
public interface CustomerService {

	public CustomerRegistration saveCustomer(CustomerRegistration customer);

	public List<CustomerRegistration> findAll(CustomerRegistration customer);

	public CustomerRegistration findByUserNameAndPassword(String userName, String password);

}
