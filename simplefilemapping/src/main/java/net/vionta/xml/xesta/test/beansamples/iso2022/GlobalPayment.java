package net.vionta.xml.xesta.test.beansamples.iso2022;

import java.io.Serializable;

import net.vionta.xml.xesta.bind.annotation.Bind;

// Document sample source : https://developer.gs.com/docs/services/transaction-banking/iso20022samples/ -->
@Bind(expression = "/iso:Document/iso:CstmrCdtTrfInitn", namespaceAlias = {"iso"} , namespaceUris = {"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"})
public class GlobalPayment implements Serializable {
	
@Bind(expression = "iso:PmtInf/iso:PmtMtd", namespaceAlias = {"iso"} , namespaceUris = {"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"})
private String paymentMethod;//TRF

@Bind(expression = "iso:PmtInf/iso:Dbtr/iso:Nm", namespaceAlias = {"iso"} , namespaceUris = {"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"})
private String debtorName;//|Debtor Account Holder Name


            
@Bind(expression = "iso:PmtInf/iso:DbtrAcct/iso:Id/iso:Othr/iso:Id", namespaceAlias = {"iso"} , namespaceUris = {"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"})
private String debtorAccount;//|Debtor Account Id

@Bind(expression = "iso:PmtInf/iso:DbtrAgt/iso:FinInstnId/iso:BIC", namespaceAlias = {"iso"} , namespaceUris = {"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"})
private String debtorBankBIC;//|Bank BIC

@Bind(expression = "iso:PmtInf/iso:CdtTrfTxInf/iso:PmtId/iso:EndToEndId", namespaceAlias = {"iso"} , namespaceUris = {"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"})
private String paymentId;//|End-to-End-Id


//@Bind(expression = "iso:CdtTrfTxInf/iso:Amt/iso:InstdAmt", namespaceAlias = {"iso"} , namespaceUris = {"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"})
private Double amount;//|510.24


//CdtTrfTxInf/Amt/InstdAmt Ccy="GBP">
@Bind(expression = "iso:PmtInf/iso:CdtTrfTxInf/iso:Amt/iso:InstdAmt/@Ccy", namespaceAlias = {"iso"} , namespaceUris = {"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"})
private String currency;//|GBP"


@Bind(expression = "iso:PmtInf/iso:CdtTrfTxInf/iso:CdtrAgt/iso:FinInstnId/iso:BIC", namespaceAlias = {"iso"} , namespaceUris = {"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"})
private String creditorBankBIC;//|Bank BIC

@Bind(expression = "iso:PmtInf/iso:CdtTrfTxInf/iso:Cdtr/iso:Nm", namespaceAlias = {"iso"} , namespaceUris = {"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"})
private String creditorName;//|Creditor Account Holder Name

@Bind(expression = "iso:PmtInf/iso:CdtTrfTxInf/iso:CdtrAcct/iso:Id/iso:Othr/iso:Id", namespaceAlias = {"iso"} , namespaceUris = {"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03"})
private String creditorAccouunt;//|Creditor Account Id

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

public String getDebtorBankBIC() {
	return debtorBankBIC;
}

public void setDebtorBankBIC(String debtorBankBIC) {
	this.debtorBankBIC = debtorBankBIC;
}

public String getPaymentId() {
	return paymentId;
}

public void setPaymentId(String paymentId) {
	this.paymentId = paymentId;
}

public Double getAmount() {
	return amount;
}

public void setAmount(Double amount) {
	this.amount = amount;
}

public String getCurrency() {
	return currency;
}

public void setCurrency(String currency) {
	this.currency = currency;
}

public String getCreditorBankBIC() {
	return creditorBankBIC;
}

public void setCreditorBankBIC(String creditorBankBIC) {
	this.creditorBankBIC = creditorBankBIC;
}

public String getCreditorName() {
	return creditorName;
}

public void setCreditorName(String creditorName) {
	this.creditorName = creditorName;
}

public String getCreditorAccouunt() {
	return creditorAccouunt;
}

public void setCreditorAccouunt(String creditorAccouunt) {
	this.creditorAccouunt = creditorAccouunt;
}

@Override
public String toString() {
	return "GlobalPayment [paymentMethod=" + paymentMethod + ", debtorName=" + debtorName + ", debtorAccount="
			+ debtorAccount + ", debtorBankBIC=" + debtorBankBIC + ", paymentId=" + paymentId + ", amount=" + amount
			+ ", currency=" + currency + ", creditorBankBIC=" + creditorBankBIC + ", creditorName=" + creditorName
			+ ", creditorAccouunt=" + creditorAccouunt + "]";
}



}
