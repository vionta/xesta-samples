package net.vionta.xml.xesta.test.cases.http.weather.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.vionta.xml.xesta.bind.annotation.Bind;

@Bind(expression = "/root")
public class WeatherLocation implements Serializable {
	
	public WeatherLocation() {}
	
	@Bind(expression = "nombre")
	String locationName ; 
	
	@Bind(expression = "@id")
	String locationCode  ;
	
	@Bind(expression="prediccion/dia")
	private List<DayPrediction> nextDays = new ArrayList<DayPrediction>();

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public List<DayPrediction> getNextDays() {
		return nextDays;
	}

	public void setNextDays(List<DayPrediction> nextDays) {
		this.nextDays = nextDays;
	}

	@Override
	public String toString() {
		return "WeatherLocation [locationName=" + locationName + ", locationCode=" + locationCode + ", nextDays="
				+ nextDays + "]";
	}
	
}
