package br.com.alexmart.dsmovie.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alexmart.dsmovie.entities.User;
import br.com.alexmart.dsmovie.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Transactional
	public User getExistentUserOrCreateIfInexistent(String email) {
		Optional<User> user = repository.findByEmail(email);

		if (user.isPresent()) {
			return user.get();
		} else {
			return repository.saveAndFlush(new User(email));
		}
	}
}
