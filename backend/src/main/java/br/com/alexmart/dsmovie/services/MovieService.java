package br.com.alexmart.dsmovie.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alexmart.dsmovie.dto.MovieDTO;
import br.com.alexmart.dsmovie.entities.Movie;
import br.com.alexmart.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> movies = movieRepository.findAll(pageable);
		return movies.map(movie -> new MovieDTO(movie));
	}

	public MovieDTO findById(Long movieId) {
		Optional<Movie> movie = movieRepository.findById(movieId);
		if (movie.isEmpty()) {
			throw new ObjectNotFoundException(movieId, "Filme não encontrado");
		}
		return new MovieDTO(movie.get());
	}
}
