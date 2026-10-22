package net.vionta.xml.xesta.test.cases.iso2022;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import net.vionta.xml.xesta.repository.exception.PersistException;
import net.vionta.xml.xesta.repository.impl.FilePathRepository;
import net.vionta.xml.xesta.test.beansamples.iso2022.Check;

public class CheckNamespaceTest {

	@Test
	public void test() throws PersistException, IOException, SAXException, ParserConfigurationException {
	
		FilePathRepository repo = new FilePathRepository(CheckNamespaceContext .basePath+"cases/iso20022/Check.xml");
		Check check = new Check();
		check = repo.load(check);

		assertTrue(check.getPaymentMethod().equals("CHK"));
		assertTrue(check.getDebtorName().equals("Debtor Account Holder Name"));
		assertTrue(check.getDebtorAccount().equals("Debtor Account Id"));
		assertTrue(check.getCreditorName().equals("Creditor Account Holder Name"));
		assertTrue(check.getCreditorCheckNumber().equals("Check Number"));
		assertTrue(check.getAmount().equals(Float.parseFloat("510.24")));
		assertTrue(check.getCurrency().equals("USD"));

	}
}
