/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.sfp.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mx.gob.sfp.entity.Catalogo;

/**
 *
 * @author martin.martinez
 */
@Stateless
public class CatalogoDAOImpl extends GenericDAO<Catalogo,Integer> implements CatalogoDAO {

    public CatalogoDAOImpl() {
        super(Catalogo.class);
    }

    @Override
    public List<Catalogo> getAll() {
        return null;
    }
    
    //USO DE CRITERIA
//    @Override
//    public List<Catalogo> getById(int idCatalogo) {
//       CriteriaBuilder cb = em.getCriteriaBuilder();
//       CriteriaQuery<Catalogo> criteriaQuery = cb.createQuery(Catalogo.class);
//       Root<Catalogo> from = criteriaQuery.from(Catalogo.class);
//       criteriaQuery.select(from).where(cb.equal(from.get("idCatalogo"), idCatalogo));
//       TypedQuery<Catalogo> query = em.createQuery(criteriaQuery);
//
//       List<Catalogo> ciudades = query.getResultList();
//       return ciudades;
//    }
    
//    //USO DE QUERY
    public List<Catalogo> getById(int idCatalogo) {
        String jpql = "select c from Catalogo c where c.idCatalogo = :id";
        Query q = em.createQuery(jpql);
        q.setParameter("id", idCatalogo);
        return (List<Catalogo>) q.getResultList();
    }
//    
//    //USO DE NAMED QUERY
//    public List<Catalogo> getById(int idCatalogo) {
//        String jpql = "Catalogo.findById";
//        Query q = em.createNamedQuery(jpql);
//        q.setParameter("idCatalogo", idCatalogo);
//        return (List<Catalogo>) q.getResultList();
//    }
//    
//    //USO DE NATIVE QUERY
//    public List<Catalogo> getById(int idCatalogo) {
//        StringBuilder sb = new StringBuilder();
//        List<Catalogo> result = new ArrayList<Catalogo>();
//        sb.append(" SELECT ");
//        sb.append(" ID_CATALOGO, ");  
//        sb.append(" ID_TIPO_CATALOGO, ");
//        sb.append(" DESCRIPCION_CORTA, "); 
//        sb.append(" DESCRIPCION_LARGA,  ");
//        sb.append(" FECHA_ALTA,  ");       
//        sb.append(" ESTATUS,  ");          
//        sb.append(" FECHA_MODIFICACION ");
//        sb.append(" FROM CATALOGO WHERE ID_CATALOGO = " + idCatalogo);
//        
//
//        Query q = em.createNativeQuery(sb.toString(), "resultCatalogos");
//        //q.setParameter(1, idCatalogo);
//        result = (List<Catalogo>) q.getResultList();
//        return result;
//    }
    
}
