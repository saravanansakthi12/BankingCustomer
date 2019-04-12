package com.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.main.model.Beneficiary;

public interface BeneficiaryRepository extends CrudRepository<Beneficiary, Integer>{

	List<Beneficiary> findByCustomerId(int id);

	@Modifying
	@Query("update SavingAccount set account_balance = ?1 where customer_id = ?2")
	void saveFund(long result, int id);

}
