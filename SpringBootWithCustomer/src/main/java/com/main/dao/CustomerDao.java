package com.main.dao;

import java.util.List;

import com.main.model.CustomerRegistration;

public interface CustomerDao {

	public CustomerRegistration saveCustomer(CustomerRegistration customer);

	public List<CustomerRegistration> findAll(CustomerRegistration customer);

	public CustomerRegistration findByUserNameAndPassword(String userName, String password);


}
