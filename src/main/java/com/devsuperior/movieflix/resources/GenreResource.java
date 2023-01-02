package com.devsuperior.movieflix.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.GenreMinDTO;
import com.devsuperior.movieflix.services.GenreService;

@RestController
@RequestMapping(value = "/genres")
public class GenreResource {

	@Autowired
	private GenreService service;
	
	@PreAuthorize("hasAnyRole('MEMBER', 'VISITOR')")
	@GetMapping
	public ResponseEntity<List<GenreMinDTO>> findAll() {
		List<GenreMinDTO> list = service.findAllPaged();
		return ResponseEntity.ok().body(list);
	}
}
