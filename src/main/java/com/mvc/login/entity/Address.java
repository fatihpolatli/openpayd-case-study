package com.mvc.login.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstAddressLine;

	private String SecondAddressLine;

	private String city;

	private String country;

	
	/** 
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	
	/** 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	
	/** 
	 * @return String
	 */
	public String getFirstAddressLine() {
		return firstAddressLine;
	}

	
	/** 
	 * @param firstAddressLine
	 */
	public void setFirstAddressLine(String firstAddressLine) {
		this.firstAddressLine = firstAddressLine;
	}

	
	/** 
	 * @return String
	 */
	public String getSecondAddressLine() {
		return SecondAddressLine;
	}

	
	/** 
	 * @param secondAddressLine
	 */
	public void setSecondAddressLine(String secondAddressLine) {
		SecondAddressLine = secondAddressLine;
	}

	
	/** 
	 * @return String
	 */
	public String getCity() {
		return city;
	}

	
	/** 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	
	/** 
	 * @return String
	 */
	public String getCountry() {
		return country;
	}

	
	/** 
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

}