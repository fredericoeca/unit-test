package com.test.unit.matchers;

import java.util.Date;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.test.unit.util.DateUtils;

public class DiferenceDaysMatchers extends TypeSafeMatcher<Date> {
	
	private Integer quantityDays;
	
	public DiferenceDaysMatchers(Integer quantityDays) {
		this.quantityDays = quantityDays;
	}

	@Override
	public void describeTo(Description description) {
		// TODO Auto-generated method stub
	}

	@Override
	protected boolean matchesSafely(Date date) {
		return DateUtils.isDateEquals(date, DateUtils.getDateWithDifferenceOfTheDays(quantityDays));
	}

}
