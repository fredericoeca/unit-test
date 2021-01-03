package com.test.unit.util.copy;

import static java.util.Calendar.*;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	/***
	 * Returns the date sent by parameter with the addition of desired days
	 * the date may be in the future (day > 0) or in the past (day < 0)
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date add(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(DAY_OF_MONTH, days);
		return calendar.getTime();
	}
	
	/**
	 * Returns the current date with the difference of the days sent by parameter the date
	 * 	can in the future (positive parameter) or in the past (negative parameter)
	 * 
	 * @param days Number of the days to be increased / decreased
	 * @return Date update
	 */
	public static Date getDateWithDifferenceOfTheDays(int days) {
		return add(new Date(), days);
	}
	
	/**
	 * Returns a instance of the <code>Date</code> reflecting the values passed by parameters
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	public static Date getDate(int day, int month, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(DAY_OF_MONTH, day);
		calendar.set(MONTH, month - 1);
		calendar.set(YEAR, year);
		return calendar.getTime();
	}
	
	/**
	 * Checks if a date is the same as another
	 * The comparison considers only day, month and year
	 * 
	 * @param initial
	 * @param end
	 * @return
	 */
	public static boolean isDateEquals(Date initial, Date end) {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(initial);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(end);
		return (calendar1.get(DAY_OF_MONTH) == calendar2.get(DAY_OF_MONTH))
				&& (calendar1.get(MONTH) == calendar2.get(MONTH))
				&& (calendar1.get(YEAR) == calendar2.get(YEAR));
	}
	
	/**
	 * Checks whether a given date is the desired week date
	 * 
	 * @param date Date to be evaluated
	 * @param dayOfWeek <code>true</code> if it is the desired day of the week <code>false</code> otherwise
	 * @return
	 */
	public static boolean checkDayOfTheWeek(Date date, int dayOfWeek) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(DAY_OF_WEEK) == dayOfWeek;
	}
}
