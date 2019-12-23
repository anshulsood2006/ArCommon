package com.arsoft.projects.artutorial.learning.standalone.problems.africanearthquake;

import org.junit.Test;
import org.mockito.Mockito;

public class ProblemBaseTest {
	ProblemBase problemBase = Mockito.mock(ProblemBase.class);
	@Test
	public void testValidateInput() {
		problemBase = new ProblemBase();
		boolean isValid = problemBase.validateInput(null);
		assert(!isValid);
		isValid = problemBase.validateInput("");
		assert(!isValid);
		isValid = problemBase.validateInput("asasn");
		assert(!isValid);
		isValid = problemBase.validateInput("1 s 1");
		assert(!isValid);
		isValid = problemBase.validateInput("a 1 2");
		assert(!isValid);
		isValid = problemBase.validateInput("1 1 asa");
		assert(!isValid);
		isValid = problemBase.validateInput("-1 1 1");
		assert(!isValid);
		isValid = problemBase.validateInput("0 1 1");
		assert(!isValid);
		isValid = problemBase.validateInput("1 -1 1");
		assert(!isValid);
		isValid = problemBase.validateInput("1 0 1");
		assert(!isValid);
		isValid = problemBase.validateInput("1 1 -1");
		assert(!isValid);
		isValid = problemBase.validateInput("1 1 0");
		assert(!isValid);
		isValid = problemBase.validateInput("1 1 2");
		assert(!isValid);
		isValid = problemBase.validateInput("6 9 3");
		assert(isValid);
	}
}
