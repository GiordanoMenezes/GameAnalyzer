package com.giordano.gameanalyzerapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giordano.gameanalyzerapi.domain.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
