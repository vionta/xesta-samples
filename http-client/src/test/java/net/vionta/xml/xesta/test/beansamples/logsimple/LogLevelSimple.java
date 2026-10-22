package net.vionta.xml.xesta.test.beansamples.logsimple;

import java.io.Serializable;

import net.vionta.xml.xesta.bind.annotation.Bind;

@Bind(expression = "/*:configuration/appender[@name='CONSOLE']")
public class LogLevelSimple implements Serializable {
	   
	@Bind(expression = "param[@name='Threshold']/@value")
	private String level;
	
	public LogLevelSimple(String level) {
		super();
		this.level = level;
	}

	public LogLevelSimple() {
		super();
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "LogLevelSimple [level=" + level + "]";
	}
	
	
	
}
