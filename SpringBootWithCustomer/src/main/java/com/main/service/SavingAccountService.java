package com.main.service;

import com.main.model.SavingAccount;

public interface SavingAccountService {

	SavingAccount findByCustomerIdAndAccType(int id, String string);

	void save(SavingAccount account);

}
