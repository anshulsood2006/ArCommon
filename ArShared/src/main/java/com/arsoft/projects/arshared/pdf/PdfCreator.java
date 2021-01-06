package com.arsoft.projects.arshared.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.arsoft.projects.arshared.exception.ArException;
import com.arsoft.projects.arshared.logging.ArLogger;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfCreator {

	public static final ArLogger arLogger = new ArLogger(PdfCreator.class);
	
	public static void create() throws ArException {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));
			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			Chunk chunk = new Chunk("Hello World", font);
			document.add(chunk);
			document.close();
		} catch (FileNotFoundException e) {
			arLogger.logError(e.getMessage());
		} catch (DocumentException e) {
			arLogger.logError(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}
}
