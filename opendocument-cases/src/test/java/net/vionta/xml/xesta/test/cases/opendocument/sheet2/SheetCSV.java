package net.vionta.xml.xesta.test.cases.opendocument.sheet2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.vionta.xml.xesta.repository.exception.RetrieveException;
import net.vionta.xml.xesta.repository.impl.ZipArchiveFileRepository;
import net.vionta.xml.xesta.test.CommonTest;
import net.vionta.xml.xesta.test.beansamples.sheet.contents.Cell;
import net.vionta.xml.xesta.test.beansamples.sheet.contents.Row;
import net.vionta.xml.xesta.test.beansamples.sheet.contents.Sheet;
import net.vionta.xml.xesta.test.beansamples.sheet.contents.Table;
import net.vionta.xml.xesta.test.cases.opendocument.sheet1.Spreadsheet1;

public class SheetCSV {

	
	
	 @Test
	public void testGetSpreadSheetContent() throws RetrieveException {
	ZipArchiveFileRepository repo = new ZipArchiveFileRepository();
	repo.setZipFilePattern(CommonTest.getOutputPath()+"openDocument/sample-spreadsheet-1.ods");
	repo.setFileNamePattern( "content.xml");
	Sheet spreadsheet = repo.load( new Sheet());
	String s = getCSVContent(spreadsheet);
	 assertTrue(s.indexOf("Sample Spread sheet")>-1);
	 assertTrue(s.indexOf(";Name;Juan;")>-1);
	 assertTrue(s.indexOf(";Surname;Perez;")>-1);
	 assertTrue(s.indexOf(";Age;z;")>-1);
	 }

	 protected static String getCSVContent(Sheet spreadsheet) {
		 StringBuilder sb = new StringBuilder();
			for(Table table : spreadsheet.getTables()) {
				sb.append("\n-----------------------------------------");
				sb.append("\n Table : "+table.getName());
				sb.append("\n-----------------------------------------");
				for(Row row: table.getRows()) {
					StringBuilder b = new StringBuilder();
					for(Cell cell: row.getCells()) {
						b.append(((cell.getValue()!=null)? cell.getValue():"")+";");
					}
					sb.append("\n"+b.toString());
				}
			}
			return sb.toString();
	 }
	 
	private void printCSVContent(Sheet spreadsheet) {
		System.out.println(getCSVContent(spreadsheet));
	}

}
