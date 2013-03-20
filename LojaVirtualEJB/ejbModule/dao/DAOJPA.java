package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class DAOJPA<T> implements DAOInterface<T> {
	
	public DAOJPA() {
		super();
	}
	
	@PersistenceContext(unitName = "LojaVirtual")
	private EntityManager manager;


	public void persist(T obj) {
		manager.persist(obj);
	}
	
	public void remove(T obj) {
		manager.remove(obj);
	}
	
	public T merge(T obj) {
		return manager.merge(obj);
	}
	
	public void refresh(T obj) {
		manager.refresh(obj);
	}
	
	public void flush() {
		manager.flush();
	}
	
	@SuppressWarnings("unchecked")
	public T find(Object chave) {
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
		return manager.find(type, chave);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
		Query query = manager.createQuery("select x from " + type.getSimpleName() + " x");
		return (List<T>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByField(String campo, String valor) {
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
		Query query = manager.createQuery("select x from " + type.getSimpleName() + " x " +
				"where x.” +campo+ ” = \"" +valor+ "\"");
		return (List<T>) query.getResultList();
	}
	
	public void close(){
		if(manager.isOpen())
			manager = null;
	}

	public void begin(){
		if(!manager.getTransaction().isActive())
			manager.getTransaction().begin();
	}
	public void commit(){
		if(manager.getTransaction().isActive())
		manager.getTransaction().commit();
	}
	public void rollback(){
		if(manager.getTransaction().isActive())
		manager.getTransaction().rollback();
	}
	
	//----------------------- JPQL ----------------------
	public  Object findByQuery(String consultaJPQL){		
		try{
			Query q = manager.createQuery(consultaJPQL);
			return (Object) q.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
		catch(NonUniqueResultException e){
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	public  List findAllByQuery(String consulta){		
		try{
			Query q = manager.createQuery(consulta);
			return q.getResultList();
		}
		catch(NoResultException e){
			return null;
		}
		catch(NonUniqueResultException e){
			return null;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public  List findAllByQuery(String consulta,int limit){		
		try{     
			Query q = manager.createQuery(consulta);
			return q.setMaxResults(limit).getResultList();
		}
		catch(NoResultException e){
			return null;
		}
		catch(NonUniqueResultException e){
			return null;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public  List findAllByQuery(String consulta,int offset,int limit){		
		try{
			Query q = manager.createQuery(consulta);
			return q.setFirstResult(offset).setMaxResults(limit).getResultList();
		}
		catch(NoResultException e){
			return null;
		}
		catch(NonUniqueResultException e){
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	public  List findAgregateByQuery(String consulta){
		Query q = manager.createQuery(consulta);
		return q.getResultList();
	}
		
	public int updadeAll(String consulta) {
		Query q = manager.createQuery(consulta);
		int linhas = q.executeUpdate();
		return linhas;
	}
	
}

