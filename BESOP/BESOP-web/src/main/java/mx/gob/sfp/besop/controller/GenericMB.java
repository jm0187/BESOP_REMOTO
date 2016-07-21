package mx.gob.sfp.besop.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mx.gob.sfp.besop.support.security.UserSecurity;

import org.springframework.security.core.context.SecurityContextHolder;

public abstract class GenericMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected ExternalContext getContext() {
        return FacesContext.getCurrentInstance().getExternalContext();
    }
	
	protected UserSecurity getUserSecurity() {
		return (UserSecurity) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
	}

//    protected HttpServletResponse getResponse() {
//        return (HttpServletResponse) getContext().getResponse();
//    }
    
    protected HttpServletRequest getRequest() {
        return (HttpServletRequest) getContext().getRequest();
    }

    protected HttpSession getSession() {
        return (HttpSession) (getContext().getSession(true));
    }

//	 protected ServletContext getServletContext() {
//    	return (ServletContext)getContext().getContext();
//    }

    protected void redirect(String url) throws ServletException, IOException {
        getContext().redirect(url);
    }

//    protected String getContextPath() throws ServletException, IOException {
//        return getContext().getRequestContextPath();
//    }
//	
//    protected Object getSessionMapObject(String name) {
//        return getSessionMap().get(name);
//    }

    protected Map<String, Object> getSessionMap() {
        return getContext().getSessionMap();
    }

    protected Object getValueFromSessionMap(String key) {
        return getSessionMap().get(key);
    }

    protected void setValueToSessionMap(String key, Object obj) {
        getSessionMap().put(key, obj);
    }

    protected String getParameter(String name) {
        Map<String, String> requestMap = getContext().getRequestParameterMap();
        return requestMap.get(name);
    }

    protected void removeSessionMB(String MB) {
        getContext().getSessionMap().remove(MB);
    }

    protected void addInfoMessage(String msg) {
        addMessage(FacesMessage.SEVERITY_INFO,msg,null);
    }

    protected void addWarningMessage(String msg) {
        addMessage(FacesMessage.SEVERITY_WARN,msg, null);
    }
    
    protected void addErrorMessage(String msg) {
    	addMessage(FacesMessage.SEVERITY_ERROR,msg,null);
    }
    
    protected void addFatalMessage(String msg) {
        addMessage(FacesMessage.SEVERITY_FATAL,msg,null);
    }
    
    protected void addInfoMessage(String title, String summary) {
        addMessage(FacesMessage.SEVERITY_INFO, title, summary);
    }

    protected void addWarningMessage(String title, String summary) {
        addMessage(FacesMessage.SEVERITY_WARN, title, summary);
    }

    protected void addErrorMessage(String title, String summary) {
        addMessage(FacesMessage.SEVERITY_ERROR, title, summary);
    }

    protected void addFatalMessage(String title, String summary) {
        addMessage(FacesMessage.SEVERITY_FATAL, title, summary);
    }

    protected void addInfoMessage(UIComponent component, String title, String summary) {
        addMessage(component, FacesMessage.SEVERITY_INFO, title, summary);
    }

    protected void addWarningMessage(UIComponent component, String title, String summary) {
        addMessage(component, FacesMessage.SEVERITY_WARN, title, summary);
    }

    protected void addErrorMessage(UIComponent component, String title, String summary) {
        addMessage(component, FacesMessage.SEVERITY_ERROR, title, summary);
    }

    protected void addFatalMessage(UIComponent component, String title, String summary) {
        addMessage(component, FacesMessage.SEVERITY_FATAL, title, summary);
    }

    protected void addMessageErrorComponent(String idComponent, String title) {
    	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, null);
    	FacesContext.getCurrentInstance().addMessage(idComponent, msg);
    }
    
    protected void addMessage(FacesMessage.Severity severity, String title, String summary) {
    	FacesMessage msg = new FacesMessage(severity, title, summary);
    	addMessage(msg);
    }

    protected void addMessage(FacesMessage facesMessage) {
//    	getContext().getFlash().setKeepMessages(true);
    	FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    
    protected void addMessage(UIComponent component, FacesMessage.Severity severity, String title, String summary) {
//    	getContext().getFlash().setKeepMessages(true);
    	FacesMessage facesMessage = new FacesMessage(severity, title, summary);    	
    	FacesContext.getCurrentInstance().addMessage(component.getClientId(FacesContext.getCurrentInstance()), facesMessage);
    }
    
//    protected boolean poseePermiso(String descripcion) {
//    	for(Permiso permiso:getUserSecurity().getPermisos()) {
//    		if(permiso.getDescripcion().equals(permiso)) {
//    			return true;
//    		}
//    	}
//    	
//    	return false;
//    }
//    
//    protected boolean poseePermiso(long idPermiso) {
//    	for(Permiso permiso:getUserSecurity().getPermisos()) {
//    		if(permiso.getIdPermiso() == idPermiso) {
//    			return true;
//    		}
//    	}
//    	
//    	return false;
//    }

}
