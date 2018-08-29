package com.arsoft.projects.common.file;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.arsoft.projects.common.exception.ArException;

public class ArFileUtilTest {
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void testGetNullFileContentAsString() throws Exception{
		expectedEx.expect(ArException.class);
		expectedEx.expectMessage("File location can not be null or empty");
		String str = null;
		ArFileUtil.getFileContentAsString(str);
	}
	
	@Test
	public void testGetNotExistingFileContentAsString() throws Exception{
		String filePath = "anshul";
		expectedEx.expect(ArException.class);
		expectedEx.expectMessage("Incorrect file location "+filePath);
		ArFileUtil.getFileContentAsString(filePath);
	}
}
