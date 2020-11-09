package com.simiyu.projectTwo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="users")
public class User {
	private String first_name;
	private String last_name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	private String postal_address;
	@Id
	@Column(unique = true)
	private Integer national_id;
	private String gender;
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}	
	
	public String getPostal_address() {
		return postal_address;
	}
	public void setPostal_address(String postal_address) {
		this.postal_address = postal_address;
	}
	public Integer getNational_id() {
		return national_id;
	}
	public void setNational_id(Integer national_id) {
		this.national_id = national_id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	
	
	
	
	
}
