package com.arsoft.projects.common.utility.datatime;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

import com.arsoft.projects.common.business.entity.ArDateTime;

public class ArDateTimeUtilTest {
	
	@Test
	public void verifyGetArDateTime() throws ParseException{
		String string = "05/07/2018 12:08:56";
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
		Date date = format.parse(string);
		ArDateTime arDateTime = ArDateTimeUtil.getArDateTime(date);
		assertNotNull(arDateTime);
		assertNotNull(arDateTime.getDate());
		assertNotNull(arDateTime.getTime());
		assertEquals(4, date.getDay());
		assertEquals(6, date.getMonth());
		assertEquals(118, date.getYear());
		assertEquals(12, date.getHours());
		assertEquals(8, date.getMinutes());
		assertEquals(56, date.getSeconds());
	}
	
	@Test
	public void verifyGetUnderScoredDate() throws ParseException{
		String string = "05/07/2018 12:08:56";
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
		Date date = format.parse(string);
		ArDateTime arDateTime = ArDateTimeUtil.getArDateTime(date);
		assertNotNull(arDateTime);
		String underscoredDate = ArDateTimeUtil.getUnderScoredDate(arDateTime.getDate());
		assertEquals("05_07_2018",underscoredDate);
	}
	
	@Test
	public void verifyGetUnderScoredTime() throws ParseException{
		String string = "05/07/2018 02:08:56";
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH);
		Date date = format.parse(string);
		ArDateTime arDateTime = ArDateTimeUtil.getArDateTime(date);
		assertNotNull(arDateTime);
		String underscoredTime = ArDateTimeUtil.getUnderScoredTime(arDateTime.getTime());
		assertEquals("02_08_56",underscoredTime);
	}
	
}
