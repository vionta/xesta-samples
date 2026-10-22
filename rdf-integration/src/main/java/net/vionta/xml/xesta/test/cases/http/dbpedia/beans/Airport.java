package net.vionta.xml.xesta.test.cases.http.dbpedia.beans;

import java.io.Serializable;

import net.vionta.xml.xesta.bind.annotation.Bind;

@Bind(expression="/*:RDF")
public class Airport implements Serializable {
	
	public Airport() {}
	
	private String key;
	
	//<dbp:name xml:lang="en">Vigo–Peinador Airport</dbp:name>
	@Bind(expression=".//dbp:name[1]/text()",  namespaceAlias= {"dbp"}, 
			namespaceUris= {"http://dbpedia.org/property/"})
	private String name;

	//rdfs:label xml:lang="es" // Aeropuerto de Vigo
	@Bind(expression=".//*:label[1]/text()")
	private String localName;
	
	//<dbo:runwayLength rdf:datatype="http://www.w3.org/2001/XMLSchema#double">2400.0</dbo:runwayLength>
    //<dbo:runwayLength rdf:datatype="http://www.w3.org/2001/XMLSchema#double">2399.9952</dbo:runwayLength>
   @Bind(expression=".//dbo:runwayLength[1]",
		 namespaceAlias = {"dbo"}, 
		 namespaceUris = {"http://dbpedia.org/ontology/"})
	private String runwayLenght;
	
    //<dbp:stat1Header xml:lang="en">Passengers</dbp:stat1Header>
	//<dbp:stat1Data rdf:datatype="http://www.w3.org/2001/XMLSchema#integer">1128578</dbp:stat1Data>
	@Bind(expression=".//*:stat1Data")
	private Integer passengers;

	//<dbp:stat2Header xml:lang="en">Passengers change 23-22</dbp:stat2Header>
	//<dbp:stat2Data rdf:datatype="http://dbpedia.org/datatype/perCent">19.2</dbp:stat2Data>
	@Bind(expression=".//*:stat2Data")
	private String passengersEvolution;

	//<dbp:stat3Header xml:lang="en">Movements</dbp:stat3Header>
	//<dbp:stat3Data rdf:datatype="http://www.w3.org/2001/XMLSchema#integer">14872</dbp:stat3Data>
	@Bind(expression=".//*:stat3Data")
	private String movements;
	    
	//<dbp:stat4Data rdf:datatype="http://www.w3.org/2001/XMLSchema#integer">807</dbp:stat4Data>
	//<dbp:stat4Header xml:lang="en">Cargo</dbp:stat4Header>
	@Bind(expression=".//*:stat4Data")
	private Integer cargo;
	    
	//<georss:point>42.229166666666664 -8.6275</georss:point>
	@Bind(expression=".//georss:point", 
	    	namespaceAlias = {"georss"}, 
	    	namespaceUris = {"http://www.georss.org/georss/"})
	private String position;

	//<dbp:iata xml:lang="en">VGO</dbp:iata>
	//<dbo:iataLocationIdentifier>VGO</dbo:iataLocationIdentifier>
	@Bind(expression=".//dbp:iata", 
			namespaceAlias = {"dbp"}, 
		namespaceUris = {"http://dbpedia.org/property/"})
	private String iataCode;
	
	//<dbp:icao xml:lang="en">LEVX</dbp:icao>
	//<dbo:icaoLocationIdentifier>LEVX</dbo:icaoLocationIdentifier>
	@Bind(expression=".//dbo:icaoLocationIdentifier", 
			 namespaceAlias = {"dbo"}, 
			 namespaceUris = {"http://dbpedia.org/ontology/"})
	private String icaoCode;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getRunwayLenght() {
		return runwayLenght;
	}

	public void setRunwayLenght(String runwayLenght) {
		this.runwayLenght = runwayLenght;
	}

	public Integer getPassengers() {
		return passengers;
	}

	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
	}

	public String getPassengersEvolution() {
		return passengersEvolution;
	}

	public void setPassengersEvolution(String passengersEvolution) {
		this.passengersEvolution = passengersEvolution;
	}

	public String getMovements() {
		return movements;
	}

	public void setMovements(String movements) {
		this.movements = movements;
	}

	public Integer getCargo() {
		return cargo;
	}

	public void setCargo(Integer cargo) {
		this.cargo = cargo;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getIcaoCode() {
		return icaoCode;
	}

	public void setIcaoCode(String icaoCode) {
		this.icaoCode = icaoCode;
	}

	@Override
	public String toString() {
		return "Airport [key=" + key + ", name=" + name + ", localName=" + localName + ", runwayLenght=" + runwayLenght
				+ ", passengers=" + passengers + ", passengersEvolution=" + passengersEvolution + ", movements="
				+ movements + ", cargo=" + cargo + ", position=" + position + ", iataCode=" + iataCode + ", icaoCode="
				+ icaoCode + "]";
	}
	  
	
}
