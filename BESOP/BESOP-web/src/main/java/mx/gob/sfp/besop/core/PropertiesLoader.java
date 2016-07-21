package mx.gob.sfp.besop.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import mx.gob.sfp.ConstantesGenerales;

public class PropertiesLoader {
	
//	@Inject
//	Logger logger;
	
	public Properties getProperties(String path){
		Properties properties = new Properties();
		try {
			InputStream in = this.getClass().getClassLoader().getResourceAsStream(ConstantesGenerales.PROPERTIES_URLS);
			properties.load(in);
		} catch (IOException e) {
//			logger.error("Error al cargar archivo properties con las URL's", e);
		}
		return properties;
	}

}
