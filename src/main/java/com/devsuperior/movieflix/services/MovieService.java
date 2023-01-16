package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieMinDTO;
import com.devsuperior.movieflix.dto.MovieReviewDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.projections.MovieMinProjection;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.service.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Transactional(readOnly = true)
	public MovieMinDTO findById(Long id) {
		//evitar lidar com o valor nulo
		Optional<MovieMinProjection> obj = repository.search1(id);
		MovieMinProjection entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MovieMinDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public Page<MovieMinDTO> findAllPaged(Long genreId, Pageable pageable) {
		Genre genre = (genreId == 0) ? null : genreRepository.getOne(genreId);
		Page<Movie> list =  repository.find(genre, pageable);
		return list.map(x -> new MovieMinDTO(x));
	}

	public List<MovieReviewDTO> findReviewsByMovie(Long id) {
		List<MovieReviewDTO> list = repository.findReviewsByMovie(id);
		//List<MovieMinDTO> result1 = list.stream().map( x -> new MovieMinDTO()).collect(Collectors.toList());
		return list;
	}
}
