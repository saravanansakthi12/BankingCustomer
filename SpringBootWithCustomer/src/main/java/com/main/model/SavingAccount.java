package com.main.model;



import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Account")
public class SavingAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ACCOUNT_NUMBER")
    private long accId;
    @Column(name="ACCOUNT_TYPE")
    private String accType;
    @Column(name="ACCOUNT_BALANCE")
    private long accBalance;
    @Column(name="TERM_TENURE")
    private int tenure;
    @Column(name="TERM_INTEREST")
    private float interest;
    @Column(name="TERM_MATURE")
    private Date matureDate;
    @Column(name="ACCOUNT_CREATED_DATE")
    private Date createdDate;
    @Column(name="ACCOUNT_UPDATED_DATE")
    private Date updatedDate;
    @Column(name="TERM_AMOUNT")
    private long termAmt;
    
    @OneToOne
    private CustomerRegistration customer;

	public SavingAccount() {
		super();
	}

	public SavingAccount(long accId, String accType, long accBalance, int tenure, float interest,
			Date matureDate, Date createdDate, Date updatedDate, long termAmt, CustomerRegistration customer) {
		super();
		
		this.accId = accId;
		this.accType = accType;
		this.accBalance = accBalance;
		this.tenure = tenure;
		this.interest = interest;
		this.matureDate = matureDate;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.termAmt = termAmt;
		this.customer = customer;
	}

	public long getAccId() {
		return accId;
	}

	public void setAccId(long accId) {
		this.accId = accId;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public long getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(long accBalance) {
		this.accBalance = accBalance;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	public Date getMatureDate() {
		return matureDate;
	}

	public void setMatureDate(Date matureDate) {
		this.matureDate = matureDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public long getTermAmt() {
		return termAmt;
	}

	public void setTermAmt(long termAmt) {
		this.termAmt = termAmt;
	}

	public CustomerRegistration getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerRegistration customer) {
		this.customer = customer;
	}
}
