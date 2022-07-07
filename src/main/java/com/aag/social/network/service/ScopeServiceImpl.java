package com.aag.social.network.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aag.social.network.model.User;
import com.aag.social.network.model.UserRol;
import com.aag.social.network.repository.UserRepository;

@Service
public class ScopeServiceImpl {
	
	@Autowired
	UserRepository userRepository;

	/**
	 * Metodo para validar el alcance admin
	 * @param uuid
	 * @throws SocialNetWorkException
	 */
	public void validAdmin(String uuid) throws SocialNetWorkException {
		Optional<User> userOptional = userRepository.findById(uuid);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			Optional<UserRol> userRolOptional = user.getUserRol().stream().findFirst();
			if (userRolOptional.isPresent()) {
				UserRol userRol = userRolOptional.get();
				if (!"ADMIN".equalsIgnoreCase(userRol.getRol().getRolName())) {
					throw new SocialNetWorkException("Usuario sin permisos suficientes");
				}
			}
		} else {
			throw new SocialNetWorkException("Usuario invalido");
		}
	}
}
