package com.aag.social.network.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aag.social.network.model.Post;

public interface PostRepository extends JpaRepository<Post, String> {
}
