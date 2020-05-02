package com.assignment.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.api.model.CoursePaymentDetail;
import com.assignment.api.repository.CoursePaymentDetailRepository;
import com.assignment.api.service.CoursePaymentDetailService;

@Service("coursePaymentDetailService")
public class CoursePaymentDetailServiceImpl implements CoursePaymentDetailService {

	@Autowired
	private CoursePaymentDetailRepository coursePaymentDetailRepository;

	/**
	   * This method is used to get course prices specific to country
	   * 
	   * @param courseId This is the id of course
	   * @param countryCode  This is the code of country
	   * 
	   * @return List<CoursePaymentDetail> This returns list of prices including pricing component
	   */
	@Override
	public List<CoursePaymentDetail> getCoursePriceByCourseIdByCountryCode(Long courseId, String countryCode) {
		return coursePaymentDetailRepository.findByCourse_IdAndCountry_CountryCode(courseId,countryCode); 
	}
}
