package com.nttdata.nttdatacenters.hibernate.main;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nttdata.nttdatacenters.hibernate.persistence.Customer;
import com.nttdata.nttdatacenters.hibernate.services.CustomerManagementServiceI;
import com.nttdata.nttdatacenters.hibernate.services.CustomerManagementServiceImpl;

/**
 * Clase principal
 * 
 * @author manoli
 *
 */
public class Main {
	
	/** LOGGER **/
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);
	
	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		LOG.info("TRAZA DE INICIO");
		// Apertura de sesión.
		final Session session = HibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final CustomerManagementServiceI customerService = new CustomerManagementServiceImpl(session);

		// Auditoría.
		final String updateUser = "NTT_CUSTOMER";
		final Date updateDate = new Date();

		LOG.info("Generación de clientes");
		
		// Generación de clientes.
		final Customer customer1 = new Customer();
		customer1.setName("Maria");
		customer1.setFirstSurname("Perez");
		customer1.setSecondSurname("Garcia");
		customer1.setDni("41567469H");
		customer1.setUpdatedDate(updateDate);
		customer1.setUpdatedUser(updateUser);

		final Customer customer2 = new Customer();
		customer2.setName("Pablo");
		customer2.setFirstSurname("Camacho");
		customer2.setSecondSurname("Delgado");
		customer2.setDni("85317614L");
		customer2.setUpdatedDate(updateDate);
		customer2.setUpdatedUser(updateUser);

		final Customer customer3 = new Customer();
		customer3.setName("Laura");
		customer3.setFirstSurname("Medero");
		customer3.setSecondSurname("Rodriguez");
		customer3.setDni("56841394S");
		customer3.setUpdatedDate(updateDate);
		customer3.setUpdatedUser(updateUser);

		final Customer customer4 = new Customer();
		customer4.setName("Pepe");
		customer4.setFirstSurname("Mejias");
		customer4.setSecondSurname("Roldan");
		customer4.setDni("20553274R");
		customer4.setUpdatedDate(updateDate);
		customer4.setUpdatedUser(updateUser);

		final Customer customer5 = new Customer();
		customer5.setName("Estrella");
		customer5.setFirstSurname("Lopez");
		customer5.setSecondSurname("Blanco");
		customer5.setDni("17349835F");
		customer5.setUpdatedDate(updateDate);
		customer5.setUpdatedUser(updateUser);
		
		LOG.info("Fin generación de clientes");

		LOG.info("Inicio inserciones de clientes");
		
		// Inserciones de los clientes.
		customerService.insertNewCustomer(customer1);
		customerService.insertNewCustomer(customer2);
		customerService.insertNewCustomer(customer3);
		customerService.insertNewCustomer(customer4);
		customerService.insertNewCustomer(customer5);
		
		LOG.info("Fin inserciones de clientes");
		
		LOG.info("Inicio de consultas y modificaciones de los clientes");
		
		// Consulta de todos los clientes.
		List<Customer> customersList = customerService.searchAll();
		System.out.println("Lista de todos los clientes: ");
		for (final Customer customers : customersList) {
			
			System.out.println(customers.getCustomerId() + " " + customers.getDni() + " "+ customers.getName()+ " "
					+ customers.getFirstSurname() + " "+ customers.getSecondSurname());
			System.out.println("\n");
		}

		// Actualización del nombre del cliente 4.
		customer4.setName("José");
		customerService.updateCustomer(customer4);

		// Consulta por ID.
		Customer searchId = customerService.searchById((long) 4);
		System.out.println("Consulta por ID: ");
		System.out.println(searchId);
		System.out.println("\n");

		// Eliminación del cliente 4.
		customerService.deleteCustomer(customer5);

		// Consulta por nombre y apellidos.
		List<Customer> searchNameAndSurnames = customerService.searchByNameAndSurnames("Maria", "Perez", "Garcia");
		System.out.println("Consulta por nombre y apellidos:");
		System.out.println(searchNameAndSurnames);
		
		LOG.info("Fin de consultas y modificaciones de los clientes");
		
		// Cierre de sesión.
		session.close();
		
		LOG.info("TRAZA DE FIN");
	}
}
