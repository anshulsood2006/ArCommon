package com.arsoft.projects.artutorial.learning.standalone.problems.africanearthquake;

import org.junit.Test;
import org.mockito.Mockito;

public class ProblemBaseTest {
	ProblemBase problemBase = Mockito.mock(ProblemBase.class);
	@Test
	public void testValidateInput() {
		boolean isValid = problemBase.validateInput(null);
		assert(!isValid);
	}
}
