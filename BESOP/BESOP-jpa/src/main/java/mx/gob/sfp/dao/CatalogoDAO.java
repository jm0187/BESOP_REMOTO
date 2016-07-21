/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.sfp.dao;

import java.util.List;
import mx.gob.sfp.entity.Catalogo;

/**
 *
 * @author martin.martinez
 */
public interface CatalogoDAO {
    public List<Catalogo> getAll();
    public List<Catalogo> getById(int idCatalogo);
}
