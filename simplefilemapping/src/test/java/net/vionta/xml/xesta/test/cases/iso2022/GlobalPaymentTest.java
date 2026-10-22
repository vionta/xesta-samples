package net.vionta.xml.xesta.test.cases.iso2022;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import net.vionta.xml.xesta.repository.exception.PersistException;
import net.vionta.xml.xesta.repository.impl.FilePathRepository;
import net.vionta.xml.xesta.test.beansamples.iso2022.GlobalPayment;

public class GlobalPaymentTest {

	@Test
	public void test() throws PersistException, IOException, SAXException, ParserConfigurationException {
	
		FilePathRepository repo = new FilePathRepository(CheckNamespaceContext.basePath+"cases/iso20022/GlobalPayment.xml");
		GlobalPayment globalPayment = new GlobalPayment();
		globalPayment = repo.load(globalPayment);

		assertTrue(globalPayment.getPaymentMethod().equals("TRF"));
		assertTrue(globalPayment.getDebtorName().equals("Debtor Account Holder Name"));
		assertTrue(globalPayment.getDebtorAccount().equals("Debtor Account Id"));
		assertTrue(globalPayment.getDebtorBankBIC().equals("Bank BIC"));
		assertTrue(globalPayment.getPaymentId().equals("End-to-End-Id"));
//		assertTrue(globalPayment.getAmount().equals(Double.parseDouble("510.24"))));
		assertTrue(globalPayment.getCurrency().equals("GBP"));
		assertTrue(globalPayment.getCreditorBankBIC().equals("Bank BIC"));
		assertTrue(globalPayment.getCreditorName().equals("Creditor Account Holder Name"));
		assertTrue(globalPayment.getCreditorAccouunt().equals("Creditor Account Id"));

	}

}
