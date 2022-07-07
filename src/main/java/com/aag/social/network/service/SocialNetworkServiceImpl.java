package com.aag.social.network.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aag.social.network.model.Post;
import com.aag.social.network.model.PostRequest;
import com.aag.social.network.model.PostUser;
import com.aag.social.network.model.PostView;
import com.aag.social.network.repository.PostRepository;
import com.aag.social.network.repository.PostRequestRepository;
import com.aag.social.network.repository.PostUserRepository;
import com.aag.social.network.repository.PostViewRepository;
import com.aag.social.network.repository.UserRepository;
import com.aag.social.network.transform.JsonUtils;

@Service
public class SocialNetworkServiceImpl {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	PostUserRepository postUserRepository;

	@Autowired
	PostViewRepository postViewRepository;

	@Autowired
	PostRequestRepository postRequestRepository;

	@Autowired
	ScopeServiceImpl scopeServiceImpl;

	@Autowired
	JsonUtils jsonUtils;

	/**
	 * Metodo para guardar un "post" con su "post_user"
	 * 
	 * @param post
	 * @throws SocialNetWorkException
	 * @throws JSONException
	 */
	public JSONObject savePost(String post) throws SocialNetWorkException {
		JSONObject responsePost = new JSONObject();

		JSONObject postJSONObject = new JSONObject(post);
		scopeServiceImpl.validAdmin(postJSONObject.getJSONObject("postUser").getString("user_id"));

		JSONObject postUserJSONObject = new JSONObject(postJSONObject.getJSONObject("postUser").toString());
		postJSONObject.remove("postUser");

		Post postEntity = jsonUtils.fromJsonString(postJSONObject.toString(), Post.class);
		postEntity.setActive(true);
		postEntity.setCreatedAt(new Date());
		postEntity.setUpdatedAt(new Date());
		postRepository.save(postEntity);

		JSONObject responsePostUser = savePostUser(postUserJSONObject, postEntity);

		responsePost = jsonUtils.toJSONObject(postEntity);
		responsePost.put("postUser", responsePostUser);
		return responsePost;
	}

	/**
	 * Metodo para procesar el insert de post_user
	 * 
	 * @param postUserJSONObject
	 */
	private JSONObject savePostUser(JSONObject postUserJSONObject, Post postEntity) {
		JSONObject responsePostUser = new JSONObject();

		PostUser postUserEntity = jsonUtils.fromJsonString(postUserJSONObject.toString(), PostUser.class);
		postUserEntity.setCreatedAt(new Date());
		postUserEntity.setUpdatedAt(new Date());
		postUserEntity.setUserUpdated("");
		postUserEntity.setPost_id(postEntity.getUuid());

		postUserRepository.save(postUserEntity);

		responsePostUser = jsonUtils.toJSONObject(postUserEntity);

		return responsePostUser;
	}

	/**
	 * Metodo para actualizar un post
	 * 
	 * @param uuid
	 * @param post
	 * @return
	 */
	public JSONObject updatePost(String uuid, String post) throws SocialNetWorkException {
		JSONObject responsePost = new JSONObject();

		JSONObject postJSONObject = new JSONObject(post);
		scopeServiceImpl.validAdmin(postJSONObject.getJSONObject("postUser").getString("user_updated"));

		Optional<Post> postOptional = postRepository.findById(uuid);
		Post postEntity = null;
		if (postOptional.isPresent()) {
			postEntity = postOptional.get();
			postEntity.setMessage(
					postJSONObject.has("message") ? postJSONObject.getString("message") : postEntity.getMessage());
			postEntity.setActive(postJSONObject.has("active") ? postJSONObject.getBoolean("active") : true);
			postEntity.setUpdatedAt(new Date());
			postRepository.save(postEntity);

			Optional<PostUser> postUserOptional = postEntity.getPostUser().stream().findFirst();
			if (postUserOptional.isPresent()) {
				PostUser postUser = postUserOptional.get();
				postUser.setUserUpdated(postJSONObject.getJSONObject("postUser").getString("user_updated"));
				postUserRepository.save(postUser);
			}
		}

		responsePost = jsonUtils.toJSONObject(postEntity);
		return responsePost;
	}

