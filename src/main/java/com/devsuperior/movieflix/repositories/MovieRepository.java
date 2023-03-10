package com.devsuperior.movieflix.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.dto.MovieReviewDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.projections.MovieMinProjection;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query(nativeQuery = true, value = "SELECT movies.id, movies.img_url as imgUrl, movies.sub_title as subTitle, movies.synopsis, movies.title, movies.year, genres.id as genreId, genres.name as genreName FROM tb_movie movies "
			+ "INNER JOIN tb_genre genres ON movies.genre_id = genres.id "
			+ "WHERE movies.id = :id")
	Optional<MovieMinProjection> search1(Long id);
	
	@Query("SELECT obj FROM Movie obj INNER JOIN obj.genre genres WHERE "
			+ "(:genre IS NULL OR :genre IN genres) "
			+ "ORDER BY obj.title ASC")
	Page<Movie> find(Genre genre, Pageable pageable);
	
	@Query("SELECT new com.devsuperior.movieflix.dto.MovieReviewDTO(obj) FROM Review obj "
			+ "INNER JOIN User user ON obj.user.id = user.id "
			+ "WHERE obj.movie.id = :id")
	List<MovieReviewDTO> findReviewsByMovie(Long id);
}	
