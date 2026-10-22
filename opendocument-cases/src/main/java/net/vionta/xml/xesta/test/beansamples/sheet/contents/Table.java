package net.vionta.xml.xesta.test.beansamples.sheet.contents;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.vionta.xml.xesta.bind.annotation.Bind;
import net.vionta.xml.xesta.bind.annotation.SerializingMode;

@Bind( expression ="table:table",  namespaceAlias = {"table"} , namespaceUris = {"urn:oasis:names:tc:opendocument:xmlns:table:1.0"})
public class Table implements Serializable {
	
	@Bind(expression="@table:name", key=true, 	namespaceAlias = {"table"} , namespaceUris = {"urn:oasis:names:tc:opendocument:xmlns:table:1.0"})
	private String name ; 

	@Bind(collectionBindStrategy = SerializingMode.BIND_COLLECTION_BY_POSITION, namespaceAlias = {"table"} , namespaceUris = {"urn:oasis:names:tc:opendocument:xmlns:table:1.0"})
	public List<Row> rows = new ArrayList<Row>();
	
	public Table() {}

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
