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

public class Sheet2Test2 {

	private static Logger log = LoggerFactory.getLogger(Sheet2Test2.class);

	
	 @Test
	public void testGetSpreadSheetContent() throws PersistException, IOException {
	ZipArchiveFileRepository repo = new ZipArchiveFileRepository();
	repo.setZipFilePattern(CommonTest.getOutputPath()+"openDocument/sample-spreadsheet-2.ods");
	repo.setFileNamePattern( "content.xml");
	Sheet spreadsheet = repo.load( new Sheet());
	String s = SheetCSV.getCSVContent(spreadsheet);
	log.info(s);
	 assertTrue(s.indexOf("oenuoe")>-1);
	 assertTrue(s.indexOf("12/12/22")>-1);
	 assertTrue(s.indexOf("prueba-pestana")>-1);
	 Cell c = new Cell();
	 c.setValue("X");
	 c.setCalcType("string");
	 c.setOfficeType("string");
	 spreadsheet.getTables().get(1).getRows().get(4).getCells().add(c);
	 spreadsheet.getTables().get(1).getRows().get(4).getCells().add(c);
	 spreadsheet.getTables().get(1).getRows().get(4).getCells().add(c);
	 spreadsheet.getTables().get(1).getRows().get(4).getCells().add(c);
	 spreadsheet.getTables().get(1).getRows().get(4).getCells().add(c);
	 repo.persist(spreadsheet);
	 String readFile = 	ZipFileUtil.readTextFileInZip(CommonTest.getOutputPath()+"openDocument/sample-spreadsheet-2.ods", "content.xml");
	log.info(readFile);
	 }


}
