package mx.gob.sfp.besop.service;

import javax.ejb.Local;

@Local
public interface HomeServiceLocal {
	public String obtenerDatos();
}
