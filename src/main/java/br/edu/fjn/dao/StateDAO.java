package br.edu.fjn.dao;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.dao.util.Factory;
import br.edu.fjn.dao.util.OrmException;
import br.edu.fjn.model.State;

public class StateDAO {
	
	
	public void save(State state) throws OrmException {
			
			EntityManager em = Factory.getFactory();
			em.getTransaction().begin();
			
			try {
				
				em.persist(state);
				em.getTransaction().commit();
			} catch (Exception e) {
				
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
					throw new OrmException("Ocorreu um erro interno!");
			}
				
			} finally {
				
					em.close();
			}
	}
	
	public void update(State state) throws OrmException {
		
		EntityManager em = Factory.getFactory();
		em.getTransaction().begin();
		
		try {
			
			em.merge(state);
			em.getTransaction().commit();
		} catch (Exception e) {
			
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				throw new OrmException("Ocorreu um erro interno!");
		}
				
		} finally {
			
				em.close();
		}
	}
	
	public State findById(Integer id) {
		EntityManager em = Factory.getFactory();
		State state = em.find(State.class, id);
		em.close();
		return state;
	}
	
	public void remove(Integer id) throws OrmException {
		EntityManager em = Factory.getFactory();
		em.getTransaction().begin();
		State state = findById(id);
		
		try {
			
			em.remove(state);
			em.getTransaction().commit();
		} catch (Exception e) {
			
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				throw new OrmException("Ocorreu um erro interno!");
			}
				
		} finally {
			
				em.close();
			}
	}
	
	public State findByUf(String uf) {
		EntityManager em = Factory.getFactory();
		Session session = (Session) em.getDelegate();
		Criteria criteria = session.createCriteria(State.class);
		criteria.add(Restrictions.ilike("uf", uf, MatchMode.EXACT));
		State state = (State) criteria.uniqueResult();
		em.close();
		return state;
	}
}
