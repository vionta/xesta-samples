package net.vionta.xml.xesta.test.cases.iso2022;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import net.vionta.xml.xesta.repository.exception.PersistException;
import net.vionta.xml.xesta.repository.impl.FilePathRepository;
import net.vionta.xml.xesta.test.beansamples.iso2022.CheckNS;
import net.vionta.xml.xesta.test.beansamples.iso2022.CheckNoNS;

public class CheckNoNSTest {

	private static Logger log = LoggerFactory.getLogger(CheckNoNSTest.class);
	protected static String basePath =  "C:\\Users\\jorge\\dev\\ws\\xml-binding\\simplefilemapping\\src\\test\\resources\\";

	@Test
	public void test() throws PersistException, IOException, SAXException, ParserConfigurationException {
	
		FilePathRepository repo = new FilePathRepository(
					basePath+"cases/iso20022/Check.xml");
		CheckNoNS check = new CheckNoNS();
		check = repo.load(check);
		log.debug("Retrieved check: "+check);
		assertTrue(check.getPaymentMethod().equals("CHK"));
		assertTrue(check.getDebtorName().equals("Debtor Account Holder Name"));
		assertTrue(check.getDebtorAccount().equals("Debtor Account Id"));
		assertTrue(check.getCreditorName().equals("Creditor Account Holder Name"));
		assertTrue(check.getCreditorCheckNumber().equals("Check Number"));
		assertTrue(check.getAmount().equals(Float.parseFloat("510.24")));
		assertTrue(check.getCurrency().equals("USD"));

	}
}
