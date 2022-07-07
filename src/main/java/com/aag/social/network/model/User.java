// Generated with g9.

package com.aag.social.network.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4465861329469043199L;
	
	@Id
	@Column(unique = true, nullable = false, length = 100)
	private String uuid;

	@Column(nullable = false, length = 100)
	private String email;

	@Column(name = "first_name", nullable = false, length = 100)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 100)
	private String lastName;

	@Column(name = "second_last_name", nullable = false, length = 100)
	private String secondLastName;

	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	@OneToMany(mappedBy = "user")
	private Set<PostUser> postUser;

	@OneToMany(mappedBy = "user")
	private Set<UserRol> userRol;

	/** Default constructor. */
	public User() {
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
	 * Access method for email.
	 *
	 * @return the current value of email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter method for email.
	 *
	 * @param aEmail the new value for email
	 */
	public void setEmail(String aEmail) {
		email = aEmail;
	}

	/**
	 * Access method for firstName.
	 *
	 * @return the current value of firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter method for firstName.
	 *
	 * @param aFirstName the new value for firstName
	 */
	public void setFirstName(String aFirstName) {
		firstName = aFirstName;
	}

	/**
	 * Access method for lastName.
	 *
	 * @return the current value of lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter method for lastName.
	 *
	 * @param aLastName the new value for lastName
	 */
	public void setLastName(String aLastName) {
		lastName = aLastName;
	}

	/**
	 * Access method for secondLastName.
	 *
	 * @return the current value of secondLastName
	 */
	public String getSecondLastName() {
		return secondLastName;
	}

	/**
	 * Setter method for secondLastName.
	 *
	 * @param aSecondLastName the new value for secondLastName
	 */
	public void setSecondLastName(String aSecondLastName) {
		secondLastName = aSecondLastName;
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
	 * Access method for postUser.
	 *
	 * @return the current value of postUser
	 */
	public Set<PostUser> getPostUser() {
		return postUser;
	}

	/**
	 * Setter method for postUser.
	 *
	 * @param aPostUser the new value for postUser
	 */
	public void setPostUser(Set<PostUser> aPostUser) {
		postUser = aPostUser;
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
	 * Compares the key for this instance with another User.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class User and the key objects
	 *         are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof User)) {
			return false;
		}
		User that = (User) other;
		Object myUuid = this.getUuid();
		Object yourUuid = that.getUuid();
		if (myUuid == null ? yourUuid != null : !myUuid.equals(yourUuid)) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another User.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof User))
			return false;
		return this.equalKeys(other) && ((User) other).equalKeys(this);
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
		StringBuffer sb = new StringBuffer("[User |");
		sb.append(" uuid=").append(getUuid());
		sb.append("]");
		return sb.toString();
	}
}
