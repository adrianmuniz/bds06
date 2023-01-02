package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.GenreMinDTO;
import com.devsuperior.movieflix.projections.GenreMinProjection;
import com.devsuperior.movieflix.repositories.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository repository;
	
	@Transactional(readOnly = true)
	public List<GenreMinDTO> findAllPaged() {
		List<GenreMinProjection> list =  repository.search1();
		List<GenreMinDTO> result1 = list.stream().map( x -> new GenreMinDTO(x)).collect(Collectors.toList());
		return result1;
	}
}
