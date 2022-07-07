package com.aag.social.network.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aag.social.network.model.PostUser;
import com.aag.social.network.model.PostUserId;

public interface PostUserRepository extends JpaRepository<PostUser, PostUserId> {
}
