package br.com.portifolio.helpdesk.IRepositorios;

import java.io.Serializable;
import java.util.List;

import br.com.portifolio.helpdesk.Entidades.Usuario;

public interface IRepositorio<T> extends Serializable {
	
	public boolean salvar(T entity);
	
	public T buscarPorId(Class<T> clazz, Serializable id);
	
	public List<T> buscarTodos(Class<T> clazz);

	public boolean excluir(T entity);

	

	

	

	

}
