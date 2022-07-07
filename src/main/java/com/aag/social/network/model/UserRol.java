// Generated with g9.

package com.aag.social.network.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "user_rol")
@IdClass(UserRolId.class)
public class UserRol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5630721428415164602L;
   
	@Id
    private String user_uuid;

    @Id
    private String rol_uuid;
    
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	@ManyToOne(optional = false)
	@Id
	@JoinColumn(name = "rol_id", nullable = false)
	@JsonBackReference(value="user-rol-rol")
	private Rol rol;

	@ManyToOne(optional = false)
	@Id
	@JoinColumn(name = "user_id", nullable = false)
	@JsonBackReference(value="user-rol-user")
	private User user;

	/** Default constructor. */
	public UserRol() {
		super();
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
	 * Access method for rol.
	 *
	 * @return the current value of rol
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * Setter method for rol.
	 *
	 * @param aRol the new value for rol
	 */
	public void setRol(Rol aRol) {
		rol = aRol;
	}

	/**
	 * Access method for user.
	 *
	 * @return the current value of user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Setter method for user.
	 *
	 * @param aUser the new value for user
	 */
	public void setUser(User aUser) {
		user = aUser;
	}

	/** Temporary value holder for group key fragment userUuid */
	private transient String tempUserUuid;

	/**
	 * Gets the key fragment uuid for member user. If this.user is null, a temporary
	 * stored value for the key fragment will be returned. The temporary value is
	 * set by setUserUuid. This behavior is required by some persistence libraries
	 * to allow fetching of objects in arbitrary order.
	 *
	 * @return Current (or temporary) value of the key fragment
	 * @see User
	 */
	public String getUserUuid() {
		return (getUser() == null ? tempUserUuid : getUser().getUuid());
	}

	/**
	 * Sets the key fragment uuid from member user. If this.user is null, the passed
	 * value will be temporary stored, and returned by subsequent calls to
	 * getUserUuid. This behaviour is required by some persistence libraries to
	 * allow fetching of objects in arbitrary order.
	 *
	 * @param aUuid New value for the key fragment
	 * @see User
	 */
	public void setUserUuid(String aUuid) {
		if (getUser() == null) {
			tempUserUuid = aUuid;
		} else {
			getUser().setUuid(aUuid);
		}
	}

	/** Temporary value holder for group key fragment rolUuid */
	private transient String tempRolUuid;

	/**
	 * Gets the key fragment uuid for member rol. If this.rol is null, a temporary
	 * stored value for the key fragment will be returned. The temporary value is
	 * set by setRolUuid. This behavior is required by some persistence libraries to
	 * allow fetching of objects in arbitrary order.
	 *
	 * @return Current (or temporary) value of the key fragment
	 * @see Rol
	 */
	public String getRolUuid() {
		return (getRol() == null ? tempRolUuid : getRol().getUuid());
	}

	/**
	 * Sets the key fragment uuid from member rol. If this.rol is null, the passed
	 * value will be temporary stored, and returned by subsequent calls to
	 * getRolUuid. This behaviour is required by some persistence libraries to allow
	 * fetching of objects in arbitrary order.
	 *
	 * @param aUuid New value for the key fragment
	 * @see Rol
	 */
	public void setRolUuid(String aUuid) {
		if (getRol() == null) {
			tempRolUuid = aUuid;
		} else {
			getRol().setUuid(aUuid);
		}
	}

	/**
	 * Compares the key for this instance with another UserRol.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class UserRol and the key objects
	 *         are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserRol)) {
			return false;
		}
		UserRol that = (UserRol) other;
		Object myUserUuid = this.getUserUuid();
		Object yourUserUuid = that.getUserUuid();
		if (myUserUuid == null ? yourUserUuid != null : !myUserUuid.equals(yourUserUuid)) {
			return false;
		}
		Object myRolUuid = this.getRolUuid();
		Object yourRolUuid = that.getRolUuid();
		if (myRolUuid == null ? yourRolUuid != null : !myRolUuid.equals(yourRolUuid)) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another UserRol.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof UserRol))
			return false;
		return this.equalKeys(other) && ((UserRol) other).equalKeys(this);
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
		if (getUserUuid() == null) {
			i = 0;
		} else {
			i = getUserUuid().hashCode();
		}
		result = 37 * result + i;
		if (getRolUuid() == null) {
			i = 0;
		} else {
			i = getRolUuid().hashCode();
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
		StringBuffer sb = new StringBuffer("[UserRol |");
		sb.append(" userUuid=").append(getUserUuid());
		sb.append(" rolUuid=").append(getRolUuid());
		sb.append("]");
		return sb.toString();
	}
}
