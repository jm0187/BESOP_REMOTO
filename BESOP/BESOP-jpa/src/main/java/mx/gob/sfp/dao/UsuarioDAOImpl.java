package mx.gob.sfp.dao;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import mx.gob.sfp.entity.Usuario;

@Stateless
public class UsuarioDAOImpl extends GenericDAO<Usuario, Integer> implements
		UsuarioDAO {

	public UsuarioDAOImpl() {
		super(Usuario.class);
	}

	@Override
	public List<Usuario> findAllUsuarios() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario findByUsuario(String usuario) {
		Usuario usr = null;
		Query query = em.createQuery("select u from Usuario u where u.usuario = :usuario");
		query.setParameter("usuario", usuario);
		List<Usuario> resultado = (List<Usuario>) query.getResultList();
		
		if(!resultado.isEmpty()){
			usr = resultado.get(0);
		}
		
		return usr;
	}

}
