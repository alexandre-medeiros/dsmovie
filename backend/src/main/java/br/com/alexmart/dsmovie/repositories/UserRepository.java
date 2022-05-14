package br.com.alexmart.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alexmart.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
