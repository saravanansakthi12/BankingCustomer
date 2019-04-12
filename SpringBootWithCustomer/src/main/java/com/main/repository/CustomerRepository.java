package com.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.main.model.CustomerRegistration;
import com.main.model.SavingAccount;

public interface CustomerRepository extends CrudRepository<CustomerRegistration, Integer>{

	//SavingAccount save(SavingAccount savingAccount);

	CustomerRegistration findByUserNameAndPassword(String userName, String password);

}
