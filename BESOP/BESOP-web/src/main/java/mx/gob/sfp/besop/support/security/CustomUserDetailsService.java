package mx.gob.sfp.besop.support.security;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import mx.gob.sfp.dao.UsuarioDAO;
import mx.gob.sfp.entity.Usuario;

@Local
@Stateless
@LocalBean
public class CustomUserDetailsService implements UserDetailsService{
	

	@EJB
	private UsuarioDAO usuarioDAO;

	@Override
	public UserDetails loadUserByUsername(String username) {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		Usuario usuario = usuarioDAO.findByUsuario(username);
		
		if(usuario != null){
			authorities.add(new SimpleGrantedAuthority("ROL_OFICINA"));
			User user = new User(usuario.getUsuario(), usuario.getContrasena(), authorities);
			return user;
		}else{
                        
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
	}
	
	
	public List<String> getPermisos(String username){
		
		List<String> permisos = new ArrayList<>();
		permisos.add("Puede Modificar");
		permisos.add("Puede Actualizar");
		permisos.add("Puede Inserar");
		
		return permisos;
		
	}

}
