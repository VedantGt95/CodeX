package com.vedant.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contactmodel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Customer_id")
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String message;
	
	private String phoneno;

	public Contactmodel() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	@Override
	public String toString() {
		return "Contactmodel [id=" + id + ", name=" + name + ", email=" + email + ", message=" + message + ", phoneno="
				+ phoneno + "]";
	}
	
	
	
}
