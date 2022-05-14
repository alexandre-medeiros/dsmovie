package br.com.alexmart.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alexmart.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
