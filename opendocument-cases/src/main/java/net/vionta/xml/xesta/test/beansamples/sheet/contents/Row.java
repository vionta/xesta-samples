package net.vionta.xml.xesta.test.beansamples.sheet.contents;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.vionta.xml.xesta.bind.annotation.Bind;
import net.vionta.xml.xesta.bind.annotation.SerializingMode;

@Bind( expression="table:table-row", namespaceAlias = {"table"}, 
namespaceUris = {"urn:oasis:names:tc:opendocument:xmlns:table:1.0"}, collectionBindStrategy = SerializingMode.BIND_COLLECTION_BY_POSITION)
public class Row implements Serializable {

	@Bind(collectionBindStrategy = SerializingMode.BIND_COLLECTION_BY_POSITION,namespaceAlias = {"table"}, 
			namespaceUris = {"urn:oasis:names:tc:opendocument:xmlns:table:1.0"})
	private List<Cell> cells = new ArrayList<Cell>();
	
	public Row() {	}

	public List<Cell> getCells() {
		return cells;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}
	
}
