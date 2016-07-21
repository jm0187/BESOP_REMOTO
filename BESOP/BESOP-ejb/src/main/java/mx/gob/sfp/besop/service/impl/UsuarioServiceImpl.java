package mx.gob.sfp.besop.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import mx.gob.sfp.besop.service.UsuarioService;
import mx.gob.sfp.dao.UsuarioDAO;
import mx.gob.sfp.entity.Usuario;

@Stateless(name = "ejb/UsuarioServiceImpl", mappedName = "ejb/UsuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService {
	
	@EJB
	private UsuarioDAO usuarioDAO; 

	@Override
	public Usuario getUsuarioByUsuario(String usuario) {
		
		return usuarioDAO.findByUsuario(usuario);
		
	}

}
