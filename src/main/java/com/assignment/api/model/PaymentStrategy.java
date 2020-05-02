package com.assignment.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "paymentStrategy")
@JsonInclude(Include.NON_NULL)
public class PaymentStrategy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "strategy", nullable = false, length = 30)
	private String strategy;

	@Column(name = "months")
	private Integer months;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentStrategy",cascade = CascadeType.ALL)
	private Set<CoursePaymentDetail> coursePaymentDetails = new HashSet<CoursePaymentDetail>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public Set<CoursePaymentDetail> getCoursePaymentDetails() {
		return coursePaymentDetails;
	}

	public void setCoursePaymentDetails(Set<CoursePaymentDetail> coursePaymentDetails) {
		this.coursePaymentDetails = coursePaymentDetails;
	}

}
