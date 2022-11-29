package com.nttdata.nttdatacenters.hibernate.services;

import java.util.List;
import com.nttdata.nttdatacenters.hibernate.persistence.Customer;

/**
 * Interface del servicio de cliente.
 * 
 * @author manoli
 *
 */
public interface CustomerManagementServiceI {

	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newCustomer
	 */
	public void insertNewCustomer(final Customer newCustomer);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updateCustomer
	 */
	public void updateCustomer(final Customer updateCustomer);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deleteCustomer
	 */
	public void deleteCustomer(final Customer deleteCustomer);

	/**
	 * Obtiene un cliente por su id.
	 * 
	 * @param CustomerId
	 * @return Customer
	 */
	public Customer searchById(final Long customerId);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<Customer>
	 */
	public List<Customer> searchAll();

	/**
	 * Obtiene un cliente por su nombre y apellidos.
	 * 
	 * @param name
	 * @param firstSurname
	 * @param secondSurname
	 * @return List <Customer>
	 */
	public List<Customer> searchByNameAndSurnames(String name, String firstSurname, String secondSurname);

}
