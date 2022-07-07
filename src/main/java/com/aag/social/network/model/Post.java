// Generated with g9.

package com.aag.social.network.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Entity(name = "post")
public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4034604674107839105L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(unique = true, nullable = false, length = 100)
	private String uuid;

	@Column(nullable = false, length = 100)
	private String message;

	@Column(nullable = false, length = 1)
	private boolean active;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	@OneToMany(mappedBy = "post")
	private Set<PostRequest> postRequest;

	@OneToMany(mappedBy = "post")
	private Set<PostUser> postUser;

	@OneToMany(mappedBy = "post")
	private Set<PostView> postView;

	/** Default constructor. */
	public Post() {
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
	 * Access method for message.
	 *
	 * @return the current value of message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter method for message.
	 *
	 * @param aMessage the new value for message
	 */
	public void setMessage(String aMessage) {
		message = aMessage;
	}

	/**
	 * Access method for active.
	 *
	 * @return true if and only if active is currently true
	 */
	public boolean getActive() {
		return active;
	}

	/**
	 * Setter method for active.
	 *
	 * @param aActive the new value for active
	 */
	public void setActive(boolean aActive) {
		active = aActive;
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
	 * Access method for postRequest.
	 *
	 * @return the current value of postRequest
	 */
	public Set<PostRequest> getPostRequest() {
		return postRequest;
	}

	/**
	 * Setter method for postRequest.
	 *
	 * @param aPostRequest the new value for postRequest
	 */
	public void setPostRequest(Set<PostRequest> aPostRequest) {
		postRequest = aPostRequest;
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
	 * Access method for postView.
	 *
	 * @return the current value of postView
	 */
	public Set<PostView> getPostView() {
		return postView;
	}

	/**
	 * Setter method for postView.
	 *
	 * @param aPostView the new value for postView
	 */
	public void setPostView(Set<PostView> apostView) {
		postView = apostView;
	}

	/**
	 * Compares the key for this instance with another Post.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class Post and the key objects
	 *         are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Post)) {
			return false;
		}
		Post that = (Post) other;
		Object myUuid = this.getUuid();
		Object yourUuid = that.getUuid();
		if (myUuid == null ? yourUuid != null : !myUuid.equals(yourUuid)) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another Post.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Post))
			return false;
		return this.equalKeys(other) && ((Post) other).equalKeys(this);
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
		StringBuffer sb = new StringBuffer("[Post |");
		sb.append(" uuid=").append(getUuid());
		sb.append("]");
		return sb.toString();
	}
}
