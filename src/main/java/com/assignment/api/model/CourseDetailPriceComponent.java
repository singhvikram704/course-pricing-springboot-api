package com.assignment.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "course_detail_price_component")
@IdClass(CourseDetailPriceComponentPK.class)
@JsonInclude(Include.NON_NULL)
public class CourseDetailPriceComponent {

	@ManyToOne(fetch = FetchType.EAGER)
	@Id
	@JoinColumn(name = "price_component_id", referencedColumnName = "id")
	private PriceComponent priceComponent;

	@ManyToOne(fetch = FetchType.LAZY)
	@Id
	@JoinColumn(name = "course_payment_detail_id", referencedColumnName = "id")
	@JsonIgnore
	private CoursePaymentDetail coursePaymentDetail;

	@Column(name = "value")
	private double value;

	@Column(name = "is_percentage")
	private boolean isPercentage;

	public PriceComponent getPriceComponent() {
		return priceComponent;
	}

	public void setPriceComponent(PriceComponent priceComponent) {
		this.priceComponent = priceComponent;
	}

	public CoursePaymentDetail getCoursePaymentDetail() {
		return coursePaymentDetail;
	}

	public void setCoursePaymentDetail(CoursePaymentDetail coursePaymentDetail) {
		this.coursePaymentDetail = coursePaymentDetail;
	}
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public boolean isPercentage() {
		return isPercentage;
	}

	public void setPercentage(boolean isPercentage) {
		this.isPercentage = isPercentage;
	}

}
