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
import net.vionta.xml.xesta.test.beansamples.sheet.contents.Sheet;
import net.vionta.xml.xesta.test.beansamples.sheet.contents.Cell;

public class Sheet3Test {

	private static Logger log = LoggerFactory.getLogger(Sheet3Test.class);

	
	 @Test
	public void testGetSpreadSheetContent() throws PersistException, IOException {
	ZipArchiveFileRepository repo = new ZipArchiveFileRepository();
	repo.setZipFilePattern(CommonTest.getBasePath()+"openDocument/sample-spreadsheet-3.ods");
	repo.setFileNamePattern( "content.xml");
	Sheet spreadsheet = repo.load( new Sheet());
	String s = SheetCSV.getCSVContent(spreadsheet);
	log.info(s);

	Cell c = new Cell();
	 c.setValue("X");
//	 c.setCalcType("string");
//	 c.setOfficeType("string");
	 Cell c2 = new Cell();
	 c2.setValue("-");
//	 c2.setCalcType("string");
//	 c2.setOfficeType("string");

//	 spreadsheet.getTables().get(0).getRows().get(4).getCells().add(c);
	 
	 for(int i = 1 ; i < 100 ; i++) {
		 spreadsheet.getTables().get(0).getRows().get(0).getCells().add(c2);
		 spreadsheet.getTables().get(0).getRows().get(1).getCells().add(c);
		 spreadsheet.getTables().get(0).getRows().get(2).getCells().add(c2);
		 spreadsheet.getTables().get(0).getRows().get(3).getCells().add(c);
		 spreadsheet.getTables().get(0).getRows().get(4).getCells().add(c2);
		 spreadsheet.getTables().get(0).getRows().get(5).getCells().add(c);
		 spreadsheet.getTables().get(0).getRows().get(6).getCells().add(c2);
	 }

	 repo.setZipFilePattern(CommonTest.getOutputPath()+"openDocument/sample-spreadsheet-3.ods");
	 repo.persist(spreadsheet);
	 String readFile = 	ZipFileUtil.readTextFileInZip(CommonTest.getOutputPath()+"openDocument/sample-spreadsheet-3.ods", "content.xml");
	 log.info(readFile);
	 assertTrue(readFile.indexOf("<table:table-cell><text:p>X</text:p>")> 100);

	 }


}
