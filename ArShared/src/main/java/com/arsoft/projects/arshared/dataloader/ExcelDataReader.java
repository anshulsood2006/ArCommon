package com.arsoft.projects.arshared.dataloader;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	private List<ExcelSheet> excelSheets;

	public ExcelDataReader(String filePath, String fileName) throws ArException {
		this.filePath = filePath;
		this.fileName = fileName;
		this.init();
	}

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
	public void readSheet(String sheetName) throws ArException {
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

	public void init() throws ArException {
		try {
			logger.debug("Going to read data from file: " + fileName + " at path: " + filePath);
			FileInputStream fis = new FileInputStream(new File(filePath + File.separator + fileName));
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			int totalSheets = wb.getNumberOfSheets();
			for (int index = 0; index < totalSheets; index++) {
				ExcelSheet excelSheet = new ExcelSheet();
				if (this.excelSheets == null) {
					this.excelSheets = new ArrayList<>();
				}
				XSSFSheet sheet = wb.getSheetAt(index);
				excelSheet.setSheet(sheet);
				this.excelSheets.add(excelSheet);
				Row excelRow = sheet.getRow(0);
				if (excelRow == null) {
					continue;
				} else {
					List<String> headers = excelSheet.getHeaders();
					Iterator<Cell> cellIterator = excelRow.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (headers == null) {
							headers = new ArrayList<>();
						}
						headers.add(cell.getStringCellValue());
					}
					excelSheet.setHeaders(headers);
					excelSheet.setNumberOfColumns(headers.size());
					int lastRowIndex = sheet.getLastRowNum();
					excelSheet.setNumberOfRows(lastRowIndex + 1);
				}
			}
			System.out.println(this);
		} catch (Exception exception) {
			throw new ArException(exception.getMessage(), logger);
		}
	}

	public List<ExcelSheet> getExcelSheets() {
		return excelSheets;
	}

	public void setExcelSheets(List<ExcelSheet> excelSheets) {
		this.excelSheets = excelSheets;
	}

	@Override
	public String toString() {
		return "ExcelDataReader [logger=" + logger + ", filePath=" + filePath + ", fileName=" + fileName
				+ ", sheetName=" + sheetName + ", excelSheets=" + excelSheets + "]";
	}

}
