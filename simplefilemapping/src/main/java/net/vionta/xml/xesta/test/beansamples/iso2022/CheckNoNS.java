package net.vionta.xml.xesta.test.beansamples.iso2022;

import java.io.Serializable;

import net.vionta.xml.xesta.bind.annotation.Bind;


@Bind(expression = "//*:CstmrCdtTrfInitn" )
public class CheckNoNS implements Serializable {
 
	public CheckNoNS() {} 
	
	@Bind(expression = "*:PmtInf/*:PmtMtd")
	private String paymentMethod; 

	@Bind(expression = "*:PmtInf/*:Dbtr/*:Nm")
	private String debtorName;
	 
	 @Bind(expression = "*:PmtInf/*:DbtrAcct/*:Id/*:Othr/*:Id")
	 private String debtorAccount;

	 @Bind(expression = "*:PmtInf/*:CdtTrfTxInf/*:Cdtr/*:Nm")
     private String creditorName;
	 
     @Bind(expression = "*:PmtInf/*:CdtTrfTxInf/*:ChqInstr/*:ChqNb")
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
	 
}
