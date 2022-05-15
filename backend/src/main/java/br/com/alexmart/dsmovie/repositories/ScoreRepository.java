package br.com.alexmart.dsmovie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alexmart.dsmovie.entities.Score;
import br.com.alexmart.dsmovie.entities.ScorePk;

public interface ScoreRepository extends JpaRepository<Score, ScorePk> {
	List<Score> findByIdMovieId(Long id);
}
