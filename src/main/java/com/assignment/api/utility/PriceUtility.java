package com.assignment.api.utility;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.assignment.api.constants.ApiConstants;
import com.assignment.api.model.CourseDetailPriceComponent;
import com.assignment.api.model.CoursePaymentDetail;

@Component
public class PriceUtility {

	/**
	 * This method is used to get calculate the total payable amount
	 * 
	 * @param CoursePaymentDetail This object contains the pricing components for
	 *                            course and country
	 * 
	 * @return CoursePaymentDetail This returns the pricing component and payable
	 *         amount for course and country
	 */
	public CoursePaymentDetail calculateTotalCoursePrice(CoursePaymentDetail coursePaymentDetail) {
		if (coursePaymentDetail != null) {
			Optional<CourseDetailPriceComponent> basePriceComponent = coursePaymentDetail
					.getCourseDetailPriceComponents().stream()
					.filter(cdpc -> ApiConstants.PRICE_KEY.equalsIgnoreCase(cdpc.getPriceComponent().getName()))
					.findFirst();
			if (basePriceComponent.isPresent()) {
				Double totalAmount = basePriceComponent.get().getValue();
				Double calculatedAmount = totalAmount;
				for (CourseDetailPriceComponent cdpc : coursePaymentDetail.getCourseDetailPriceComponents()) {
					if (ApiConstants.PRICE_KEY.equalsIgnoreCase(cdpc.getPriceComponent().getName())) {
						continue;
					}
					if (cdpc.getPriceComponent().isDiscount()) {
						if (cdpc.isPercentage()) {
							Double percentageAmount = cdpc.getValue() * totalAmount / 100;
							calculatedAmount = calculatedAmount - percentageAmount;
						} else {
							calculatedAmount = calculatedAmount - cdpc.getValue();
						}
					}
				}
				totalAmount = calculatedAmount;
				for (CourseDetailPriceComponent cdpc : coursePaymentDetail.getCourseDetailPriceComponents()) {
					if (ApiConstants.PRICE_KEY.equalsIgnoreCase(cdpc.getPriceComponent().getName())) {
						continue;
					}
					if (!cdpc.getPriceComponent().isDiscount()) {
						if (cdpc.isPercentage()) {
							Double percentageAmount = cdpc.getValue() * totalAmount / 100;
							calculatedAmount = calculatedAmount + percentageAmount;
						} else {
							calculatedAmount = calculatedAmount + cdpc.getValue();
						}
					}
				}
				coursePaymentDetail.setAmount(calculatedAmount);
			}
		}
		return coursePaymentDetail;
	}
}
