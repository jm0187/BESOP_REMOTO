package mx.gob.sfp.besop.service.impl;

import javax.ejb.Stateless;

import mx.gob.sfp.besop.service.HomeServiceLocal;

@Stateless
public class HomeServiceImpl implements HomeServiceLocal {

	@Override
	public String obtenerDatos() {
		return "DATOS OBTENIDOS DE UN EJB";
	}
	
	
}
