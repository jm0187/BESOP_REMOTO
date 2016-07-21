package mx.gob.sfp.besop.support.security;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@EJB(name="customUserDetailsService", beanInterface=CustomUserDetailsService.class)
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static final Logger logger = Logger
			.getLogger(CustomAuthenticationProvider.class);

	private CustomUserDetailsService usuarioService;
	
	private static final String CUSTOM_AUTH_LOOKUP_PATH = "java:comp/env/customUserDetailsService";
	
	private final String PREFIJO_PERFIL = "ROLE_";
//	private final long PREFIJO_NIVEL_ACCESO = 56;
//	private final long PREFIJO_ENTIDAD = 25;
	

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		logger.info("Autenticando Usuario");
		
		String login = authentication.getName();
		String password = authentication.getCredentials().toString();
                UserDetails usuario = null;
		
                try { 
  
                        usuario = getUser(login);
		 
                        if(usuario == null){
                                throw new org.springframework.security.authentication.BadCredentialsException("Error en la autenticación");
                        }
                }catch(org.springframework.security.core.userdetails.UsernameNotFoundException e){
                    logger.info("Usuario no encontrado");
                    throw new org.springframework.security.authentication.BadCredentialsException("Usuario no encontrado");
                } catch (NamingException ex) {
                    logger.info("Sevicio de autenticacion no disponible");
                    throw  new AuthenticationServiceException("Sevicio de autenticacion no disponible");
                } catch (Exception e){
                    logger.info("Ocurrio una excepcion");
                    throw new org.springframework.security.authentication.BadCredentialsException("Error de login");
                }
		 
		 String name = "";//usuario.getNombre() + " " + usuario.getApellido1() + " " +usuario.getApellido2();
		 
		
//		try {
//			logger.info("USUARIO " + login + " usuarioValido: "
//					+ usuarioService.validarUsuario(login, password));
//		} catch (mx.gob.stps.gestion.programas.exception.BadCredentialsException e) {
//			logger.error("error en el servicio de autenticacion");
//			throw new org.springframework.security.authentication.BadCredentialsException(
//					e.getMessage());
//		} catch (mx.gob.stps.gestion.programas.exception.AuthenticationException e) {
//			throw new AuthenticationServiceException(
//					"Sevicio de autenticacion no disponible");
//		}
//
//		String name = usuarioService.getName();
//		
//		Usuario usuario =  usuarioService.getUsuario();
//		Perfil perfil =  usuario.getPerfil();
//		
//		Administrador administrador= usuarioService.getAdministrador(usuario.getIdUsuario());
//		
//		// Obtiene el nivel de acceso de un perfil Nacional, estatal o de oficina
//		CatalogoOpcion nivelAcceso = usuarioService.getNivelAcceso(perfil.getIdPerfil(), this.PREFIJO_NIVEL_ACCESO);
//		
//		// Obtiene la oficina de adscripcion del usuario
//		Oficina oficinaAdscripcion = usuarioService.getOficinaAdscripcion(usuario.getIdUsuario());
//		
//		// Obtiene la entidad de area de adscripcion del usuario
//		CatalogoOpcion entidad = usuarioService.getEntidadOficinaAdscripcion(oficinaAdscripcion.getIdEntidad(), this.PREFIJO_ENTIDAD);
//
//		List<Permiso> permisos = usuarioService.getPermisos(perfil.getIdPerfil());
//		List<Modalidad> modalidades = usuarioService.getModalidades(usuario.getIdUsuario());
//		
//		//
//		//Obtienes las oficinas organizadas por las MODALIDADES que tiene asignadas el usuario
//		//HashMap oficinas = new HashMap();
//		//for(Modalidad modalidad:modalidades) {
//		//	List<Oficina> oficinasModalidad = usuarioService.getOficinasModalidad(usuario.getIdUsuario(), modalidad.getIdModalidad());
//		//	oficinas.put(modalidad.getIdModalidad(), oficinasModalidad);
//		//}
//		//
//		
//		// Obtiene todas las entidades en donde se encuentran las oficinas asignadas a TODAS las modalidades del usuario 
//		//List<CatalogoOpcion> entidades=  usuarioService.getEntidadesOficinasModalidades(usuario.getIdUsuario(), this.PREFIJO_ENTIDAD);
//		
//		logger.info("----------------------------------------------------");
//		logger.info("  Generales ");
//		logger.info("----------------------------------------------------");
//		logger.info("     Usuario: " + usuario.getIdUsuario() + " " + usuario.getUsuario());
//		logger.info("      Perfil: " + perfil.getIdPerfil() + " " + perfil.getDescripcion());
//		logger.info("Admin (CURP): " + administrador.getCurp());
//		logger.info("Nivel acceso: " + nivelAcceso.getIdCatalogoOpcion() + " " + nivelAcceso.getOpcion());
//		logger.info("     Entidad: " + entidad.getIdCatalogoOpcion() + " " + entidad.getOpcion());
//		
//		logger.info("----------------------------------------------------");
//		logger.info(" Area de adscripcion ");
//		logger.info("----------------------------------------------------");
//		logger.info("\t" + oficinaAdscripcion.getIdOficina() + " " + oficinaAdscripcion.getDescripcion());
//
//		
//		if(modalidades != null ) {
//			logger.info("----------------------------------------------------");
//			logger.info(" Modalidades ");
//			logger.info("----------------------------------------------------");
//			for(Modalidad modalidad:modalidades) {
//				logger.info("\t" + modalidad.getIdModalidad() + " " + modalidad.getNombre());	
//			}
//		}
//
//		
//		if(permisos != null ) {
//			logger.info("----------------------------------------------------");
//			logger.info(" Permisos ");
//			logger.info("----------------------------------------------------");
//			for(Permiso permiso:permisos) {
//				logger.info("\t"  + permiso.getIdPermiso() + " " + permiso.getDescripcion());	
//			}
//		}
//		
//		// Construye objeto GrantedAuthority para agregarlo a spring security 
//		List<GrantedAuthority> grantedAuths = getAutorities(perfil.getNombre());
//		
		 
		List<GrantedAuthority> grantedAuths = getAutorities("ADMINISTRADOR");
		UserSecurity userSecurity = new UserSecurity(login, password, name,	grantedAuths, true, true, true, true);
