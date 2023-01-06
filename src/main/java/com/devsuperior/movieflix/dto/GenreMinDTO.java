package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.projections.GenreMinProjection;

public class GenreMinDTO {

	private Long id;
	private String name;
	
	public GenreMinDTO() {
	}

	public GenreMinDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	};
	
	public GenreMinDTO(GenreMinProjection cat) {
		id = cat.getId();
		name = cat.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	};
}
