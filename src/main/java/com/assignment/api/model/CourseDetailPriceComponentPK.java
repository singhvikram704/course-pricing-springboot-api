package com.assignment.api.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CourseDetailPriceComponentPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long coursePaymentDetail;
	private Long priceComponent;
	public Long getCoursePaymentDetail() {
		return coursePaymentDetail;
	}
	public void setCoursePaymentDetail(Long coursePaymentDetail) {
		this.coursePaymentDetail = coursePaymentDetail;
	}
	public Long getPriceComponent() {
		return priceComponent;
	}
	public void setPriceComponent(Long priceComponent) {
		this.priceComponent = priceComponent;
	}

	
	
	
}
