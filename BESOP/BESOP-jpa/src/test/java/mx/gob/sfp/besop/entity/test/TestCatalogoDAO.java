package mx.gob.sfp.besop.entity.test;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import mx.gob.sfp.dao.CatalogoDAO;
import mx.gob.sfp.entity.Catalogo;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author martin.martinez
 */
public class TestCatalogoDAO {

    private static EJBContainer contenedor;
    private static Context contexto;
    private static CatalogoDAO ejb;

    @Before
    public void iniciarContenedor() throws Exception {
        System.out.println("Iniciando la pruebas de TestCatalogoDAO...");
        contenedor = EJBContainer.createEJBContainer();
        System.out.println("Contenedor de EJBs inicializado");
        contexto = contenedor.getContext();
        System.out.println("Contexto del contenedor obtenido satisfactoriamente");
        ejb = (CatalogoDAO) contexto.lookup("java:global/classes/CatalogoDAOImpl!mx.gob.sfp.dao.CatalogoDAO");
        System.out.println("Recurso CatalogoDAO encontrado");
    }

    @Test
    public void test() throws Exception {
        List<Catalogo> catalogos = ejb.getById(1);
        assertNotNull(catalogos);
        System.out.println("Operación terminada, resultado:" + catalogos);
    }
}
