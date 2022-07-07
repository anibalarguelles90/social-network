package com.aag.social.network.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aag.social.network.model.PostRequest;

public interface PostRequestRepository extends JpaRepository<PostRequest, String> {

}
