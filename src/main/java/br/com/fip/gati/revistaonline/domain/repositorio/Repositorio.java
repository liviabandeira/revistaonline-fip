package br.com.fip.gati.revistaonline.domain.repositorio;

import java.util.List;

/**
 * @author Marcos
 */
public interface Repositorio<T> {
	public void save(T entity);
	public void update(T entity);
	public void delete(T entity);
	public T load(Long id);
	public List<T> listAll();
}
