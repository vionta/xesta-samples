package net.vionta.xml.xesta.test.beansamples.style;

import java.io.Serializable;

import net.vionta.xml.xesta.bind.annotation.Bind;

@Bind(expression="style:style", namespaceAlias = {"style"}, 
namespaceUris = {"urn:oasis:names:tc:opendocument:xmlns:style:1.0"})
public class Style implements Serializable {

//	<office:styles>
//	<style:default-style style:family="graphic">
//	
//	<style:style style:name="List" style:family="paragraph"
//	style:parent-style-name="Text_20_body" style:class="list">
//	<style:text-properties 
//		style:font-size-asian="12pt"
//		style:font-name-complex="Lucida Sans"
//		style:font-family-complex="&apos;Lucida Sans&apos;"
//		style:font-family-generic-complex="swiss" />
//</style:style>

	@Bind(expression="@style:name", key=true, namespaceAlias = {"style"}, namespaceUris = {"urn:oasis:names:tc:opendocument:xmlns:style:1.0"})
	private String name; 
	@Bind(expression="@style:family", namespaceAlias = {"style"}, namespaceUris = {"urn:oasis:names:tc:opendocument:xmlns:style:1.0"})
	private String family;
	@Bind(expression="@*:parent-style-name")
	private String parentStylename;
	@Bind(expression="./*:text-properties/@fo:font-size", namespaceAlias = {"style","fo"}, namespaceUris = {"urn:oasis:names:tc:opendocument:xmlns:style:1.0", "urn:oasis:names:tc:opendocument:xmlns:xsl-fo-compatible:1.0"})
	private String fontSize;
	
	public Style() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getParentStylename() {
		return parentStylename;
	}

	public void setParentStylename(String parentStylename) {
		this.parentStylename = parentStylename;
	}

	public String getFontSize() {
		return fontSize;
	}

	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	@Override
	public String toString() {
		return " - Style [name=" + name + ", -> " + family + ""
				+ parentStylename + "\n   -- fontSize=" + fontSize + "]";
	}
	
}
