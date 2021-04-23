package com.arsoft.projects.arshared.dataloader;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arsoft.projects.arshared.exception.ArException;

@Component
public class ExcelDataLoader implements DataLoader {

	private final Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private ExcelDataReader dataReader;

	@Override
	public String getDatabaseName() throws ArException {
		return dataReader.getFileName();
	}

	@Override
	public String getTableName() throws ArException {
		return dataReader.getSheetName();
	}

	@Override
	public List<String> getColumns() throws ArException {
		return null;
	}

	@Override
	public void insertDataRows(List<DataRow> dataRows) throws ArException {

	}

	@Override
	public void insertDataRow(DataRow dataRow) throws ArException {

	}

	@Override
	public DataRow createDataRow() throws ArException {
		return null;
	}

	@Override
	public void load() throws ArException {
		try {
			dataReader.readSheet("Hindi");
		} catch (Exception exception) {
			throw new ArException(exception.getMessage(), logger);
		}
	}

	@Override
	public void init(String filePath, String fileName, String sheetName) throws ArException {
		logger.debug("Going to load data of sheet: " + sheetName + " from file: " + fileName + " at path: " + filePath);
		this.dataReader.setFilePath(filePath);
		this.dataReader.setFileName(fileName);
		this.dataReader.setSheetName(sheetName);
	}

}
