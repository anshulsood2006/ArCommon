package com.arsoft.projects.arshared;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arsoft.projects.arshared.dataloader.ExcelDataLoader;
import com.arsoft.projects.arshared.dataloader.ExcelDataReader;

@Configuration
public class ArSharedConfiguration {
	@Bean
	public ExcelDataLoader getExcelDataLoader() {
		return new ExcelDataLoader();
	}

	@Bean
	public ExcelDataReader getExcelDataReader() {
		return new ExcelDataReader();
	}

}
