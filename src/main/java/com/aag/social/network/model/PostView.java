// Generated with g9.

package com.aag.social.network.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "post_view")
public class PostView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7109996410161601975L;

	@Id
	@Column(unique = true, nullable = false, length = 100)
	private String post_id;

	@Column(name = "count_view", nullable = false, precision = 10)
	private int countView;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@Column(name = "updated_at", nullable = false)
	private Date updatedAt;

	@ManyToOne(optional = false)
	@JoinColumn(name = "post_id", nullable = false, insertable = false, updatable = false)
	@JsonBackReference(value = "post-view-post")
	private Post post;

	/** Default constructor. */
	public PostView() {
		super();
	}

	/**
	 * @return the post_uuid
	 */
	public String getPost_id() {
		return post_id;
	}

	/**
	 * @param post_id the post_uuid to set
	 */
	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	/**
	 * Access method for countView.
	 *
	 * @return the current value of countView
	 */
	public int getCountView() {
		return countView;
	}

	/**
	 * Setter method for countView.
	 *
	 * @param aCountView the new value for countView
	 */
	public void setCountView(int aCountView) {
		countView = aCountView;
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
}
