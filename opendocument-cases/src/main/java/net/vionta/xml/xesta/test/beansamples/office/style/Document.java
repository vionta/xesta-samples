package net.vionta.xml.xesta.test.beansamples.office.style;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.vionta.xml.xesta.bind.annotation.Bind;

@Bind(expression="office:document-styles", namespaceAlias = {"office"} ,namespaceUris = {"urn:oasis:names:tc:opendocument:xmlns:office:1.0"})
public class Document implements Serializable {
	
	@Bind(expression="office:styles", namespaceAlias = {"office", "style"},
	namespaceUris = {"urn:oasis:names:tc:opendocument:xmlns:office:1.0", 
			"urn:oasis:names:tc:opendocument:xmlns:style:1.0"})
	private List<Style> styles = new ArrayList<Style>();

	public List<Style> getStyles() {
		return this.styles;
	}

	public void setStyles(List<Style> styles) {
		this.styles = styles;
	}

	@Override
	public String toString() {
		return "Document [styles=" + toStringStyles() + "]";
	}

	private String  toStringStyles() {
		StringBuilder sb = new StringBuilder();
		for(Style style : this.styles) {
			sb.append("\n "+style.toString());
		}
		return sb.toString();
	}
	
	

}
