package com.assignment.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "countries")
public class Country {

	@Id
	@Column(name = "code", unique = true, nullable = false, length = 3)
	private String countryCode;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "currency", nullable = false, length = 15)
	private String currency;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = CascadeType.ALL)
	private Set<CoursePaymentDetail> coursePaymentDetails = new HashSet<CoursePaymentDetail>();

	public Country() {
	}

	public Country(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Set<CoursePaymentDetail> getCoursePaymentDetails() {
		return coursePaymentDetails;
	}

	public void setCoursePaymentDetails(Set<CoursePaymentDetail> coursePaymentDetails) {
		this.coursePaymentDetails = coursePaymentDetails;
	}

}
