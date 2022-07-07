// Generated with g9.

package com.aag.social.network.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "rol")
public class Rol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8351973528837522160L;

	@Id
	@Column(unique = true, nullable = false, length = 100)
	private String uuid;

	@Column(name = "rol_name", nullable = false, length = 100)
	private String rolName;

	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	@OneToMany(mappedBy = "rol")
	private Set<UserRol> userRol;

	/** Default constructor. */
	public Rol() {
		super();
	}

	/**
	 * Access method for uuid.
	 *
	 * @return the current value of uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Setter method for uuid.
	 *
	 * @param aUuid the new value for uuid
	 */
	public void setUuid(String aUuid) {
		uuid = aUuid;
	}

	/**
	 * Access method for rolName.
	 *
	 * @return the current value of rolName
	 */
	public String getRolName() {
		return rolName;
	}

	/**
	 * Setter method for rolName.
	 *
	 * @param aRolName the new value for rolName
	 */
	public void setRolName(String aRolName) {
		rolName = aRolName;
	}

	/**
	 * Access method for createdAt.
	 *
	 * @return the current value of createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * Setter method for createdAt.
	 *
	 * @param aCreatedAt the new value for createdAt
	 */
	public void setCreatedAt(Date aCreatedAt) {
		createdAt = aCreatedAt;
	}

	/**
	 * Access method for updatedAt.
	 *
	 * @return the current value of updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * Setter method for updatedAt.
	 *
	 * @param aUpdatedAt the new value for updatedAt
	 */
	public void setUpdatedAt(Date aUpdatedAt) {
		updatedAt = aUpdatedAt;
	}

	/**
	 * Access method for userRol.
	 *
	 * @return the current value of userRol
	 */
	public Set<UserRol> getUserRol() {
		return userRol;
	}

	/**
	 * Setter method for userRol.
	 *
	 * @param aUserRol the new value for userRol
	 */
	public void setUserRol(Set<UserRol> aUserRol) {
		userRol = aUserRol;
	}

	/**
	 * Compares the key for this instance with another Rol.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class Rol and the key objects are
	 *         equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Rol)) {
			return false;
		}
		Rol that = (Rol) other;
		Object myUuid = this.getUuid();
		Object yourUuid = that.getUuid();
		if (myUuid == null ? yourUuid != null : !myUuid.equals(yourUuid)) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another Rol.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Rol))
			return false;
		return this.equalKeys(other) && ((Rol) other).equalKeys(this);
	}

	/**
	 * Returns a hash code for this instance.
	 *
	 * @return Hash code
	 */
	@Override
	public int hashCode() {
		int i;
		int result = 17;
		if (getUuid() == null) {
			i = 0;
		} else {
			i = getUuid().hashCode();
		}
		result = 37 * result + i;
		return result;
	}

	/**
	 * Returns a debug-friendly String representation of this instance.
	 *
	 * @return String representation of this instance
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[Rol |");
		sb.append(" uuid=").append(getUuid());
		sb.append("]");
		return sb.toString();
	}
}
