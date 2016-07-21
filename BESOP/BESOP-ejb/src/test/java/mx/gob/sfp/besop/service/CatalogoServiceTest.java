/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.sfp.besop.service;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;

import mx.gob.sfp.entity.Catalogo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author martin.martinez
 */
public class CatalogoServiceTest {
    
    private CatalogoService ejb;

    @Before
    public void iniciarContenedor() throws Exception {
        System.out.println("Iniciando la pruebas de CatalogoServiceTest...");
        EJBContainer contenedor = EJBContainer.createEJBContainer();
        System.out.println("Contenedor de EJBs inicializado");
        ejb = (CatalogoService) contenedor.getContext().lookup("java:global/ejb-app/classesejb/CatalogoServiceImpl!mx.gob.sfp.besop.service.CatalogoService");
        System.out.println("Recurso CatalogoService encontrado");
    }

    @Test
    public void test() throws Exception {
        assertTrue(ejb != null);
        List<Catalogo> catalogos = ejb.getById(1);
        assertNotNull(catalogos);
        System.out.println("Operación terminada, resultado:" + catalogos);
    }
}
