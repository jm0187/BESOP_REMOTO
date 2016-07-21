package mx.gob.sfp.besop.support;

import javax.servlet.ServletContextEvent;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

/**
 * Clase de soporte para cargar el ApplicationContext de Spring al momento de iniciar la aplicación
 * 
 * 
 */
public class ProxyContextLoaderListener extends ContextLoaderListener {
	private static Logger log = Logger.getLogger(ProxyContextLoaderListener.class);
	private static WebApplicationContext ctx;

	/**
	 * @see ContextLoaderListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		log.info("Loading application context.........");
		ctx = ContextLoader.getCurrentWebApplicationContext();
	}

	/**
	 * @see ContextLoaderListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		ctx = null;
	}

	/**
	 * Método que proporciona acceso al WebApplicationContext
	 * 
	 * @return ApplicationContext de Spring
	 */
	public static WebApplicationContext getContext() {
		return ctx;
	}
}
