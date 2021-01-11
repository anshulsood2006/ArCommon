package com.arsoft.projects.arshared.dataloader;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.arsoft.projects.arshared.exception.ArException;

@Component
@ComponentScan
public interface DataLoader {

	/*
	 * Return the name of database where data needs to be stored
	 */
	public String getDatabaseName() throws ArException;

	/*
	 * Return the name of table inside the database where data needs to be stored
	 */
	public String getTableName() throws ArException;

	/*
	 * Return the list of columns inside the table for which data needs to be stored
	 */
	public List<String> getColumns() throws ArException;

	/*
	 * Insert given list of dataRows into the underlying system
	 */
	public void insertDataRows(List<DataRow> dataRows) throws ArException;

	/*
	 * Insert given dataRow into the underlying system
	 */
	public void insertDataRow(DataRow dataRow) throws ArException;

	public DataRow createDataRow() throws ArException;

	public void load() throws ArException;

	public void init(String filePath, String fileName, String sheetName) throws ArException;

}
