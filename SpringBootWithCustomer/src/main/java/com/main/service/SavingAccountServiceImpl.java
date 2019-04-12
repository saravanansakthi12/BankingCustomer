package com.main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.SavingAccountDao;
import com.main.model.SavingAccount;

@Service
public class SavingAccountServiceImpl implements SavingAccountService{

	@Autowired
	SavingAccountDao savingAccountDao;
	
	@Transactional
	public SavingAccount findByCustomerIdAndAccType(int id, String string) {
		
		return savingAccountDao.findByCustomerIdAndAccType(id,string);
	}

	@Transactional
	public void save(SavingAccount account) {
		savingAccountDao.save(account);
		
	}

}
