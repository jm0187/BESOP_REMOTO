package mx.gob.sfp.besop.service;


import javax.ejb.Local;
import javax.ejb.Remote;

import mx.gob.sfp.entity.Usuario;

@Local
@Remote
public interface UsuarioService {
	
	Usuario getUsuarioByUsuario(String usuario);
	
}
