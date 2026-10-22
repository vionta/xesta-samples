package net.vionta.xml.xesta.test.cases.opendocument.sheet2;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.vionta.xml.xesta.repository.exception.PersistException;
import net.vionta.xml.xesta.repository.impl.ZipArchiveFileRepository;
import net.vionta.xml.xesta.repository.impl.util.ZipFileUtil;
import net.vionta.xml.xesta.test.CommonTest;
import net.vionta.xml.xesta.test.beansamples.sheet.contents.Cell;
import net.vionta.xml.xesta.test.beansamples.sheet.contents.Row;
import net.vionta.xml.xesta.test.beansamples.sheet.contents.Sheet;
import net.vionta.xml.xesta.test.beansamples.sheet.contents.Cell;

public class Sheet4Test {

	private static Logger log = LoggerFactory.getLogger(Sheet4Test.class);

	
	 @Test
	public void testGetSpreadSheetContent() throws PersistException, IOException {
	ZipArchiveFileRepository repo = new ZipArchiveFileRepository();
	String spreadsheetFile = "openDocument/sample-spreadsheet-4.ods";
	repo.setZipFilePattern(CommonTest.getBasePath()+spreadsheetFile);
	repo.setFileNamePattern( "content.xml");
	Sheet spreadsheet = repo.load( new Sheet());
//	String s = SheetCSV.getCSVContent(spreadsheet);
//	log.info(s);

	Cell c = new Cell();
	 c.setValue("X");
	 c.setCalcType("string");
	 c.setOfficeType("string");
	 Cell c2 = new Cell();
	 c2.setValue("-");

	 
	 for(int t = 0 ; t < 20 ; t++) {
		 Row row = spreadsheet.getTables().get(0).getRows().get(t);
		 
		 for(int i = 0 ; i < 20 ; i++) {
			 if(i % 2 == 0) 
			 row.getCells().add(c);
			 else 
				 row.getCells().add(c2);
		 }
		 
	 }

	 repo.setZipFilePattern(CommonTest.getOutputPath()+spreadsheetFile);
	 repo.persist(spreadsheet);
	 String readFile = 	ZipFileUtil.readTextFileInZip(CommonTest.getOutputPath()+spreadsheetFile, "content.xml");
	 log.info(readFile);
	 assertTrue(readFile.indexOf("<table:table-cell><text:p>X</text:p>")> 100);
	 assertTrue(readFile.indexOf("<table:table-cell><text:p>-</text:p>")> 100);

	 }


}
