package com.main.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name="beneficiary")
@Component
public class Beneficiary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String ifsc;
	private long accNumber;
	private String remarks;
	private String eMail;
	@ManyToOne
	private CustomerRegistration customer;
	
	public Beneficiary() {
		super();
	}

	public Beneficiary(int id, String name, String ifsc, long accNumber, String remarks, String eMail,
			CustomerRegistration customer) {
		super();
		this.id = id;
		this.name = name;
		this.ifsc = ifsc;
		this.accNumber = accNumber;
		this.remarks = remarks;
		this.eMail = eMail;
		this.customer = customer;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public long getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public CustomerRegistration getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerRegistration customer) {
		this.customer = customer;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
}
