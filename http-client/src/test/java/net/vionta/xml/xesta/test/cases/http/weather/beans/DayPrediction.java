package net.vionta.xml.xesta.test.cases.http.weather.beans;

import java.io.Serializable;

import net.vionta.xml.xesta.bind.annotation.Bind;

@Bind
public class DayPrediction implements Serializable {
	
	public DayPrediction() {}
	
	@Bind(expression="@fecha")
	private String date ;
	
	@Bind(expression="cota_nieve_prov[text()!=0][1]")
	private Integer snow; 
	
	@Bind(expression="prob_precipitacion[text()!=0][1]")
	private Integer rain; 
	
	@Bind(expression="estado_cielo[1]")
	private String clouds;

	@Bind(expression="max(viento/velocidad/text())")
	private Integer wind;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getRain() {
		return rain;
	}

	public boolean isRainy() {
		return (this.rain!=null);
	}

	public void setRain(Integer rain) {
		this.rain = rain;
	}

	public String getClouds() {
		return clouds;
	}

	public void setClouds(String clouds) {
		this.clouds = clouds;
	}
	
	public Integer getWind() {
		return wind;
	}

	public void setWind(Integer wind) {
		this.wind = wind;
	}
	
	public Integer getSnow() {
		return snow;
	}

	public boolean isSnowy() {
		return (this.snow != null);
	}

	public void setSnow(Integer snow) {
		this.snow = snow;
	}

	@Override
	public String toString() {
		return "DayPrediction [date=" + date + ", snow=" + isSnowy() + ", rain=" + isRainy() + ", clouds=" + clouds 
				+ ", wind="+ wind + "]";
	}
	
}
