package com.aag.social.network.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aag.social.network.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUuid(String uuid);
}
