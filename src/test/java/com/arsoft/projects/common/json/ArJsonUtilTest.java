package com.arsoft.projects.common.json;

import static org.junit.Assert.*;

import org.junit.Test;

import com.arsoft.projects.common.exception.ArException;

public class ArJsonUtilTest {
	
	@Test
	public void isValidJasonArray() throws ArException{
		assertEquals(false, ArJsonUtil.isValidJasonArray(null));
		assertEquals(false, ArJsonUtil.isValidJasonArray(""));
		assertEquals(false, ArJsonUtil.isValidJasonArray("abcd"));
		assertEquals(false, ArJsonUtil.isValidJasonArray("[abcd]"));
		assertEquals(true, ArJsonUtil.isValidJasonArray("[{}]"));
		assertEquals(true, ArJsonUtil.isValidJasonArray("[{\"a\":\"a\"}]"));
		assertEquals(false, ArJsonUtil.isValidJasonArray("[{\"a\"\"a\"}]"));
		assertEquals(true, ArJsonUtil.isValidJasonArray(" [{\"a\":\"a\"}] "));
		assertEquals(true, ArJsonUtil.isValidJasonArray("//[{\"a\":\"a\"}] "));
	}
	
	
}
