package com.aag.social.network.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aag.social.network.model.Post;
import com.aag.social.network.service.SocialNetWorkException;
import com.aag.social.network.service.SocialNetworkServiceImpl;
import com.aag.social.network.transform.JsonUtils;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(path = "/post/")
public class SocialNetworkController {

	@Autowired
	SocialNetworkServiceImpl socialNetworkServiceImpl;

	@Autowired
	JsonUtils jsonUtils;

	@ApiResponse(responseCode = "200", description = "Save the Post", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Post.class)) })
	@PostMapping(value = "/post", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> post(@RequestBody String post) throws SocialNetWorkException {
		JSONObject response = socialNetworkServiceImpl.savePost(post);
		return new ResponseEntity<>(response.toString(), HttpStatus.OK);
	}

	@ApiResponse(responseCode = "200", description = "Update the Post", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Post.class)) })
	@PutMapping(value = "/put/{uuid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> put(@PathVariable("uuid") String uuid, @RequestBody String post)
			throws SocialNetWorkException {
		JSONObject response = socialNetworkServiceImpl.updatePost(uuid, post);
		return new ResponseEntity<>(response.toString(), HttpStatus.OK);
	}

	@ApiResponse(responseCode = "200", description = "Delete the Post", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Post.class)) })
	@DeleteMapping(value = "/delete/{uuid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> delete(@PathVariable("uuid") String uuid, @RequestBody String post)
			throws SocialNetWorkException {
		JSONObject response = socialNetworkServiceImpl.deletePost(uuid, post);
		return new ResponseEntity<>(response.toString(), HttpStatus.OK);
	}

	
	@ApiResponse(responseCode = "200", description = "Found the Posts by pagination", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Post.class))) })
	@GetMapping(value = "/post", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> getAll(@RequestParam(required = false) Integer page) {
		List<JSONObject> response = socialNetworkServiceImpl.getAll(page);
		return new ResponseEntity<>(response.toString(), HttpStatus.OK);
	}

	@ApiResponse(responseCode = "200", description = "Found the Post", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Post.class)) })
	@GetMapping(value = "/post/{uuid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> getAll(@PathVariable("uuid") String uuid) throws SocialNetWorkException {
		JSONObject response = socialNetworkServiceImpl.getPost(uuid);
		return new ResponseEntity<>(response.toString(), HttpStatus.OK);
	}
}
