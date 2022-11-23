package com.nttdata.nttdatacenters.hibernate.persistence;

import java.util.List;

/**
 * Interfaz del DAO de Customer
 * 
 * @author manoli
 *
 */
public interface CustomerDaoI extends CommonDaoI<Customer>{
	
	/**
	 * Método que busca un cliente por nombre y apellidos.
	 * 
	 * @param name
	 * @param firstSurname
	 * @param secondSurname
	 * @return Customer
	 */
	public List <Customer> searchByNameAndSurnames(final String name, final String firstSurname, final String secondSurname);

}