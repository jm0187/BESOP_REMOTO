package mx.gob.sfp.dao;



import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;


public class GenericDAO<T, PK extends Serializable> {
	
	@PersistenceContext(unitName="GestionPU")
	protected EntityManager em;
	
	private Class<T> entityClass;
	/**
	 * 
	 * Constructor de la clase GenericDAO
	 * @param entityClass
	 */
	public GenericDAO(Class<T> entityClass) {
		
		this.entityClass = entityClass;
	}

	@PostConstruct
	public void init(){
	}
	
	/**
	 * 
	 *@param entity
	 *void
	 *Método que guarda un registro dentro de la BD
	 */
	public void save(T entity) {
		em.persist(entity);
	}

	/**
	 * 
	 *@param entity
	 *@return T
	 *Método que guarda un registro dentro de la BD
	 */
	public T registrar(T entity) {
		em.persist(entity);
		return entity;
	}

	
	/**
	 * 
	 *@param entity
	 *void
	 *Método que elimina un registro dentro de la BD
	 */
	public void delete(T entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	/**
	 * 
	 *@param entity
	 *@return T
	 *Método que actualiza un registro dentro de la BD
	 */
	public T update(T entity) {
		return em.merge(entity);
	}

	/**
	 * 
	 *@param entityID
	 *@return T
	 *Método que busca y devuelve un registro dentro de la BD
	 */
	public T find(PK entityID) {
		return em.find(entityClass, entityID);
	}

	/**
	 * 
	 *@return List<T>
	 *Método que obtiene todos los registros de una tabla 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}
	

	/**
	 * 
	 *@param namedQuery
	 *@param parameters
	 *@return T
	 *Método que obtiene un registro 
	 *por nombre de entidad y parametros
	 */
	@SuppressWarnings("unchecked")
	protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
		T result = null;
		try {
			Query query = em.createNamedQuery(namedQuery);
			// Method that will populate parameters if they are passed not null and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			result = (T) query.getSingleResult();
		} catch (Exception e) {
//			logger.debug("Error al ejecutar consulta");
		}
		return result;
	}
	
	
	
	/**
	 * 
	 *@return List<T>
	 *Método que obtiene una lista de resultado de una tabla 
	 */
	@SuppressWarnings({ "unchecked" })
	public List<T> findListResultNative(String nativeQuery, Map<String, Object> parameters) {
		try {
			Query query = em.createNativeQuery(nativeQuery, entityClass);

			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			
			return query.getResultList();
		} catch (Exception e) {
//			logger.fatal("Error al ejecutar consulta", e);
		}

		return null;
	}
	
	
	@SuppressWarnings({ "unchecked" })
	public T findOneResultNative(String nativeQuery, Map<String, Object> parameters) {
		List<T> results = null;
		try {
			Query query = em.createNativeQuery(nativeQuery, entityClass);

			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			
			results = query.getResultList();
			if(!results.isEmpty()){
				return results.get(0);
			}
		} catch (Exception e) {
//			logger.fatal("Error al ejecutar consulta", e);
		}
		
		return null;
	}
	
	/**
	 * 
	 *@return List<T>
	 *Método que obtiene una lista de resultado de una tabla 
	 */
	@SuppressWarnings({ "unchecked" })
	public List<T> findListResult(String namedQuery, Map<String, Object> parameters) {
		
		try {
			Query query = em.createNamedQuery(namedQuery, entityClass);

			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			
			return query.getResultList();
		} catch (Exception e) {
//			logger.fatal("Error al ejecutar consulta", e);
		}

		return null;
	}

	
	/**
	 * 
	 *@param query
	 *@param parameters
	 *void
	 *Método que asigna parametros a la query
	 */
	protected void populateQueryParameters(Query query, Map<String, Object> parameters) {
		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}
	
	
	/**
	 * 
	 *@param query
	 *@param parameters
	 *void
	 *Método que asigna parametros a la query
	 */
	protected void populateNativeQueryParameters(Query query, Map<Integer, Object> parameters) {
		for (Entry<Integer, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}
	
	/**
	 * 
	 * @param query
	 * @param parameters
	 * void
	 * Metodo encargado de obtener el manejador de entidades
	 */
	public EntityManager getEntityManager() {
		return em;
	}
}