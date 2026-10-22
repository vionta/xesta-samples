package net.vionta.xml.xesta.test;

public class CommonTest {

	// Please adjust the route 
	private static String basePath ="C:/Users/jorge/dev/ws/xml-binding/fento-samples/fento-opendocument-cases/src/test/resources/";
	private static String outputPath ="target/test-classes/";
	
	/**
	 * Utility method to provide the 
	 * adjusted test path.
	 * @return
	 */
	public static String getBasePath() {
		//		URL url = ResourceLoader.class.getClassLoader().getResource(".");
		//		System.out.println("To  "+url);
		//		String urlBase = url.toString().replace("target/test-classes/", basePath);
		//		
		//		return urlBase;
		return basePath;
	}
	/**
	 * Utility method to provide the 
	 * adjusted test path.
	 * @return
	 */
	public static String getOutputPath() {
		return outputPath;
	}
	
}
