package net.vionta.xml.xesta.test.beansamples.log;

import java.io.Serializable;
import java.util.ArrayList;

import net.vionta.xml.xesta.bind.annotation.Bind;

@Bind(expression = "/*:configuration")
public class LogLevel implements Serializable {

	@Bind(expression = "../*", classNames = "net.vionta.xml.xesta.test.beansamples.log.Appender")
    private ArrayList<Appender> appender = new ArrayList<Appender>();

	public LogLevel() {
		super();
	}

	public ArrayList<Appender> getAppender() {
		return appender;
	}

	public void setAppender(ArrayList<Appender> appenders) {
		this.appender = appenders;
	}

	@Override
	public String toString() {
		return "LogLevel [appender=" + appender + "]";
	}
	
	
	
}
