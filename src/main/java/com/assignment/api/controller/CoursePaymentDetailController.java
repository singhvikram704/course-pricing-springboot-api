package com.assignment.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.api.model.CoursePaymentDetail;
import com.assignment.api.model.ResponseObject;
import com.assignment.api.service.CoursePaymentDetailService;
import com.assignment.api.utility.PriceUtility;

@RestController
@CrossOrigin// this is used just to show case api at html page.
public class CoursePaymentDetailController {
	
	@Autowired
	CoursePaymentDetailService coursePaymentDetailService;
	
	@Autowired
	PriceUtility priceUtility;
	
	/**
	 * This method is used to get calculate the the pricing component and payable
	 *         amount for course and country
	 * 
	 * @param courseId This is course id comes comes in path
	 * @param countryCode This is country code comes in path
	 * 
	 * @return ResponseObject<CoursePaymentDetail> This returns the pricing component and payable
	 *         amount for course and country and message related to api status
	 */
	@GetMapping(value= "/course/price/{courseId}/{countryCode}")
	public ResponseObject<CoursePaymentDetail> getCoursePrice(@PathVariable Long courseId,@PathVariable String countryCode) {
		ResponseObject<CoursePaymentDetail> responseObject=new ResponseObject<>();
		List<CoursePaymentDetail> coursePaymentDetails=coursePaymentDetailService.getCoursePriceByCourseIdByCountryCode(courseId, countryCode);
		if(!coursePaymentDetails.isEmpty()) {
			responseObject.setEntity(priceUtility.calculateTotalCoursePrice(coursePaymentDetails.get(0)));
			responseObject.setMessage("success");
		}else {
			responseObject.setMessage("Data not found");
		}
		return responseObject;
	}

}
