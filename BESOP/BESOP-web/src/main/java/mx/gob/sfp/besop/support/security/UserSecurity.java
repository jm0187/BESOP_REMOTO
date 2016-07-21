package mx.gob.sfp.besop.support.security;

import java.util.Collection;
import java.util.List;

import mx.gob.sfp.entity.Usuario;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSecurity implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String name;
	private List<GrantedAuthority> authorities;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	private Usuario usuario;
	private List<String> permisos;
//	private Perfil perfil;
//	private Administrador administrador;
//	private List<Permiso> permisos;
//	private HashMap oficinas;
//	private CatalogoOpcion nivelAcceso;
//	private CatalogoOpcion entidad;
//	private List<Modalidad> modalidades;
//	private Oficina adscripcion;
	
	
	
	public UserSecurity(){}
	
	public UserSecurity(String username, String password, String name,
			List<GrantedAuthority> authorities, boolean accountNonExpired,
			boolean accountNonLocked, boolean credentialsNonExpired,
			boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.authorities = authorities;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}
	
	
	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<String> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<String> permisos) {
		this.permisos = permisos;
	}
}