//		userSecurity.setUsuario(usuario);
		userSecurity.setPermisos(getContext().getPermisos(login));
		logger.info("Usuario: " + usuario.getUsername());
		return new UsernamePasswordAuthenticationToken(userSecurity, password, grantedAuths);
		
	}
	
	private UserDetails getUser(String username) throws NamingException{
//                InitialContext initialContext = new InitialContext();
//                usuarioService = (CustomUserDetailsService) initialContext.lookup(CUSTOM_AUTH_LOOKUP_PATH);
//                return usuarioService.loadUserByUsername(username);
                return getContext().loadUserByUsername(username);
	}
	
	private CustomUserDetailsService getContext(){
		try{
			InitialContext initialContext = new InitialContext();
			usuarioService = (CustomUserDetailsService) initialContext.lookup(CUSTOM_AUTH_LOOKUP_PATH);
			return usuarioService;
		}catch (NamingException ex) {
			logger.error("No se encontro el recurso");
                }
                return null;
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	/**
	 * Metodo que genera la lista de grantedAuthority por medio de las urls que
	 * tiene acceso el usuario
	 * 
	 * @param List
	 *            <String> urls la lista de urls a la que tiene acceso el
	 *            usuario logeado
	 * @return List<GrantedAuthority> Autorities a las que tiene acceso el
	 *         usuario logeado
	 */
	private List<GrantedAuthority> getAutorities(String perfil) {
		ArrayList<GrantedAuthority> autorities = new ArrayList<GrantedAuthority>(); 
		autorities.add(new AuthoritySecurity(this.PREFIJO_PERFIL + perfil)); 
		
		return autorities;
	}

//	public UsuarioService getUsuarioService() {
//		return usuarioService;
//	}
//
//	public void setUsuarioService(UsuarioService usuarioService) {
//		this.usuarioService = usuarioService;
//	}
	
	public CustomUserDetailsService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(CustomUserDetailsService usuarioService) {
		this.usuarioService = usuarioService;
	}
}
