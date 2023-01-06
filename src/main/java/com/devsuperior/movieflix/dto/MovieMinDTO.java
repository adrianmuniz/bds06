package com.devsuperior.movieflix.dto;

import java.util.Objects;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.projections.MovieMinProjection;

public class MovieMinDTO {

	private Long id;
	private String title;
	private String subTitle;
	private Integer year;
	private String imgUrl;
	private String synopsis;
	private GenreMinDTO genre;
	
	public MovieMinDTO() {
		
	}

	public MovieMinDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis,
			GenreMinDTO genre) {
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.year = year;
		this.imgUrl = imgUrl;
		this.synopsis = synopsis;
		this.genre = genre;
	}

	public MovieMinDTO(Movie entity) {
		id = entity.getId();
		title = entity.getTitle();
		subTitle = entity.getSubTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		synopsis = entity.getSynopsis();
	}
	
	public MovieMinDTO(MovieMinProjection projection) {
		id = projection.getId();
		title = projection.getTitle();
		subTitle = projection.getSubTitle();
		year = projection.getYear();
		imgUrl = projection.getImgUrl();
		synopsis = projection.getSynopsis();
		genre = new GenreMinDTO(projection.getGenreId(), projection.getGenreName());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	public GenreMinDTO getGenre() {
		return genre;
	}

	public void setGenre(GenreMinDTO genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieMinDTO other = (MovieMinDTO) obj;
		return Objects.equals(id, other.id);
	};
}
