package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.projections.GenreMinProjection;

public interface GenreRepository extends JpaRepository<Genre, Long> {

	@Query(nativeQuery = true, value = "SELECT * "
			+ "FROM tb_genre")
	List<GenreMinProjection> search1();
}	
