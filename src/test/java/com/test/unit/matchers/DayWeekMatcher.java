package com.test.unit.matchers;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.test.unit.util.DateUtils;

public class DayWeekMatcher extends TypeSafeMatcher<Date>{
	
	private Integer dayWeek;

	public DayWeekMatcher(Integer dayWeek) {
		this.dayWeek = dayWeek;
	}
	
	@Override
	public void describeTo(Description description) {
		Calendar date = Calendar.getInstance();
		date.set(Calendar.DAY_OF_WEEK, dayWeek);
		String dateString = date.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("pt","BR"));
		description.appendText(dateString);
	}

	@Override
	protected boolean matchesSafely(Date date) {
		return DateUtils.checkDayOfTheWeek(date, dayWeek);
	}
	
}
