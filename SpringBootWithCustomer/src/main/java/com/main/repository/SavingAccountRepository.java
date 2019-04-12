package com.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.main.model.SavingAccount;

public interface SavingAccountRepository extends CrudRepository<SavingAccount, Integer>{

	SavingAccount findByCustomerIdAndAccType(int id, String string);

	SavingAccount save(SavingAccount savingAccount);

}
