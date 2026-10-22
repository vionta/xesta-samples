package net.vionta.xml.xesta.test.cases.opendocument.sheet1;

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
import net.vionta.xml.xesta.bind.analyze.map.Mapping;
import net.vionta.xml.xesta.bind.serialize.Deserializer;
import net.vionta.xml.xesta.bind.serialize.Serializer;
import net.vionta.xml.xesta.exception.BindingException;
import net.vionta.xml.xesta.exception.MappingException;
import net.vionta.xml.xesta.repository.exception.PersistException;
import net.vionta.xml.xesta.repository.impl.util.ClasspathFileUtil;
import net.vionta.xml.xesta.repository.impl.util.DocumentUtils;
import net.vionta.xml.xesta.repository.impl.util.FileManager;
import net.vionta.xml.xesta.repository.impl.util.ZipFileUtil;
import net.vionta.xml.xesta.test.CommonTest;

/**
 * Checks that a classpath file can be read 
 * and written.
 */
public class SpreadSheet1Test {

	private static Logger log = LoggerFactory.getLogger(CommonTest.class);
	
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tryes to write and read a log4j file.
	 * 
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws URISyntaxException
	 * @throws ClassNotFoundException 
	 * @throws BindingException 
	 * @throws MappingException 
	 * @throws NoSuchFieldException 
	 * @throws XPathExpressionException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@Test
	public void deSerializetest() throws IOException, SAXException, ParserConfigurationException, URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, XPathExpressionException, NoSuchFieldException, MappingException, BindingException {
		String readFile = 	ZipFileUtil.readTextFileInZip(CommonTest.getOutputPath()+"openDocument/sample-spreadsheet-1.ods", "content.xml");
		log.info(" >"+ readFile);
	        Mapping mapping = BindMapExtractor.analyze(new Spreadsheet1());
		Spreadsheet1 deserialized = (Spreadsheet1) new Deserializer().deserialize(mapping,DocumentUtils.stringToDocument(readFile));
		log.info(">>"+deserialized.toString() +" >");
	}
	
	@Test
	public void serializetest() throws IOException, SAXException, ParserConfigurationException, URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, XPathExpressionException, NoSuchFieldException, MappingException, BindingException, TransformerException, PersistException {
		String spreadSheetContent = 	ZipFileUtil.readTextFileInZip(CommonTest.getOutputPath()+"openDocument/sample-spreadsheet-1.ods", "content.xml");
		Spreadsheet1 spreadsheet1 = new Spreadsheet1();
		spreadsheet1.setAge("55");
		spreadsheet1.setName("Jacinto");
		spreadsheet1.setSurname("Gutierrez");
		Document serialize = new Serializer().serialize(spreadsheet1,DocumentUtils.stringToDocument(spreadSheetContent));
		String spreadResult = DocumentUtils.documentToString(serialize);
		assertTrue(spreadResult.indexOf("55")>-1);
		assertTrue(spreadResult.indexOf("Jacinto")>-1);
		assertTrue(spreadResult.indexOf("Gutierrez")>-1);
		log.info(">>"+spreadResult +" >");
	}
	
	@Test
	public void roundTripTest() throws IOException, SAXException, ParserConfigurationException, URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, XPathExpressionException, NoSuchFieldException, MappingException, BindingException, TransformerException, PersistException {
		String readFile = 	ZipFileUtil.readTextFileInZip(CommonTest.getBasePath()+"openDocument/sample-spreadsheet-1.ods", "content.xml");
		log.info(" >"+ readFile);
		Mapping mapping = BindMapExtractor.analyze(new Spreadsheet1());
		Spreadsheet1 deserialized = (Spreadsheet1) new Deserializer().deserialize(mapping,DocumentUtils.stringToDocument(readFile));
		log.info(">>"+deserialized.toString() +" >");
		deserialized.setName("Iturralde");
		deserialized.setSurname("Ruiperez");
		deserialized.setAge("55");
		Document serializedSpread = new Serializer().serialize(deserialized,DocumentUtils.stringToDocument(readFile));
		ZipFileUtil.writeTextFileInZip(CommonTest.getOutputPath()+"openDocument/sample-spreadsheet-1.ods", "content.xml", DocumentUtils.documentToString(serializedSpread));
		
	}
	
}
