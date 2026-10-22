package net.vionta.xml.xesta.test.cases.http.weather;

import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.slf4j.Logger;
import org.xml.sax.SAXException;

import net.vionta.xml.xesta.repository.exception.PersistException;
import net.vionta.xml.xesta.repository.impl.ClassPathRepository;
import net.vionta.xml.xesta.repository.impl.HttpRepository;
import net.vionta.xml.xesta.test.cases.http.weather.beans.WeatherLocation;

/**
 * This case checks the weather status for a location from the 
 * Spanish AEMET public weather location.
 */
public class WeatherServiceTest {

	static Logger log  = getLogger(WeatherServiceTest.class);

	@Test
	public void test() throws PersistException, IOException, SAXException, ParserConfigurationException {
	
		// We use the Http remote repository
		HttpRepository repo = new HttpRepository();
		repo.setBasePath("https://www.aemet.es/xml/municipios/"	);
		//The document part of the route will be updated with 
		//the location code from the provided Bin
		repo.setDocumentPath("localidad_{locationCode}.xml");
		WeatherLocation weatherLocation = new WeatherLocation();
		//We set the location to the Vigo Id.
		weatherLocation.setLocationCode("36057");
		//Retrieve the weather info
		weatherLocation = repo.load(weatherLocation);
		
		log.debug("Gotted weather :");
		log.debug(weatherLocation.toString());
		log.debug("Days");
		for (Iterator iterator = weatherLocation.getNextDays().iterator(); iterator.hasNext();) {
			log.debug(" | " + iterator.next());
		}
		assert("Vigo".equals(weatherLocation.getLocationName()));
		assert(weatherLocation.getNextDays().size()>1);

	}
}
