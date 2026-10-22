package net.vionta.xml.xesta.test.beansamples.log;

import java.io.Serializable;

import net.vionta.xml.xesta.bind.annotation.Bind;

@Bind(expression="*:appender")
public class Appender implements Serializable {
	
	@Bind(expression = "@*:name",key=true)
	private String name;

	@Bind(expression = "*:param[@name='Threshold']/@value")
	private String level;

	public Appender() {	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Appender [name=" + name + ", level=" + level + "]";
	} 
	

}
