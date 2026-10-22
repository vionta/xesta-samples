package net.vionta.xml.xesta.test.beansamples.sheet.contents;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.vionta.xml.xesta.bind.annotation.Bind;

@Bind(expression = "//office:body/office:spreadsheet[1]", namespaceAlias = {"office"} , namespaceUris = {"urn:oasis:names:tc:opendocument:xmlns:office:1.0"})
public class Sheet implements Serializable {
	
	@Bind(namespaceAlias = {"table"} , namespaceUris = {"urn:oasis:names:tc:opendocument:xmlns:table:1.0"})
	private List<Table> tables = new ArrayList<Table>(); 

	public Sheet() {	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}
	
}
