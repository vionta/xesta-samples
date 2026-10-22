package net.vionta.xml.xesta.test.cases.http.dbpedia;

import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.slf4j.Logger;
import org.xml.sax.SAXException;

import net.vionta.xml.xesta.repository.exception.PersistException;
import net.vionta.xml.xesta.repository.impl.HttpRepository;
import net.vionta.xml.xesta.test.cases.http.dbpedia.beans.Airport;

public class AirportQuery {

	static Logger log  = getLogger(AirportQuery.class);

	@Test
	public void test() throws PersistException, IOException, SAXException, ParserConfigurationException {
	
		// We use the Http remote repository
		HttpRepository repo = new HttpRepository();
		//The document part of the route will be updated with 
		//the location code from the provided Bin
		repo.setDocumentPath("https://dbpedia.org/data/{key}.rdf");
		Airport testAirport = new Airport();
		
		//We set the location to the Vigo Peinador Airport.
		testAirport.setKey("Vigo–Peinador_Airport");
		
		//Retrieve the weather info
		testAirport = repo.load(testAirport);
		
		log.debug("Gotted airport data:");
		log.debug(testAirport.toString());

		assert("Vigo–Peinador Airport".equals(testAirport.getName()));
		assert("VGO".equals(testAirport.getIataCode()));
		
	}
}
