package com.main.dao;

import java.util.List;

import com.main.model.Beneficiary;
import com.main.model.CustomerRegistration;

public interface BeneficiaryDao {

	Beneficiary saveBeneficiery(Beneficiary beneficiary);

	List<Beneficiary> findByCustomerId(int id);

	void saveFund(long result, int id);

	//void deleteCustomer(CustomerRegistration customer);

}
