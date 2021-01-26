package com.test.unit.matchers;

import java.util.Calendar;

public class OwnMatchers {

	public static DayWeekMatcher isDay(Integer dayWeek) {
		return new DayWeekMatcher(dayWeek);
	}
	
	public static DayWeekMatcher isMonday() {
		return new DayWeekMatcher(Calendar.MONDAY);
	}
	
	public static DiferenceDaysMatchers getDateWithDifferenceOfTheDays(Integer days) {
		return new DiferenceDaysMatchers(days);
	}
	
	public static DiferenceDaysMatchers today() {
		return new DiferenceDaysMatchers(0);
	}
}
