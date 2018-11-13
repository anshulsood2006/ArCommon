package com.arsoft.projects.common.maths;

import org.junit.Test;

import com.arsoft.projects.arshared.exception.ArException;

public class MathematicsUtilTest {
	
	@Test
	public void getBinary() throws ArException{
		MathematicsUtil.getBinary("100");
	}
}
