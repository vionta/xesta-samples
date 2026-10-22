package net.vionta.xml.xesta.test.beansamples.iso2022;

import java.io.Serializable;

import net.vionta.xml.xesta.bind.annotation.Bind;

// This doesn't work.
//@Bind(expression = "/Q{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}Document/Q{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}:CstmrCdtTrfInitn" )
// This works
//@Bind(expression = "/Q{urn:iso:std:iso:20022:tech:xsd:pain.001.001.03}Document/*:CstmrCdtTrfInitn" )
// This works
@Bind(expression = "//iso:CstmrCdtTrfInitn" , namespaceAlias = {"iso"} , namespaceUris = {"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"})
public class CheckNS implements Serializable {
 
	public CheckNS() {} 
	
	@Bind(expression = "iso:PmtInf/iso:PmtMtd" , namespaceAlias = {"iso"} , namespaceUris = {"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"}) 
	private String paymentMethod; 

	@Bind(expression = "*:PmtInf/*:Dbtr/*:Nm")
	private String debtorName;
	 
	 @Bind(expression = "*:PmtInf/*:DbtrAcct/*:Id/*:Othr/*:Id")
	 private String debtorAccount;

	 @Bind(expression = "iso:PmtInf/iso:CdtTrfTxInf/iso:Cdtr/iso:Nm" , namespaceAlias = {"iso"} , namespaceUris = {"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"})
     private String creditorName;
             
     @Bind(expression = "*:PmtInf/iso:CdtTrfTxInf/*:ChqInstr/iso:ChqNb" , namespaceAlias = {"iso"} , namespaceUris = {"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"})
     private String creditorCheckNumber;
	 
	 @Bind(expression = "*:PmtInf/*:CdtTrfTxInf/*:Amt/*:InstdAmt")
	 private Float amount;

	 @Bind(expression = "*:PmtInf/*:CdtTrfTxInf/*:Amt/*:InstdAmt/@*:Ccy")
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

	@Override
	public String toString() {
		return "CheckNS [paymentMethod=" + paymentMethod + ", debtorName=" + debtorName + ", debtorAccount="
				+ debtorAccount + ", creditorName=" + creditorName + ", creditorCheckNumber=" + creditorCheckNumber
				+ ", amount=" + amount + ", currency=" + currency + "]";
	}
	
	 
}
