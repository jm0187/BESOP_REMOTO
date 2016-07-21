/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.sfp.besop.service.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.gob.sfp.besop.service.CatalogoService;
import mx.gob.sfp.dao.CatalogoDAO;
import mx.gob.sfp.dao.CatalogoDAOImpl;
import mx.gob.sfp.entity.Catalogo;

/**
 *
 * @author martin.martinez
 */
@Stateless
public class CatalogoServiceImpl implements CatalogoService{
    
    @EJB
    private CatalogoDAO catalogoDAO;
    
    @Override
    public List<Catalogo> getById(int idCatalogo) {
        return catalogoDAO.getById(idCatalogo);
    }
    
}
