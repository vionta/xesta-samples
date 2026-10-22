package net.vionta.xml.xesta.test.cases.opendocument.sheet1;

import java.io.Serializable;

import net.vionta.xml.xesta.bind.annotation.Bind;


@Bind(expression = "/*:document-content")
public class Spreadsheet1 implements Serializable {

	@Bind(expression="..//*:table-row[4]/*:table-cell[3]/*:p")
	private String name;
	@Bind(expression="..//*:table-row[5]/*:table-cell[3]/*:p")
	private String surname;
	@Bind(expression="..//*:table-row[6]/*:table-cell[3]/*:p")
	private String age;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Spreadsheet1 [name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}
	
}
