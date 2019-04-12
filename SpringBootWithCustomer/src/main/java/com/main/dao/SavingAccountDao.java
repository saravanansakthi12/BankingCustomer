package com.main.dao;

import com.main.model.SavingAccount;

public interface SavingAccountDao {

	SavingAccount findByCustomerIdAndAccType(int id, String string);

	void save(SavingAccount account);
	

}
