package net.vionta.xml.xesta.test.beansamples.sheet.contents;

import java.io.Serializable;

import net.vionta.xml.xesta.bind.annotation.Bind;
import net.vionta.xml.xesta.bind.annotation.SerializingMode;

@Bind(expression="table:table-cell", namespaceAlias = {"table"} , 
namespaceUris = {"urn:oasis:names:tc:opendocument:xmlns:table:1.0"}, collectionBindStrategy = SerializingMode.BIND_COLLECTION_BY_POSITION)
public class Cell implements Serializable {
	
	 @Bind(expression="text:p", namespaceAlias = {"text"}, 
			 namespaceUris = {"urn:oasis:names:tc:opendocument:xmlns:text:1.0"})
	private String value;
     
	 //	 office:value-type="string"
	 // office="urn:oasis:names:tc:opendocument:xmlns:office:1.0"
//	 	@namespaces ( value = {
//			 @namespace(uri="aeu" , alias="eueo"),
//			 @namespace(uri="aeu" , alias="eueo")
//	 }
//			 )
//	 			, namespaces = {
//		 @namespace(uri="aeu" , alias="eueo"),
//		 @namespace(uri="aeu" , alias="eueo")
//	 }
	 
	 @Bind(expression="@office:value-type", namespaceAlias = {"office"}, 
			 namespaceUris = {"urn:oasis:names:tc:opendocument:xmlns:office:1.0"})
	 private String officeType = "string";
	 
     //	 xmlns:calcext="urn:org:documentfoundation:names:experimental:calc:xmlns:calcext:1.0"
     //	calcext:value-type="string"
	 @Bind(expression="calcext:value-type", namespaceAlias = {"calcext"}, 
			 namespaceUris = {"urn:org:documentfoundation:names:experimental:calc:xmlns:calcext:1.0"})
	 private String calcType = "string";
				
	 public Cell() {
		 this.calcType = "string";
		 this.officeType = "string";
	 }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getOfficeType() {
		return officeType;
	}

	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}

	public String getCalcType() {
		return calcType;
	}

	public void setCalcType(String calcType) {
		this.calcType = calcType;
	}

	@Override
	public String toString() {
		return "Cell [value=" + value + "]";
	}
	
}
