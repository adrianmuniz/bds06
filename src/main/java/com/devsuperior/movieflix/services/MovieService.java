package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieMinDTO;
import com.devsuperior.movieflix.projections.MovieMinProjection;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.service.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public MovieMinDTO findById(Long id) {
		//evitar lidar com o valor nulo
		Optional<MovieMinProjection> obj = repository.search1(id);
		MovieMinProjection entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MovieMinDTO(entity);
	}

}
