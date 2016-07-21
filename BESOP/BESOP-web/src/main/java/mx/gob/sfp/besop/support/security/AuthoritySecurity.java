package mx.gob.sfp.besop.support.security;

import org.springframework.security.core.GrantedAuthority;
/**
 * 
 * @author Jose Luis Mendez Santos
 * @since  13/09/2014
 * @version 
 *<p> Descripción: La clase {@code AuthoritySecurity } implementa <{@link  GrantedAuthority}> la cúal se utiliza 
 * la creación de un objeto que contiene las urls a las que tiene acceso un usuario de acuerdo a su perfil. </p>
 */
public class AuthoritySecurity implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	private String authority;
	
	public AuthoritySecurity(String authority) {
		super();
		this.setAuthority(authority);
	
	}

	/**
	 * @return authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * @param authority para establecer authority
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}


}
