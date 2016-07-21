/*
 * Nombre de la interfaz:  Direccionador.java
 *
 * Informacion de la version: 1.0
 *
 * Fecha: 29/10/2015
 *
 * Copyright: David Garcia
 */
package mx.gob.sfp.besop.core;

import  static mx.gob.sfp.SystemEnum.*;

import java.util.Properties;

import mx.gob.sfp.ConstantesGenerales;


/**
 * @author David Garcia
 * Contiene las URL de los componentes de Gestion de Programas
 */
public interface Direccionador {
	Properties properties = new PropertiesLoader().getProperties(ConstantesGenerales.PROPERTIES_URLS);
	
	/* ****************************** DIRECCIONES DE LAS VISTAS WEB DE GESTION DE PROGRAMAS ********************************* */
	public final String URL_HOME_INICIO = properties.getProperty(SYSTEM_URLS.PAGINA1.getDescripcion());
	
}
