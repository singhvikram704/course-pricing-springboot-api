package com.assignment.api.service;

import java.util.List;

import com.assignment.api.model.CoursePaymentDetail;

public interface CoursePaymentDetailService {

	/**
	   * This method is used to get course prices specific to country
	   * 
	   * @param courseId This is the id of course
	   * @param countryCode  This is the code of country
	   * 
	   * @return List<CoursePaymentDetail> This returns list of prices including pricing component
	   */
	public List<CoursePaymentDetail> getCoursePriceByCourseIdByCountryCode(Long courseId,String countryCode);
}
