package br.com.alexmart.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alexmart.dsmovie.dto.MovieDTO;
import br.com.alexmart.dsmovie.dto.ScoreDTO;
import br.com.alexmart.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

	@Autowired
	private ScoreService service;

	@PutMapping
	public MovieDTO save(@RequestBody ScoreDTO score) {
		return service.save(score);
	}
}
