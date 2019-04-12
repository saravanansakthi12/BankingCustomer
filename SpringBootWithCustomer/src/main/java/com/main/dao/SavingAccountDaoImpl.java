package com.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.model.SavingAccount;
import com.main.repository.SavingAccountRepository;

@Repository
public class SavingAccountDaoImpl implements SavingAccountDao{
	
	@Autowired
	SavingAccountRepository savingAccountRepository;

	@Override
	public SavingAccount findByCustomerIdAndAccType(int id, String string) {
		SavingAccount sa=savingAccountRepository.findByCustomerIdAndAccType(id,string);
		return sa;
	}

	@Override
	public void save(SavingAccount account) {
		
		savingAccountRepository.save(account);
	}

}
