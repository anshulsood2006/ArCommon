package com.arsoft.projects.arshared.dataloader;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelSheet {

	private String name;
	private List<String> headers;
	private int numberOfRows;
	private int numberOfColumns;
	private XSSFSheet sheet;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getHeaders() {
		return headers;
	}

	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	public void setNumberOfColumns(int numberOfColumns) {
		this.numberOfColumns = numberOfColumns;
	}

	public XSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(XSSFSheet sheet) {
		this.sheet = sheet;
	}

	@Override
	public String toString() {
		return "ExcelSheet [name=" + name + ", headers=" + headers + ", numberOfRows=" + numberOfRows
				+ ", numberOfColumns=" + numberOfColumns + ", sheet=" + sheet + "]";
	}

}
