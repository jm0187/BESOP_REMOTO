package mx.gob.sfp.besop.test.core;

import java.io.File;
import mx.gob.sfp.besop.service.CatalogoService;
import mx.gob.sfp.besop.service.CatalogoServiceTest;

//import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
//import org.jboss.shrinkwrap.resolver.api.maven.Maven;
/**
 * Clase abstracta para integrar pruebas unitarias 
 * con integracion de arquillian, la finalidad es crear
 * un unico micro despliegue en el servidor de aplicaciones. 
 *
 */
//@ArquillianSuiteDeployment
public class AbstractTest {

	public static boolean setUpIsDone = false;
	
	/**
	 * Metodo para generar un peque�o micro despligue, 
	 * toma las dependencias administradas por maven para generar
	 * un JAR, con el codigo necesario para ser probado
	 * @return archivo que contiene toda la informaci�n para realizar el despligue correcto. 
	 */
//	@Deployment(name="test", testable=true, order=1)
//	public static Archive<?> deploy() {
//		File[] files = Maven.resolver().loadPomFromFile("pom.xml")
//				.importRuntimeDependencies().resolve().withTransitivity()
//				.asFile();

		
//		WebArchive archive = ShrinkWrap
//				.create(WebArchive.class, "test.war")
//                                .addClasses(CatalogoService.class).addClasses(CatalogoServiceTest.class)
//				.addPackages(true, "mx.gob.sfp")
//				.addAsResource("META-INF/persistence.xml")
//				.addAsWebInfResource(EmptyAsset.INSTANCE,
//						ArchivePaths.create("beans.xml"));
//		for (File file : files) {
//			if (!file.getName().contains("BESOP")){
//				archive.addAsLibrary(file);
//                                System.out.println(file.getName());
//                        }
//		}
//		return archive;
//	}
	
}
