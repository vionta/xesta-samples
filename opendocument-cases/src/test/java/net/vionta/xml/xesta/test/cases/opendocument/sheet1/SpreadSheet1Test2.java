package net.vionta.xml.xesta.test.cases.opendocument.sheet1;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import net.vionta.xml.xesta.exception.BindingException;
import net.vionta.xml.xesta.exception.MappingException;
import net.vionta.xml.xesta.repository.exception.PersistException;
import net.vionta.xml.xesta.repository.impl.ZipArchiveFileRepository;
import net.vionta.xml.xesta.repository.impl.util.ZipFileUtil;
import net.vionta.xml.xesta.test.CommonTest;

/**
 * Checks that a classpath file can be read 
 * and written.
 */
public class SpreadSheet1Test2 {

	private static Logger log = LoggerFactory.getLogger(CommonTest.class);
	
	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void storeTest() throws IOException, SAXException, ParserConfigurationException, URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, XPathExpressionException, NoSuchFieldException, MappingException, BindingException, TransformerException, PersistException {
		ZipArchiveFileRepository repo = new ZipArchiveFileRepository();
		repo.setZipFilePattern(CommonTest.getOutputPath()+"openDocument/sample-spreadsheet-1.ods");
		repo.setFileNamePattern( "content.xml");

		Spreadsheet1 spreadsheet1 = new Spreadsheet1();
		spreadsheet1.setName("Jacinto");
		spreadsheet1.setSurname("Gutierrez");
		spreadsheet1.setAge("55");
		log.info(">>"+spreadsheet1+" >");
		repo.persist(spreadsheet1);
		
		String updatedResult = ZipFileUtil.readTextFileInZip(CommonTest.getOutputPath()+"openDocument/sample-spreadsheet-1.ods", "content.xml");
		assertTrue(updatedResult.indexOf("55")>-1);
		assertTrue(updatedResult.indexOf("Jacinto")>-1);
		assertTrue(updatedResult.indexOf("Gutierrez")>-1);
		log.info(">>"+updatedResult +" >");
	}
	
	
}
