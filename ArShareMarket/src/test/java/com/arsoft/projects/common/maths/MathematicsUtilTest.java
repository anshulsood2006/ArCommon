package com.arsoft.projects.common.maths;

import org.junit.Test;

import com.arsoft.projects.common.exception.ArException;

public class MathematicsUtilTest {
	
	@Test
	public void getBinary() throws ArException{
		MathematicsUtil.getBinary("100");
	}
}
