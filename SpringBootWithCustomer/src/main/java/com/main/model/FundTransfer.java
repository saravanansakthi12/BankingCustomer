package com.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="fundtransfer")
@Component
public class FundTransfer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int fundId;
    private long accId;
    private String benName;
    private String transferDescription;
    private long amount;
    
    @ManyToOne
    CustomerRegistration customer;

	public FundTransfer() {
		super();
	}

	public FundTransfer(int fundId, long accId, String benName, String transferDescription, long amount,
			CustomerRegistration customer) {
		super();
		this.fundId = fundId;
		this.accId = accId;
		this.benName = benName;
		this.transferDescription = transferDescription;
		this.amount = amount;
		this.customer = customer;
	}

	public int getFundId() {
		return fundId;
	}

	public void setFundId(int fundId) {
		this.fundId = fundId;
	}

	public long getAccId() {
		return accId;
	}

	public void setAccId(long accId) {
		this.accId = accId;
	}

	public String getBenName() {
		return benName;
	}

	public void setBenName(String benName) {
		this.benName = benName;
	}

	public String getTransferDescription() {
		return transferDescription;
	}

	public void setTransferDescription(String transferDescription) {
		this.transferDescription = transferDescription;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public CustomerRegistration getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerRegistration customer) {
		this.customer = customer;
	}
}
