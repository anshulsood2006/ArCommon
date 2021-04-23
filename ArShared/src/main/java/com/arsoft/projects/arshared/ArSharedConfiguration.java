package com.arsoft.projects.arshared;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arsoft.projects.arshared.dataloader.ExcelDataLoader;
import com.arsoft.projects.arshared.dataloader.ExcelDataReader;
import com.arsoft.projects.arshared.exception.ArException;

@Configuration
public class ArSharedConfiguration {
	@Bean
	public ExcelDataLoader getExcelDataLoader() {
		return new ExcelDataLoader();
	}

	@Bean
	public ExcelDataReader getExcelDataReader(String filePath, String fileName) throws ArException {
		return new ExcelDataReader(filePath, fileName);
	}

}
