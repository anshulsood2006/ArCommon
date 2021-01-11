package com.arsoft.projects.arshared.dataloader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.arsoft.projects.arshared.ArSharedConfiguration;
import com.arsoft.projects.arshared.exception.ArException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ArSharedConfiguration.class)
public class ExcelDataLoaderTest {

	@Autowired
	private ExcelDataLoader excelDataLoader;

	@Test
	public void testInvalidSheetName() {
		try {
			excelDataLoader.init("D:", "Dictionary.xlsx", "words");
			excelDataLoader.load();
			assertTrue(true);
		} catch (ArException e) {
			assertEquals(e.getMessage(), "Not able to find sheet words inside D:\\Dictionary.xlsx");
			fail(e.getMessage());
		}

	}

	@Test
	public void testValidSheetName() {
		try {
			excelDataLoader.init("D:", "Dictionary.xlsx", "Hindi");
			excelDataLoader.load();
			assertTrue(true);
		} catch (ArException e) {
			fail(e.getMessage());
		}

	}

}
