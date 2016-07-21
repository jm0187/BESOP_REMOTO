package mx.gob.sfp.besop.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.log4j.Logger;

import mx.gob.sfp.besop.service.UsuarioService;
import mx.gob.sfp.entity.Usuario;

@ManagedBean
@SessionScoped
public class PruebaMB extends GenericMB  implements PhaseListener{
	
	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioService usuarioService;
	
	private Logger logger = Logger.getLogger(PruebaMB.class);
	
	@PostConstruct
	public void init(){
		
	}
	
	public void ejecutar(){
	  Usuario usuario = usuarioService.getUsuarioByUsuario("patricia.vazquez@infotec.mx");
	  
	  logger.info(usuario);
	}

	@Override
	public void afterPhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return null;
	}

}
