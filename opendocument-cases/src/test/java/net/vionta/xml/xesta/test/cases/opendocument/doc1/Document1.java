package net.vionta.xml.xesta.test.cases.opendocument.doc1;


import java.io.Serializable;

import net.vionta.xml.xesta.bind.annotation.Bind;


@Bind(expression = "/*:document-content")
public class Document1 implements Serializable {

	@Bind(expression="..//*:p[text()='Your_Name_here']")
	private String name;
	@Bind(expression="..//*:p[text()='Your_Surname_here']")
	private String surname;
	@Bind(expression="..//*:p[text()='Your_Address_here']")
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Document1 [name=" + name + ", surname=" + surname + ", address=" + address + "]";
	}
	
}
