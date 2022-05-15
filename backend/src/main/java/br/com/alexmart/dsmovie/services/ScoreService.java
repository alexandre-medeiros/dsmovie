package br.com.alexmart.dsmovie.services;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.alexmart.dsmovie.dto.MovieDTO;
import br.com.alexmart.dsmovie.dto.ScoreDTO;
import br.com.alexmart.dsmovie.entities.Movie;
import br.com.alexmart.dsmovie.entities.Score;
import br.com.alexmart.dsmovie.entities.User;
import br.com.alexmart.dsmovie.repositories.MovieRepository;
import br.com.alexmart.dsmovie.repositories.ScoreRepository;

@Service
public class ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private MovieRepository movieRepository;

	@Transactional
	public MovieDTO save(ScoreDTO scoreDTO) {
		Optional<Movie> movie = movieRepository.findById(scoreDTO.getMovieId());
		User user = userService.getExistentUserOrCreateIfInexistent(scoreDTO.getEmail());

		Score score = new Score();
		score.setUser(user);
		score.setMovie(movie.get());
		score.setValue(scoreDTO.getValue());

		Score scoreSaved = scoreRepository.saveAndFlush(score);

		Set<Score> scores = movie.get().getScores();

		OptionalDouble average = scores.stream().mapToDouble(Score::getValue).average();

		movie.get().setScore(average.getAsDouble());
		movie.get().setCount(scores.size());

		Movie movieUpdated = movieRepository.save(movie.get());

		return new MovieDTO(movieUpdated);
	}
}