	/**
	 * Metodo para eliminar un post
	 * 
	 * @param uuid
	 * @param post
	 * @return
	 * @throws SocialNetWorkException
	 */
	public JSONObject deletePost(String uuid, String post) throws SocialNetWorkException {
		JSONObject responseDelete = new JSONObject();

		JSONObject postJSONObject = new JSONObject(post);
		scopeServiceImpl.validAdmin(postJSONObject.getJSONObject("postUser").getString("user_updated"));

		postJSONObject.put("active", false);

		Optional<Post> postOptional = postRepository.findById(uuid);
		Post postEntity = null;
		if (postOptional.isPresent()) {
			postEntity = postOptional.get();
			updatePost(uuid, postJSONObject.toString());
		}

		responseDelete = jsonUtils.toJSONObject(postEntity);
		return responseDelete;

	}

	/**
	 * Metodo para obtener todos los post
	 * 
	 * @param page
	 * @return
	 */
	public List<JSONObject> getAll(Integer page) {
		List<Post> posts = new ArrayList<>();
		List<JSONObject> postsResponse = new ArrayList<>();

		if (page == null) {
			posts = postRepository.findAll();
			postsResponse = posts.stream().map(user -> jsonUtils.toJSONObject(user)).collect(Collectors.toList());
		} else {
			posts = postRepository.findAll(PageRequest.of(page, 5)).getContent();
			postsResponse = posts.stream().map(user -> jsonUtils.toJSONObject(user)).collect(Collectors.toList());
		}

		processViewPostAsynchronous(posts);
		return postsResponse;
	}

	private void processViewPostAsynchronous(List<Post> posts) {
		new Thread(() -> {
			for (Post post : posts) {
				Optional<PostView> postViewOptional = post.getPostView().stream().findFirst();
				PostView postView = postViewOptional.isPresent() ? postViewOptional.get() : null;
				if (postView == null) {
					postView = new PostView();
					postView.setPost_id(post.getUuid());
					postView.setCountView(1);
					postView.setCreatedAt(new Date());
					postView.setUpdatedAt(new Date());
				} else {
					postView.setCountView(postView.getCountView() + 1);
				}

				postViewRepository.save(postView);
			}
		}).start();

	}

	/**
	 * Metodo para obtener un post
	 * 
	 * @param uuid
	 * @return
	 * @throws SocialNetWorkException
	 */
	public JSONObject getPost(String uuid) throws SocialNetWorkException {
		Optional<Post> postOptional = postRepository.findById(uuid);
		if (postOptional.isPresent()) {
			PostRequest postRequest = processRequestPostAsynchronous(postOptional.get());
			Set<PostRequest> hashSet = new HashSet<PostRequest>();
			hashSet.add(postRequest);
			
			Post post = postOptional.get();
			post.setPostRequest(hashSet);
			return jsonUtils.toJSONObject(postOptional.get());
		} else {
			throw new SocialNetWorkException("No existe el post");
		}
	}

	private PostRequest processRequestPostAsynchronous(Post post) {
		Optional<PostRequest> postRequestOptional = post.getPostRequest().stream().findFirst();
		PostRequest postRequest = postRequestOptional.isPresent() ? postRequestOptional.get() : null;
		if (postRequest == null) {
			postRequest = new PostRequest();
			postRequest.setPost_id(post.getUuid());
			postRequest.setCountRequests(1);
			postRequest.setCreatedAt(new Date());
			postRequest.setUpdatedAt(new Date());
		} else {
			postRequest.setCountRequests(postRequest.getCountRequests() + 1);
		}

		postRequestRepository.save(postRequest);
		return postRequest;
	}
}
