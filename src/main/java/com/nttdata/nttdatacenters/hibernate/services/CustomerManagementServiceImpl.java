package com.nttdata.nttdatacenters.hibernate.services;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import com.nttdata.nttdatacenters.hibernate.persistence.Customer;
import com.nttdata.nttdatacenters.hibernate.persistence.CustomerDaoI;
import com.nttdata.nttdatacenters.hibernate.persistence.CustomerDaoImpl;

/**
 * Implementación del servicio de cliente.
 * 
 * @author manoli
 *
 */
public class CustomerManagementServiceImpl implements CustomerManagementServiceI {

	/** DAO */
	private CustomerDaoI customerDao;

	/**
	 * Método constructor.
	 */
	public CustomerManagementServiceImpl(final Session session) {
		this.customerDao = new CustomerDaoImpl(session);
	}

	@Override
	public void insertNewCustomer(Customer newCustomer) {

		// Verificación de nulidad y existencia.
		if ((newCustomer != null && newCustomer.getCustomerId() == null)) {

			// Inserción de un nuevo cliente.
			customerDao.insert(newCustomer);
		}
	}

	@Override
	public void updateCustomer(Customer updateCustomer) {

		// Verificación de nulidad y existencia.
		if ((updateCustomer != null && updateCustomer.getCustomerId() != null)) {

			// Actualización de un cliente.
			customerDao.update(updateCustomer);
		}
	}

	@Override
	public void deleteCustomer(Customer deleteCustomer) {

		// Verificación de nulidad y existencia.
		if ((deleteCustomer != null && deleteCustomer.getCustomerId() != null)) {

			// Eliminación de un cliente.
			customerDao.delete(deleteCustomer);
		}
	}

	@Override
	public Customer searchById(final Long customerId) {
		Customer customer = null;

		// Verificación de nulidad.
		if (customerId != null) {

			// Obtención de cliente por ID.
			customer = customerDao.searchById(customerId);
		}

		return customer;
	}

	@Override
	public List<Customer> searchAll() {

		// Obtención de todos los clientes.
		return customerDao.seacrhAll();

	}

	@Override
	public List<Customer> searchByNameAndSurnames(String name, String firstSurname, String secondSurname) {

		List<Customer> customersList = new ArrayList<>();

		// Verificación de nulidad.
		if (name != null && firstSurname != null && secondSurname != null) {

			// Obtención del cliente por nombre y apellidos.
			customersList = customerDao.searchByNameAndSurnames(name, firstSurname, secondSurname);
		}

		return customersList;
	}
}
