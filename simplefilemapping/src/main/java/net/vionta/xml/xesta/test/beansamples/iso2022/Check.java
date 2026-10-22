package net.vionta.xml.xesta.test.beansamples.iso2022;

import java.io.Serializable;

import net.vionta.xml.xesta.bind.annotation.Bind;


@Bind(expression = "//Q{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}CstmrCdtTrfInitn" )
public class Check implements Serializable {
 
	public Check() {} 
	
	@Bind(expression = "Q{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}PmtInf/*:PmtMtd")
	private String paymentMethod; 

	@Bind(expression = "Q{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}PmtInf/*:Dbtr/*:Nm")
	private String debtorName;
	 
	 @Bind(expression = "Q{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}PmtInf/*:DbtrAcct/*:Id/*:Othr/*:Id")
	 private String debtorAccount;

	 @Bind(expression = "Q{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}PmtInf/*:CdtTrfTxInf/*:Cdtr/*:Nm")
     private String creditorName;
	 
     @Bind(expression = "Q{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}PmtInf/*:CdtTrfTxInf/*:ChqInstr/*:ChqNb")
     private String creditorCheckNumber;
	 
	 @Bind(expression = "*:PmtInf/*:CdtTrfTxInf/*:Amt/*:InstdAmt")
	 private Float amount;

	 @Bind(expression = "Q{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}PmtInf/*:CdtTrfTxInf/*:Amt/*:InstdAmt/@*:Ccy")
	 private String currency;

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getDebtorName() {
		return debtorName;
	}

	public void setDebtorName(String debtorName) {
		this.debtorName = debtorName;
	}

	public String getDebtorAccount() {
		return debtorAccount;
	}

	public void setDebtorAccount(String debtorAccount) {
		this.debtorAccount = debtorAccount;
	}

	public String getCreditorName() {
		return creditorName;
	}

	public void setCreditorName(String creditorName) {
		this.creditorName = creditorName;
	}

	public String getCreditorCheckNumber() {
		return creditorCheckNumber;
	}

	public void setCreditorCheckNumber(String creditorCheckNumber) {
		this.creditorCheckNumber = creditorCheckNumber;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	 
}
