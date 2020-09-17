package com.giordano.gameanalyzerapi.domain.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giordano.gameanalyzerapi.api.DTO.RecordDTO;
import com.giordano.gameanalyzerapi.api.DTO.RecordInputDTO;
import com.giordano.gameanalyzerapi.domain.model.Game;
import com.giordano.gameanalyzerapi.domain.model.Record;
import com.giordano.gameanalyzerapi.domain.repositories.GameRepository;
import com.giordano.gameanalyzerapi.domain.repositories.RecordRepository;

@Service
public class RecordService {

	@Autowired
	private RecordRepository recordRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public Page<RecordDTO> getRecordsByMoments(LocalDateTime minDate,LocalDateTime maxDate, PageRequest page) {
		return recordRepository.getRecordsByMoments(minDate,maxDate,page).map(rec -> new RecordDTO(rec));
	}

	@Transactional
	public RecordDTO insert(RecordInputDTO rInDTO) {
		
		Record record = new Record();
		record.setAge(rInDTO.getAge());
		record.setName(rInDTO.getName());
		record.setMoment(LocalDateTime.now(ZoneId.of("Z")));
		Game game = gameRepository.getOne(rInDTO.getGameId());
		record.setGame(game);
		record = recordRepository.save(record);
		return new RecordDTO(record);
	}
}
