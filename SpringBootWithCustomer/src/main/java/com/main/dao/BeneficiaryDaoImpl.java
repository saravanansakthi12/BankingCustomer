package com.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.model.Beneficiary;
import com.main.model.CustomerRegistration;
import com.main.repository.BeneficiaryRepository;

@Repository
public class BeneficiaryDaoImpl implements BeneficiaryDao{

	@Autowired
	BeneficiaryRepository beneficiaryRepository;
	
	@Override
	public Beneficiary saveBeneficiery(Beneficiary beneficiary) {
	return beneficiaryRepository.save(beneficiary);
	}

	@Override
	public List<Beneficiary> findByCustomerId(int id) {
		return beneficiaryRepository.findByCustomerId(id);
	}

	@Override
	public void saveFund(long result, int id) {
		 beneficiaryRepository.saveFund(result,id);
	}

	/*@Override
	public void deleteCustomer(CustomerRegistration customer) {
		
	}*/

}
