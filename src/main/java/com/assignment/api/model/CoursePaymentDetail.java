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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
//Here assumption is that a course can map in country only once with single strategy
@Table(name = "course_payment_detail", uniqueConstraints = @UniqueConstraint(columnNames = { "country_id",
		"course_id" }))
@JsonInclude(Include.NON_NULL)
public class CoursePaymentDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "course_id")
	private Course course;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_id")
	private Country country;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "payment_strategy_id")
	private PaymentStrategy paymentStrategy;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "coursePaymentDetail",cascade = CascadeType.ALL)
	private Set<CourseDetailPriceComponent> courseDetailPriceComponents = new HashSet<CourseDetailPriceComponent>();

	@Transient
	private Double amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public PaymentStrategy getPaymentStrategy() {
		return paymentStrategy;
	}

	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	public Set<CourseDetailPriceComponent> getCourseDetailPriceComponents() {
		return courseDetailPriceComponents;
	}

	public void setCourseDetailPriceComponents(Set<CourseDetailPriceComponent> courseDetailPriceComponents) {
		this.courseDetailPriceComponents = courseDetailPriceComponents;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
