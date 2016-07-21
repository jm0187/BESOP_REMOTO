package mx.gob.sfp.besop.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;

/**
 * MB encargado de controlar el acceso a los usuarios
 * @author martin.martinez
 */
@ManagedBean
@SessionScoped
public class LoginMB extends GenericMB  implements PhaseListener {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(LoginMB.class);
	
	private String user;
	private String pass;
	
	@PostConstruct
	public void init() {
		logger.info("Inicializando LoginMB");
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/**
	 *
	 * Redirecciona la peticion a spring security para que ejecute la validacion
	 * correspondiente
	 * 
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login() throws ServletException, IOException {
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();

		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
				.getRequestDispatcher("/login");

		dispatcher.forward((ServletRequest) context.getRequest(),
				(ServletResponse) context.getResponse());

		FacesContext.getCurrentInstance().responseComplete();
	}

	@Override
	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Sobreescritura del método para recuperar el o los mensajes de error de
	 * spring security
	 */
	@Override
	public void beforePhase(PhaseEvent arg0) {
		Exception e = (Exception) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap()
				.get(WebAttributes.AUTHENTICATION_EXCEPTION);
		
		if (e instanceof AuthenticationException) {
			logger.debug("Found exception in session map: " + e);

			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap()
					.put(WebAttributes.AUTHENTICATION_EXCEPTION, null);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e
							.getMessage(), e.getMessage()));

		}

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

	public String getName() {
		return getUserSecurity().getName();
	}

	public String getUserName() {
		return getUserSecurity().getUsername();

	}
	
}
