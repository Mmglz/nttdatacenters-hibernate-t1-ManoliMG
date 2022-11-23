package com.nttdata.nttdatacenters.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Entidad abstracta AbstractEntity
 * 
 * @author manoli
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** Auditoría - usuario que actualiza. */
	private String updatedUser;

	/** Auditoría - fecha que actualiza. */
	private Date updatedDate;

	/**
	 * @return the updatedUser.
	 */
	@Column(name = "AUDIT_UPDATED_USER", nullable = false)
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param updatedUser the updatedUser to set.
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * @return the updatedDate.
	 */
	@Column(name = "AUDIT_UPDATED_DATE", nullable = false)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set.
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * Método abstracto que obtiene el ID.
	 * 
	 * @return Long
	 */
	@Transient
	public abstract Long getId();

	/**
	 * Método abstracto que establece el ID.
	 * 
	 * @param id
	 */
	public abstract void setId(final Long id);
}
