package com.nttdata.nttdatacenters.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Implementación del DAO de Customer
 * 
 * @author manoli
 *
 */
public class CustomerDaoImpl extends CommonDaoImpl<Customer> implements CustomerDaoI {

	/** Sesión de conexión a la BBDD. */
	private Session session;

	/**
	 * Método constructor
	 */
	public CustomerDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> searchByNameAndSurnames(final String name, final String firstSurname,
			final String secondSurname) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Busca los clientes por nombre y apellidos.
		return session.createQuery("FROM Customer WHERE NAME='" + name + "' AND FIRST_SURNAME='" + firstSurname + "' AND SECOND_SURNAME='" + secondSurname + "'").list();
	}
}
