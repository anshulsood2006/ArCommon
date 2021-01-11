package com.arsoft.projects.arshared.dataloader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.arsoft.projects.arshared.exception.ArException;

@Component
public class ExcelDataReader implements DataReader {

	private final Logger logger = LogManager.getLogger(this.getClass());
	private String filePath;
	private String fileName;
	private String sheetName;
	@Override
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String getFilePath() {
		return this.filePath;
	}

	@Override
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String getFileName() {
		return this.fileName;
	}

	@Override
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	@Override
	public String getSheetName() {
		return this.sheetName;
	}

	@Override
	public void read() throws ArException {
		try {
			logger.debug(
					"Going to read data of sheet: " + sheetName + " from file: " + fileName + " at path: " + filePath);
			FileInputStream fis = new FileInputStream(new File(filePath + File.separator + fileName));
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(sheetName);
			if (sheet == null) {
				throw new ArException(
						"Not able to find sheet " + sheetName + " inside " + filePath + File.separator + fileName,
						logger);
			}
			Iterator<Row> itr = sheet.iterator();
			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					System.out.println(cell.getStringCellValue());
				}
			}
		} catch (Exception exception) {
			throw new ArException(exception.getMessage(), logger);
		}
		
	}

}
