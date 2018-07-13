package com.arsoft.projects.common.utility.datatime;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import com.arsoft.projects.common.business.entity.ArDate;

public class ArCalendarUtil {
	
	
	public static int getCurrentWeekOfYear(ArDate arDate){
		Calendar calendar = Calendar.getInstance();
		Date date = ArDateTimeUtil.getDate(arDate);
		calendar.setTime(date);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * Returns the week of the year
	 * @return the week of the year
	 */
	public static int getCurrentWeekOfYear(){
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}
	
	/**
	 * Returns the week of the year as a String
	 * @return the week of the year as a String. If less that 10, 0 is appended at the beginning e.g. 02, 07, 06 etc.
	 */
	public static String getCurrentWeekOfYearAsString(){
		Calendar calendar = Calendar.getInstance();
		int week = calendar.get(Calendar.WEEK_OF_YEAR);
		return week < 10 ? "0"+week : String.valueOf(week);
	}
	
	/**
	 * Returns the month of the year
	 * @return the month of the year
	 */
	public static int getCurrentMonthOfYear(){
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH);
	}
	
	/**
	 * Returns the month of the year as a String
	 * @return the month of the year as a String. If less that 10, 0 is appended at the beginning e.g. 02, 07, 06 etc.
	 */
	public static String getCurrentMonthOfYearAsString(){
		Calendar calendar = Calendar.getInstance();
		int week = calendar.get(Calendar.MONTH);
		return week < 10 ? "0"+week : String.valueOf(week);
	}
}
