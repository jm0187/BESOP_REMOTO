package mx.gob.sfp.besop.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import mx.gob.sfp.besop.service.CatalogoService;

import mx.gob.sfp.besop.service.HomeServiceLocal;
import mx.gob.sfp.entity.Catalogo;
import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
public class HomeMB extends GenericMB {
	
	private static final long serialVersionUID = 1L;
        private static Logger log = Logger.getLogger(HomeMB.class);
	
	@EJB
	private HomeServiceLocal homeServiceLocal;
        
        @EJB
        private CatalogoService catalogoService;
	
	private String datos;
        private List<Catalogo> catalogos;
	
	@PostConstruct
	private void init(){
                log.info("Inicializando HomeMB...");
		datos = "Bienvenido al SISTEMA BESOP";
                catalogos = catalogoService.getById(1);
                log.info(catalogos);
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

        public List<Catalogo> getCatalogos() {
            return catalogos;
        }

        public void setCatalogos(List<Catalogo> catalogos) {
            this.catalogos = catalogos;
        }
}
