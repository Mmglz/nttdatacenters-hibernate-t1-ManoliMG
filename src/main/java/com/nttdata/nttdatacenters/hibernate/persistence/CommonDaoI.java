package com.nttdata.nttdatacenters.hibernate.persistence;

import java.util.List;

/**
 * Dao genérico
 * 
 * @author manoli
 *
 * @param <T>
 */
public interface CommonDaoI<T> {
	/**
	 * Inserta un registro en la BBDD.
	 * 
	 * @param parmT
	 */
	public void insert(final T parmT);

	/**
	 * Actualiza un registro en la BBDD.
	 * 
	 * @param paramT
	 */
	public void update(final T paramT);

	/**
	 * Elimina un registro en la BBDD.
	 * 
	 * @param paramT
	 */
	public void delete(final T paramT);

	/**
	 * Busca un registro en la BBDD por el ID.
	 * 
	 * @param paramT
	 * @return
	 */
	public T searchById(final Long id);

	/**
	 * Busca todos los registros en la BBDD.
	 * 
	 * @return
	 */
	public List<T> seacrhAll();

}
