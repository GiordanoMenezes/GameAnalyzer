package com.giordano.gameanalyzerapi.domain.repositories;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.giordano.gameanalyzerapi.domain.model.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

	@Query("SELECT obj FROM Record obj WHERE "
			+ "(:min IS NULL OR obj.moment>=:min) AND"
			+ "(:max IS NULL OR obj.moment<=:max)")
	Page<Record> getRecordsByMoments(LocalDateTime min, LocalDateTime max, Pageable pageable);

}
