package com.assignment.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.api.model.CoursePaymentDetail;

@Repository
public interface CoursePaymentDetailRepository extends JpaRepository<CoursePaymentDetail, Long> {

	/**
	   * This method is used to get course prices specific to country
	   * 
	   * @param courseId This is the id of course
	   * @param countryCode  This is the code of country
	   * 
	   * @return List<CoursePaymentDetail> This returns list of prices including pricing component
	   */
	public List<CoursePaymentDetail> findByCourse_IdAndCountry_CountryCode(Long courseId,String countryCode);
}
