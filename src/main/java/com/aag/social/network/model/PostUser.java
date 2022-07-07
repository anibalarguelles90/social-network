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
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Entity(name = "post_user")
@IdClass(PostUserId.class)
public class PostUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	String user_id;

	@Id
	String post_id;

	@Column(name = "user_updated", nullable = false, length = 100)
	private String userUpdated;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	@ManyToOne(optional = false)
	@Id
	@JoinColumn(name = "post_id", nullable = false, insertable = false, updatable = false)
	@JsonBackReference(value = "post-user-post")
	private Post post;

	@ManyToOne(optional = false)
	@Id
	@JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
	@JsonBackReference(value = "post-user-user")
	private User user;

	/** Default constructor. */
	public PostUser() {
		super();
	}

	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the post_id
	 */
	public String getPost_id() {
		return post_id;
	}

	/**
	 * @param post_id the post_id to set
	 */
	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	/**
	 * Access method for userUpdated.
	 *
	 * @return the current value of userUpdated
	 */
	public String getUserUpdated() {
		return userUpdated;
	}

	/**
	 * Setter method for userUpdated.
	 *
	 * @param aUserUpdated the new value for userUpdated
	 */
	public void setUserUpdated(String aUserUpdated) {
		userUpdated = aUserUpdated;
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
	 * Access method for post.
	 *
	 * @return the current value of post
	 */
	public Post getPost() {
		return post;
	}

	/**
	 * Setter method for post.
	 *
	 * @param aPost the new value for post
	 */
	public void setPost(Post aPost) {
		post = aPost;
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

	/** Temporary value holder for group key fragment postUuid */
	private transient String tempPostUuid;

	/**
	 * Gets the key fragment uuid for member post. If this.post is null, a temporary
	 * stored value for the key fragment will be returned. The temporary value is
	 * set by setPostUuid. This behavior is required by some persistence libraries
	 * to allow fetching of objects in arbitrary order.
	 *
	 * @return Current (or temporary) value of the key fragment
	 * @see Post
	 */
	public String getPostUuid() {
		return (getPost() == null ? tempPostUuid : getPost().getUuid());
	}

	/**
	 * Sets the key fragment uuid from member post. If this.post is null, the passed
	 * value will be temporary stored, and returned by subsequent calls to
	 * getPostUuid. This behaviour is required by some persistence libraries to
	 * allow fetching of objects in arbitrary order.
	 *
	 * @param aUuid New value for the key fragment
	 * @see Post
	 */
	public void setPostUuid(String aUuid) {
		if (getPost() == null) {
			tempPostUuid = aUuid;
		} else {
			getPost().setUuid(aUuid);
		}
	}

	/**
	 * Compares the key for this instance with another PostUser.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class PostUser and the key
	 *         objects are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PostUser)) {
			return false;
		}
		PostUser that = (PostUser) other;
		Object myUserUuid = this.getUserUuid();
		Object yourUserUuid = that.getUserUuid();
		if (myUserUuid == null ? yourUserUuid != null : !myUserUuid.equals(yourUserUuid)) {
			return false;
		}
		Object myPostUuid = this.getPostUuid();
		Object yourPostUuid = that.getPostUuid();
		if (myPostUuid == null ? yourPostUuid != null : !myPostUuid.equals(yourPostUuid)) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another PostUser.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof PostUser))
			return false;
		return this.equalKeys(other) && ((PostUser) other).equalKeys(this);
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
		if (getPostUuid() == null) {
			i = 0;
		} else {
			i = getPostUuid().hashCode();
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
		StringBuffer sb = new StringBuffer("[PostUser |");
		sb.append(" userUuid=").append(getUserUuid());
		sb.append(" postUuid=").append(getPostUuid());
		sb.append("]");
		return sb.toString();
	}
}
