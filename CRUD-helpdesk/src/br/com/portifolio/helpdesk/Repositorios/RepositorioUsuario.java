package br.com.portifolio.helpdesk.Repositorios;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.portifolio.helpdesk.DAO.Conexao;
import br.com.portifolio.helpdesk.IRepositorios.IRepositorioUsuario;


@SuppressWarnings("serial")
public class RepositorioUsuario<T> implements IRepositorioUsuario<T>{

	private static EntityManager em = Conexao.getEntityManager();

	@Override
	public boolean salvar(T entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			
			em.getTransaction().commit();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			em.close();
		}	
	}

	@Override
	public T buscarPorId(Class<T> clazz, Serializable id) {
		
		try {
			em.getTransaction().begin();
			T entity = em.find(clazz, id);
			em.getTransaction().commit();
			return entity;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<T> buscarTodos(Class<T> clazz) {
		try {
			em.getTransaction().begin();
			StringBuilder sb = new StringBuilder();
			sb.append("select e from").append(clazz.getSimpleName()).append(" e");
			TypedQuery<T> query = em.createQuery(sb.toString(), clazz);
			em.getTransaction().commit();
			return query.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			em.close();
		}
		
	}

	@Override
	public boolean excluir(T entity) {
		
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			em.close();
		}
	}

}














