/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.sfp.besop.service;

import java.util.List;
import javax.ejb.Local;
import mx.gob.sfp.entity.Catalogo;

/**
 *
 * @author martin.martinez
 */
@Local
public interface CatalogoService {
    public List<Catalogo> getById(int idCatalogo);
}
