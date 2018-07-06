package com.arsoft.projects.common.utility.datatime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ArCalendarUtilTest {
	
	@Test
	public void verifyGetCurrentWeekOfYear(){
		int week = ArCalendarUtil.getCurrentWeekOfYear();
		assertNotNull(week);
	}
	
	@Test
	public void verifyGetCurrentWeekOfYearAsString(){
		String week = ArCalendarUtil.getCurrentWeekOfYearAsString();
		assertNotNull(week);
		assertEquals(2,week.length());
	}
	@Test
	public void verifyGetCurrentMonthOfYear(){
		int month = ArCalendarUtil.getCurrentMonthOfYear();
		assertNotNull(month);
	}
	
	@Test
	public void verifyGetCurrentMonthOfYearAsString(){
		String month = ArCalendarUtil.getCurrentMonthOfYearAsString();
		assertNotNull(month);
		assertEquals(2,month.length());
	}
}
