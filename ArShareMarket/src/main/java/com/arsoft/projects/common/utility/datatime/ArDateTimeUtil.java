package com.arsoft.projects.common.utility.datatime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.arsoft.projects.common.business.entity.ArAmPmEnum;
import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.entity.ArMonthEnum;
import com.arsoft.projects.common.business.entity.ArTime;
import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.string.ArStringConstant;
import com.arsoft.projects.common.string.ArStringUtil;

public class ArDateTimeUtil {
	
	public static ArDateTime getCurrentArDateTime(){
		Date date = new Date();
		ArDate arDate = ArDateTimeUtil.getArDate(date);
		ArDateTime arDateTime = new ArDateTime();
		arDateTime.setArDate(arDate);
		ArTime arTime = ArDateTimeUtil.getArTime(date);
		arDateTime.setArTime(arTime);
		return arDateTime;
	}
	
	/**
	 * Get the given date as ArDateTime
	 * @param date
	 * @return the provided date as ArDateTime
	 */
	public static ArDateTime getArDateTime(Date date){
		ArDate arDate = ArDateTimeUtil.getArDate(date);
		ArDateTime arDateTime = new ArDateTime();
		arDateTime.setArDate(arDate);
		ArTime arTime = ArDateTimeUtil.getArTime(date);
		arDateTime.setArTime(arTime);
		return arDateTime;
	}
	
	/**
	 * Return the given ArDate in the format DD_MM_YYYY
	 * @param arDate
	 * @return the given ArDate in the format DD_MM_YYYY
	 */
	public static String getUnderScoredDate(ArDate arDate){
		return arDate.getDayAsString()+ArStringConstant.UNDERSCORE+arDate.getMonthAsString()+ArStringConstant.UNDERSCORE+arDate.getYear();
	}
	
	@SuppressWarnings("deprecation")
	public static ArDate getArDate(Date date){
		int day = date.getDate();
		int month = date.getMonth() + 1;
		ArMonthEnum arMonthEnum = ArMonthEnum.getArMonthEnum(String.valueOf(month));
		int year = date.getYear() + 1900;
		ArDate arDate = new ArDate(day, arMonthEnum, year);
		return arDate;
	}
	
	@SuppressWarnings("deprecation")
	public static ArTime getArTime(Date date){
		int hour = date.getHours();
		int minute = date.getMinutes();
		int seconds = date.getSeconds();
		ArTime arTime = new ArTime(hour,minute, seconds, hour < 12 ? ArAmPmEnum.AM : ArAmPmEnum.PM);
		return arTime;
	}
	
	/**
	 * Returns the given arTime in the format HH_MM_SS
	 * @param arTime
	 * @return the given arTime in the format HH_MM_SS
	 */
	public static String getUnderScoredTime(ArTime arTime) {
		return arTime.getHourAsString()+ArStringConstant.UNDERSCORE+arTime.getMinuteAsString()+ArStringConstant.UNDERSCORE+arTime.getSecondAsString();
	}
	
	/**
	 * Return the date object corresponding to the ArDate
	 * @param arDate
	 * @return
	 * @throws ParseException
	 */
	public static Date getDate(ArDate arDate){
		int day = arDate.getDay();
		String month = arDate.getMonth().getValue();
		int year = arDate.getYear();
		String string = day+"/"+month+"/"+year;
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		try{
			return format.parse(string);
		}catch(ParseException e){
			return null;
		}
		
	}

	public static ArDate getArDate(String underScoredDate) throws ArException {
		String[] underScoredDateSplitted = ArStringUtil.splitString(underScoredDate, ArStringConstant.UNDERSCORE);
        if (underScoredDateSplitted == null || underScoredDateSplitted.length != 3){
        	throw new ArException("ArDateTimeUtil: Invalid Date Format in underScoredDate string");
        }
        int day = Integer.parseInt(underScoredDateSplitted[0]);
        String monthString = underScoredDateSplitted[1];
        if(monthString.startsWith("0")) {
        	monthString = monthString.substring(1);
        }
        ArMonthEnum month = ArMonthEnum.getArMonthEnum(monthString);
		int year = Integer.parseInt(underScoredDateSplitted[2]);
		ArDate arDate = ArDate.getArDate(day, month, year);
		return arDate;
	}
	
	public static ArTime getArTime(String underScoredTime) throws ArException {
		String[] underScoredTimeSplitted = ArStringUtil.splitString(underScoredTime, ArStringConstant.UNDERSCORE);
        if (underScoredTimeSplitted == null || underScoredTimeSplitted.length != 3){
        	throw new ArException("ArDateTimeUtil: Invalid Time Format in underScoredDate string");
        }
        int hour = Integer.parseInt(underScoredTimeSplitted[0]);
		int minute = Integer.parseInt(underScoredTimeSplitted[1]);
		int second = Integer.parseInt(underScoredTimeSplitted[2]);
		ArAmPmEnum amPm = hour < 12 ? ArAmPmEnum.AM: ArAmPmEnum.PM;
		ArTime arTime = ArTime.getArTime(hour, minute, second, amPm);
		return arTime;
	}
}
