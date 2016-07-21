package mx.gob.sfp.dao;


import java.util.List;

import mx.gob.sfp.entity.Usuario;

public interface UsuarioDAO {
	public List<Usuario> findAllUsuarios();
	public Usuario findByUsuario(String usuario);
}
