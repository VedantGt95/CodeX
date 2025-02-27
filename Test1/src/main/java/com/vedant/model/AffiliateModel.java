package com.vedant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Affiliate_table")
public class AffiliateModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String firstname;
	
	private String lastname;
	
	private String age;
	
	private String profile;
	
	private String phone;
	
	private String email;
	
	private String nationality;
	
	private String referralcode;
	
	public AffiliateModel() {
		
	}
	
	

	public String getReferralcode() {
		return referralcode;
	}



	public void setReferralcode(String referralcode) {
		this.referralcode = referralcode;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getProfile() {
		return profile;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	

	@Override
	public String toString() {
		return "AffiliateModel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age
				+ ", profile=" + profile + ", phone=" + phone + ", email=" + email + ", nationality=" + nationality
				+ "]";
	}

	
	
	

}
