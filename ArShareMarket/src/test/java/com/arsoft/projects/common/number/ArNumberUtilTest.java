package com.arsoft.projects.common.number;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArNumberUtilTest {
	@Test
	public void verifyDoubles(){
		String stringToCheck = "";
		boolean isDouble = ArNumberUtil.isDouble(stringToCheck);
		assertTrue(!isDouble);
		stringToCheck = "25.6";
		isDouble = ArNumberUtil.isDouble(stringToCheck);
		assertTrue(isDouble);
		stringToCheck = null;
		isDouble = ArNumberUtil.isDouble(stringToCheck);
		assertTrue(!isDouble);
		stringToCheck = "0.2";
		isDouble = ArNumberUtil.isDouble(stringToCheck);
		assertTrue(isDouble);
	}
}
