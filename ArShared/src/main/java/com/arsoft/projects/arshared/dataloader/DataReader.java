package com.arsoft.projects.arshared.dataloader;

import org.springframework.stereotype.Component;

import com.arsoft.projects.arshared.exception.ArException;

@Component
public interface DataReader {

	public void setFilePath(String path);

	public String getFilePath();

	public void setFileName(String fileName);

	public String getFileName();

	public String getSheetName();
	
	public void setSheetName(String sheetName);

	public void readSheet(String sheetName) throws ArException;
}
