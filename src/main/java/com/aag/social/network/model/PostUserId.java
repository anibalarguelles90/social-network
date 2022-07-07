package com.aag.social.network.model;

import java.io.Serializable;

public class PostUserId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1519317677445878368L;

	String user_id;
	String post_id;

	/**
	 * 
	 */
	public PostUserId() {
		super();
	}

	/**
	 * @param user_id
	 * @param post_id
	 */
	public PostUserId(String user_id, String post_id) {
		super();
		this.user_id = user_id;
		this.post_id = post_id;
	}

}
