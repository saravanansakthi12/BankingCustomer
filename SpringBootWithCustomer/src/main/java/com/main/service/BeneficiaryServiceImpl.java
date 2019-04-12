package com.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.BeneficiaryDao;
import com.main.model.Beneficiary;
import com.main.model.CustomerRegistration;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService{

	@Autowired
	BeneficiaryDao beneficiaryDao;
	
	@Transactional
	public Beneficiary saveBeneficiery(Beneficiary beneficiary) {
	return beneficiaryDao.saveBeneficiery(beneficiary);
	}

	@Transactional
	public List<Beneficiary> findByCustomerId(int id) {
		return beneficiaryDao.findByCustomerId(id);
	}

	@Transactional
	public void saveFund(long result, int id) {
		beneficiaryDao.saveFund(result, id);;
		
	}

	/*@Transactional
	public void deleteCustomer(CustomerRegistration customer) {
		beneficiaryDao.deleteCustomer(customer);
	}*/

}
