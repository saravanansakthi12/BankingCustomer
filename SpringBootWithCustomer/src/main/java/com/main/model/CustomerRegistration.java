package com.main.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private long pincode;
	private long mobileNumber;
	private String email;

	private long aadhar;
	private String pan;
	private String userName;
	private String password;

	private String dobProof;
	private String addressProof;
	private String aadharProof;
	private String panProof;
	
	
	public CustomerRegistration() {
		super();
	}
	
	public CustomerRegistration(int id, String firstName, String lastName, Date dateOfBirth, String addressLine1,
			String addressLine2, String city, String state, long pincode, long mobileNumber, String email, long aadhar,
			String pan, String userName, String password, String dobProof, String addressProof, String aadharProof,
			String panProof) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.aadhar = aadhar;
		this.pan = pan;
		this.userName = userName;
		this.password = password;
		this.dobProof = dobProof;
		this.addressProof = addressProof;
		this.aadharProof = aadharProof;
		this.panProof = panProof;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getAadhar() {
		return aadhar;
	}

	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDobProof() {
		return dobProof;
	}

	public void setDobProof(String dobProof) {
		this.dobProof = dobProof;
	}

	public String getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}

	public String getAadharProof() {
		return aadharProof;
	}

	public void setAadharProof(String aadharProof) {
		this.aadharProof = aadharProof;
	}

	public String getPanProof() {
		return panProof;
	}

	public void setPanProof(String panProof) {
		this.panProof = panProof;
	}
}
