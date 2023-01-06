package com.devsuperior.movieflix.projections;

public interface MovieMinProjection {

	Long getId();
	String getTitle();
	String getSubTitle();
	Integer getYear();
	String getImgUrl();
	String getSynopsis();
	Long getGenreId();
	String getGenreName();
}
