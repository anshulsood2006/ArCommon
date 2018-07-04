package com.arsoft.projects.common.utility.datatime;

import java.util.Date;

import com.arsoft.projects.common.business.entity.ArAmPmEnum;
import com.arsoft.projects.common.business.entity.ArDate;
import com.arsoft.projects.common.business.entity.ArDateTime;
import com.arsoft.projects.common.business.entity.ArMonthEnum;
import com.arsoft.projects.common.business.entity.ArTime;

public class ArDateTimeUtil {
	public static ArDateTime getCurrentArDateTime(){
		Date date = new Date();
		ArDate arDate = ArDateTimeUtil.getArDate(date);
		ArDateTime arDateTime = new ArDateTime();
		arDateTime.setDate(arDate);
		ArTime arTime = ArDateTimeUtil.getArTime(date);
		arDateTime.setTime(arTime);
		return arDateTime;
	}
	
	public static void main(String[] args) {
		ArDateTime z = ArDateTimeUtil.getCurrentArDateTime();
		System.out.println(z);
	}
	
	@SuppressWarnings("deprecation")
	public static ArDate getArDate(Date date){
		int day = date.getDay() + 1;
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
}
