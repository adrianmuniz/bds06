package com.devsuperior.movieflix.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.projections.MovieMinProjection;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query(nativeQuery = true, value = "SELECT movies.id, movies.img_url, movies.sub_title, movies.synopsis, movies.title, movies.year, movies.genre_id, genres.name FROM tb_movie movies "
			+ "INNER JOIN tb_genre genres ON movies.genre_id = genres.id "
			+ "WHERE movies.id = :id")
	Optional<MovieMinProjection> search1(Long id);
}	
