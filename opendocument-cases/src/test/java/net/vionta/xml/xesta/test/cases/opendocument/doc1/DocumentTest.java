package net.vionta.xml.xesta.test.cases.opendocument.doc1;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import net.sf.saxon.resource.ResourceLoader;
import net.vionta.xml.xesta.bind.analyze.BindMapExtractor;

import net.vionta.xml.xesta.bind.serialize.Serializer;
import net.vionta.xml.xesta.exception.BindingException;
import net.vionta.xml.xesta.exception.MappingException;
import net.vionta.xml.xesta.repository.exception.PersistException;
import net.vionta.xml.xesta.repository.impl.ZipArchiveFileRepository;
import net.vionta.xml.xesta.repository.impl.util.ClasspathFileUtil;
import net.vionta.xml.xesta.repository.impl.util.DocumentUtils;
import net.vionta.xml.xesta.repository.impl.util.FileManager;
import net.vionta.xml.xesta.repository.impl.util.ZipFileUtil;
import net.vionta.xml.xesta.test.CommonTest;

/**
 * Checks that a classpath file can be read 
 * and written.
 */
public class DocumentTest {

	private static Logger log = LoggerFactory.getLogger(CommonTest.class);
//		String zipFilePattern = CommonTest.getOutputPath()+"openDocument/text/fictional-report.odt";
	
	@Test
	public void serializeRepository() throws IOException, SAXException, ParserConfigurationException, URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, XPathExpressionException, NoSuchFieldException, MappingException, BindingException, TransformerException, PersistException {
		
		//Declare zip file repository
		String zipFilePattern = CommonTest.getBasePath()+"openDocument/text/fictional-report.odt";
		ZipArchiveFileRepository repo = new ZipArchiveFileRepository(
																	zipFilePattern,"content.xml");

		//Provide test data 
		Document1 doc1 = new Document1();
		doc1 = (Document1) repo.load(doc1);
		doc1.setName("Jacinto");
		doc1.setSurname("Gutierrez");
		doc1.setAddress("Paseo de extremadura,15.4º Izq");

		zipFilePattern = CommonTest.getOutputPath()+"openDocument/text/fictional-report.odt";
		repo.setZipFilePattern(zipFilePattern);
		//Persist the xml doc
		repo.persist(doc1);
		
		//Test result validation
		String docResult = ZipFileUtil.readTextFileInZip(zipFilePattern, "content.xml");
		assertTrue(docResult.indexOf("Jacinto")>-1);
		assertTrue(docResult.indexOf("Gutierrez")>-1);
		assertTrue(docResult.indexOf("extremadura")>-1);
		log.debug(">>"+docResult +" >");
		log.warn("**** In case of failure make sure to refresh the output folder ***");
		
	}
		
}
